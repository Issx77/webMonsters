package org.ldv.monster.model.dao

import org.ldv.monster.model.entity.Monstre
import org.springframework.data.jpa.repository.JpaRepository

interface MonstreDAO : JpaRepository<Monstre, Long> {
    fun findByType(type: String): List<Monstre>
}
