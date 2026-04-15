package org.ldv.monster.model.dao

import org.ldv.monster.model.entity.Inventaire
import org.springframework.data.jpa.repository.JpaRepository

interface InventaireDAO : JpaRepository<Inventaire, Long>
