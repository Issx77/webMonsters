package org.ldv.monster.model.entity

import jakarta.persistence.*

@Entity
class Combat(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,

    var tourActuel: Int,

) {
    @ManyToOne
    @JoinColumn(name = "monstre_joueur_id")
    var monstreJoueur: Monstre? = null

    @ManyToOne
    @JoinColumn(name = "monstre_adverse_id")
    var monstreAdverse: Monstre? = null
}
