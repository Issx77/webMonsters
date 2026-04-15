package org.ldv.monster.controller.admincontrollers

import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {

    @GetMapping("/WebMonster", "/WebMonster/login")
    fun home(): String {
        return "index"
    }

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

    @GetMapping("/WebMonster/profile")
    fun profile(authentication: Authentication): String {
        val roles = authentication.authorities.map { it.authority }
        return if ("ROLE_ADMIN" in roles) "redirect:/WebMonster/admin/dashboard"
        else "redirect:/WebMonster/choix-monstre"
    }

    @GetMapping("/WebMonster/admin/dashboard")
    fun dashboard(): String {
        return "pageAdmin/dashboard"
    }
}
