package org.ldv.monster.model.entity

import jakarta.persistence.*

@Entity
class MembreEquipe(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,

    var nomPerso: String = "",
    var niveau: Int = 1,

    @ManyToOne
    @JoinColumn(name = "monstre_id")
    var monstre: Monstre? = null,

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    var equipe: Equipe? = null
)
