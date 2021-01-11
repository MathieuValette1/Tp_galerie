package galerie.entity;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import lombok.*;


@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity
@Inheritance(strategy = InheritanceType. TABLE_PER_CLASS)
public class Artiste  extends Personne{
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String biographie;
    
    @ToString.Exclude
    @OneToMany(mappedBy = "auteur", cascade = CascadeType.PERSIST)
    private List<Tableau> tableaux = new LinkedList<>();
}
