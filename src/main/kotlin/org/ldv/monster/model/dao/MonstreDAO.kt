package org.ldv.monster.model.dao

import org.ldv.monster.model.entity.Monstre
import org.springframework.data.repository.Repository

interface MonstreDAO : Repository<Monstre, Long> {
}