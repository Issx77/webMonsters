package org.ldv.monster.entity

import jakarta.persistence.*

@Entity
class Capacite(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,

    var nom: String,
    var puissance: Int,
    var type: String
)
