package org.ldv.monster.controller

import org.ldv.monster.model.dao.EquipeDAO
import org.ldv.monster.model.dao.JoueurDAO
import org.ldv.monster.model.dao.MonstreDAO
import org.ldv.monster.model.dao.UtilisateurDAO
import org.ldv.monster.model.entity.Equipe
import org.ldv.monster.model.entity.Joueur
import org.ldv.monster.model.entity.MembreEquipe
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class JoueurController(
    val monstreDAO: MonstreDAO,
    val joueurDAO: JoueurDAO,
    val equipeDAO: EquipeDAO,
    val utilisateurDAO: UtilisateurDAO
) {

    // Retrouve ou crée le Joueur lié à l'utilisateur connecté
    private fun getOrCreateJoueur(email: String): Joueur {
        val existing = joueurDAO.findByUtilisateurEmail(email)
        if (existing != null) return existing

        val utilisateur = utilisateurDAO.findByEmail(email)!!
        val joueur = Joueur(pseudo = utilisateur.prenom, niveau = 1, utilisateur = utilisateur)
        joueurDAO.save(joueur)

        val equipe = Equipe(joueur = joueur)
        equipeDAO.save(equipe)

        return joueur
    }

    // ─── PAGE 1 : Choix du monstre ───────────────────────────────────────────

    @GetMapping("/WebMonster/choix-monstre")
    fun choixMonstre(authentication: Authentication, model: Model): String {
        val joueur = getOrCreateJoueur(authentication.name)

        model.addAttribute("monstresFeu",   monstreDAO.findByType("FEU"))
        model.addAttribute("monstresEau",   monstreDAO.findByType("EAU"))
        model.addAttribute("monstresEarth", monstreDAO.findByType("TERRE"))
        model.addAttribute("joueur", joueur)
        return "pagesClient/choix-monstre"
    }

    @PostMapping("/WebMonster/choix-monstre")
    fun choisirMonstre(
        authentication: Authentication,
        @RequestParam monstreId: Long,
        @RequestParam nomPerso: String
    ): String {
        val joueur = getOrCreateJoueur(authentication.name)
        val monstre = monstreDAO.findById(monstreId).orElse(null) ?: return "redirect:/WebMonster/choix-monstre"

        // Récupère l'équipe du joueur (créée à la connexion)
        val equipe = equipeDAO.findAll().firstOrNull { it.joueur?.id == joueur.id }
            ?: run {
                val nouvelleEquipe = Equipe(joueur = joueur)
                equipeDAO.save(nouvelleEquipe)
            }

        val membre = MembreEquipe(
            nomPerso = nomPerso.ifBlank { monstre.nom },
            niveau = 1,
            monstre = monstre,
            equipe = equipe
        )
        equipe.membres.add(membre)
        equipeDAO.save(equipe)

        return "redirect:/WebMonster/equipe"
    }

    // ─── PAGE 2 : Équipe ─────────────────────────────────────────────────────

    @GetMapping("/WebMonster/equipe")
    fun equipe(authentication: Authentication, model: Model): String {
        val joueur = getOrCreateJoueur(authentication.name)
        val equipe = equipeDAO.findAll().firstOrNull { it.joueur?.id == joueur.id }

        model.addAttribute("joueur", joueur)
        model.addAttribute("membres", equipe?.membres ?: emptyList<MembreEquipe>())
        return "pagesClient/equipe"
    }

    // ─── PAGE 3 : Salle d'attente ─────────────────────────────────────────────

    @GetMapping("/WebMonster/attente")
    fun attente(authentication: Authentication, model: Model): String {
        val joueur = getOrCreateJoueur(authentication.name)
        val equipe = equipeDAO.findAll().firstOrNull { it.joueur?.id == joueur.id }

        model.addAttribute("joueur", joueur)
        model.addAttribute("membres", equipe?.membres ?: emptyList<MembreEquipe>())
        return "pagesClient/attente"
    }
}
