package org.ldv.monster.service

import org.ldv.monster.model.dao.MonstreDAO
import org.ldv.monster.model.dao.RoleDAO
import org.ldv.monster.model.dao.UtilisateurDAO
import org.ldv.monster.model.entity.Monstre
import org.ldv.monster.model.entity.Role
import org.ldv.monster.model.entity.Utilisateur
import org.springframework.boot.CommandLineRunner
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class DataInitializer(
    val roleDAO: RoleDAO,
    val utilisateurDAO: UtilisateurDAO,
    val monstreDAO: MonstreDAO,
    val passwordEncoder: PasswordEncoder
) : CommandLineRunner {

    override fun run(vararg args: String?) {

        // ROLES
        val roleAdmin = Role(nom = "ADMIN")
        val roleClient = Role(nom = "CLIENT")
        roleDAO.saveAll(listOf(roleAdmin, roleClient))

        // UTILISATEURS
        val admin = Utilisateur(
            nom = "Super", prenom = "Admin",
            email = "admin@admin.com",
            mdp = passwordEncoder.encode("admin123"),
            role = roleAdmin
        )
        val client = Utilisateur(
            nom = "Jean", prenom = "Client",
            email = "client@client.com",
            mdp = passwordEncoder.encode("client123"),
            role = roleClient
        )
        utilisateurDAO.saveAll(listOf(admin, client))

        // MONSTRES — Type FEU
        val flamigon  = Monstre(nom = "Flamigon",  type = "FEU",   niveau = 1, pointsDeVie = 45)
        val pyrobyte  = Monstre(nom = "Pyrobyte",  type = "FEU",   niveau = 1, pointsDeVie = 52)
        val volcaon   = Monstre(nom = "Volcaon",   type = "FEU",   niveau = 1, pointsDeVie = 58)

        // MONSTRES — Type EAU
        val aquarex   = Monstre(nom = "Aquarex",   type = "EAU",   niveau = 1, pointsDeVie = 44)
        val hydroclaw = Monstre(nom = "Hydroclaw", type = "EAU",   niveau = 1, pointsDeVie = 50)
        val tidalon   = Monstre(nom = "Tidalon",   type = "EAU",   niveau = 1, pointsDeVie = 55)

        // MONSTRES — Type TERRE
        val terroc    = Monstre(nom = "Terroc",    type = "TERRE", niveau = 1, pointsDeVie = 45)
        val rockadon  = Monstre(nom = "Rockadon",  type = "TERRE", niveau = 1, pointsDeVie = 53)
        val geobrak   = Monstre(nom = "Geobrak",   type = "TERRE", niveau = 1, pointsDeVie = 60)

        monstreDAO.saveAll(listOf(flamigon, pyrobyte, volcaon, aquarex, hydroclaw, tidalon, terroc, rockadon, geobrak))

        println("✅ Init : ${roleDAO.count()} rôles, ${utilisateurDAO.count()} utilisateurs, ${monstreDAO.count()} monstres.")
    }
}
