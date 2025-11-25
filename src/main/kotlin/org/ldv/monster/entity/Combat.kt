import jakarta.persistence.*
import org.ldv.monster.entity.Monstre

@Entity
class Combat(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,

    var tourActuel: Int,

    @ManyToOne
    var monstreJoueur: Monstre,

    @ManyToOne
    var monstreAdverse: Monstre
)
