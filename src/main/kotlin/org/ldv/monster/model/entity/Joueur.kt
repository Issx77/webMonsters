import jakarta.persistence.*
import org.ldv.monster.model.entity.Equipe
import org.ldv.monster.model.entity.Inventaire

@Entity
class Joueur(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,

    var pseudo: String,
    var niveau: Int,

    @OneToOne(mappedBy = "joueur", cascade = [CascadeType.ALL])
    var inventaire: Inventaire? = null,

    @OneToOne(mappedBy = "joueur", cascade = [CascadeType.ALL])
    var equipe: Equipe? = null
)
