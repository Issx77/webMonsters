package org.ldv.monster.model.dao

import org.ldv.monster.model.entity.Equipe
import org.springframework.data.jpa.repository.JpaRepository

interface EquipeDAO : JpaRepository<Equipe, Long>
