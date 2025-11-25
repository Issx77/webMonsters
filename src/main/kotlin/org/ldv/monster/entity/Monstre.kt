package org.ldv.monster.entity

import jakarta.persistence.*

@Entity
class Monstre(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,

    var nom: String,
    var type: String,
    var niveau: Int,
    var pointsDeVie: Int,

    @OneToMany
    var capacites: List<Capacite> = listOf()
)
