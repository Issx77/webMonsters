package org.ldv.monster.entity

import Joueur
import jakarta.persistence.*

@Entity
class Equipe(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,

    @OneToMany
    var membres: List<Monstre> = listOf(),

    @OneToOne
    @JoinColumn(name = "joueur_id")
    var joueur: Joueur? = null
)
