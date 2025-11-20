package org.ldv.monster.dao

import org.ldv.monster.model.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleDAO : JpaRepository<Role, Long>{
}