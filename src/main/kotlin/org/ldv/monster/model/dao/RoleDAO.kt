package org.ldv.monster.model.dao

import org.ldv.monster.model.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleDAO : JpaRepository<Role, Long>{
}