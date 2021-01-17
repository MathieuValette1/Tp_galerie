package galerie.entity;
import javax.persistence.*;
import lombok.*;
import java.util.*;


@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity
public class Tableau {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String titre;
    
    @Column
    @NonNull
    private String support;
    
    @Column
    @NonNull
    private int largeur;
    
    @Column
    @NonNull
    private int hauteur;
    
    @ManyToMany(mappedBy = "oeuvres")
    List<Exposition> accrochages = new LinkedList<>();
    
    @OneToOne(mappedBy="tableau")
    private Transactions transaction;
    
    @ManyToOne
    @NonNull
    private Artiste auteur;
}
