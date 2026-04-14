import jakarta.persistence.*
import org.ldv.monster.model.entity.Monstre

@Entity
class Combat(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,

    var tourActuel: Int,




) {
    @ManyToOne
    @JoinColumn(name = "monstre_id")
    open var monstreJoueur: Monstre? = null

    @ManyToOne
    @JoinColumn(name = "monstre_id")
    open var monstreAdverse: Monstre? = null
}
