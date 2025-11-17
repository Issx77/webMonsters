package org.ldv.monster.controller.admincontrollers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController (){


    /**
     * Méthode permettant d'afficher la page d'accueil de l'application.
     * @return le chemin vers le template a partir du dossier ressources/templates (on ne marque pas le .html)
     */
    @GetMapping("/WebMonster")
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

}
