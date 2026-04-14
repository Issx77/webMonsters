package org.ldv.monster.model.dao

import org.ldv.monster.model.entity.Inventaire
import org.springframework.data.repository.Repository

interface InventaireDAO : Repository<Inventaire, Long> {
}