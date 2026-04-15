package org.ldv.monster.model.entity

import jakarta.persistence.*

@Entity
class Equipe(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,

    @OneToMany(mappedBy = "equipe", cascade = [CascadeType.ALL], orphanRemoval = true)
    var membres: MutableList<MembreEquipe> = mutableListOf(),

    @OneToOne
    @JoinColumn(name = "joueur_id")
    var joueur: Joueur? = null
)
