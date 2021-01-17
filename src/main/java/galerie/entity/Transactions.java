package galerie.entity;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDate;


@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity
public class Transactions {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column
    @NonNull
    private LocalDate dateTransac;
    
    @Column
    @NonNull
    private float prixVente;
    
    @ManyToOne
    @NonNull
    private Exposition lieuVente;
    
    @ManyToOne
    @NonNull
    private Personne client;
    
    @OneToOne
    @NonNull
    private Tableau tableau;
}
