package org.ldv.monster.model.dao

import org.ldv.monster.model.entity.MembreEquipe
import org.springframework.data.jpa.repository.JpaRepository

interface MembreEquipeDAO : JpaRepository<MembreEquipe, Long>
