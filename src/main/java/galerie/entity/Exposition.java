package galerie.entity;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.*;


@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity
public class Exposition {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String intitule;
    
    @Column(unique=true)
    @NonNull
    private int duree;
    
    @Column(unique=true)
    @NonNull
    private LocalDate date;
    
    @ManyToOne
    @NonNull
    private Galerie organisateur;
    
    @ToString.Exclude
    @OneToMany(mappedBy = "lieuVente", cascade = CascadeType.PERSIST)
    private List<Transaction> transactions = new LinkedList<>();
    
    @ManyToMany
    List<Tableau> oeuvres = new LinkedList<>();
}
