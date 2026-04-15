package org.ldv.monster.model.dao

import org.ldv.monster.model.entity.Joueur
import org.springframework.data.jpa.repository.JpaRepository

interface JoueurDAO : JpaRepository<Joueur, Long> {
    fun findByUtilisateurEmail(email: String): Joueur?
}
