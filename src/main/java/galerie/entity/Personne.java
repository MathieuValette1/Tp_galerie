package galerie.entity;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import lombok.*;


@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity
public class Personne {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    private String adresse;
    
    @ToString.Exclude
    @OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST)
    private List<Transaction> transactions = new LinkedList<>();
}
