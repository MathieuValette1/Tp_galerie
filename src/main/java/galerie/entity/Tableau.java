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
    
    @Column(unique=true)
    @NonNull
    private String support;
    
    @Column(unique=true)
    @NonNull
    private int largeur;
    
    @Column(unique=true)
    @NonNull
    private int hauteur;
    
    @ManyToMany(mappedBy = "tableau")
    List<Exposition> accrochages = new LinkedList<>();
    
    @OneToOne(mappedBy="tableau")
    private Transaction tansaction;
    
    @ManyToOne
    @NonNull
    private Artiste auteur;
}
