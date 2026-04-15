package org.ldv.monster.model.dao

import org.ldv.monster.model.entity.Combat
import org.springframework.data.jpa.repository.JpaRepository

interface CombatDAO : JpaRepository<Combat, Long> {
}