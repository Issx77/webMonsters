package org.ldv.monster.model.dao

import org.ldv.monster.model.entity.Capacite
import org.springframework.data.jpa.repository.JpaRepository

interface CapaciteDAO : JpaRepository<Capacite, Long>
