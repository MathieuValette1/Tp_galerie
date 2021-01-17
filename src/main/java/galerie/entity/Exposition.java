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

    @Column
    @NonNull
    private String intitule;
    
    @Column
    @NonNull
    private int duree;
    
    @Column
    private LocalDate dateexpo;
    
    @ManyToOne
    @NonNull
    private Galerie organisateur;
    
    @ToString.Exclude
    @OneToMany(mappedBy = "lieu_vente", cascade = CascadeType.PERSIST)
    private List<Transactions> transactions = new LinkedList<>();
    
    @ManyToMany
    List<Tableau> oeuvres = new LinkedList<>();
    
    public float chiffreAffaire(){
        float chiffreAffaire = 0;
        for (Transactions t: transactions){
            chiffreAffaire = chiffreAffaire + t.getPrix_vente();
        
        }
        return chiffreAffaire;
    }
}
