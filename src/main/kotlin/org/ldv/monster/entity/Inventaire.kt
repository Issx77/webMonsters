package org.ldv.monster.entity

import Joueur
import jakarta.persistence.*

@Entity
class Inventaire(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,

    var kube: Int,
    var badge: Int,

    @OneToOne
    @JoinColumn(name = "joueur_id")
    var joueur: Joueur? = null
)
