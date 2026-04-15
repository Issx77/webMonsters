package org.ldv.monster.model.entity

import jakarta.persistence.*

@Entity
class Joueur(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,

    var pseudo: String,
    var niveau: Int = 1,

    @OneToOne(mappedBy = "joueur", cascade = [CascadeType.ALL])
    var inventaire: Inventaire? = null,

    @OneToOne(mappedBy = "joueur", cascade = [CascadeType.ALL])
    var equipe: Equipe? = null,

    @OneToOne
    @JoinColumn(name = "utilisateur_id")
    var utilisateur: Utilisateur? = null
)
