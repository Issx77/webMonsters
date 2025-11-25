package org.ldv.monster.controller.admincontrollers


import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class MainController (){


    /**
     * Méthode permettant d'afficher la page d'accueil de l'application.
     * @return le chemin vers le template a partir du dossier ressources/templates (on ne marque pas le .html)
     */
    @GetMapping("/WebMonster","/WebMonster/login")
    fun home():String{
        return "index"
    }

    @Controller
    class MainController {

        @GetMapping("/WebMonster/a-propos")
        fun aPropos(): String {
            return "pagesVisiteur/a-propos"
        }

        @GetMapping("/WebMonster/contact")
        fun contact(): String {
            return "pagesVisiteur/contact"
        }

        @GetMapping("/WebMonster/inscription")
        fun inscription(): String {
            return "pagesVisiteur/inscription"
        }


        @GetMapping("/WebMonster/rgpd")
        fun rgpd(): String {
            return "pagesVisiteur/rgpd"
        }
    }
//    @GetMapping("/WebMonster/login")
//    fun login(@RequestParam error: Boolean?, model: Model): String {
//        // Ajoute un attribut "error" au modèle si la requête contient une erreur
//        model.addAttribute("error", error == true)
//        return "pagesVisiteur/login"
//    }
    @GetMapping("/WebMonster/profile")
    fun profile(authentication: Authentication): String {

        // Récupération des rôles (authorities) de l’utilisateur connecté
        val roles = authentication.authorities.map { it.authority }

        // Si l'utilisateur est admin → redirection
        if ("ROLE_ADMIN" in roles) {
            return "redirect:/WebMonster/admin/dashboard"
        }

        // Sinon → on affiche la page profile
        return "pagesClient/profile"
    }



    @GetMapping("/WebMonster/admin/dashboard")
    fun dashboard():String{
        return "pageAdmin/dashboard"
    }



}
