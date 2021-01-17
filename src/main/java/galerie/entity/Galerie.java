package galerie.entity;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import lombok.*;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Galerie {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String adresse;
    
    @ToString.Exclude
    @OneToMany(mappedBy = "organisateur", cascade = CascadeType.PERSIST)
    private List<Exposition> expositions = new LinkedList<>();
    
    public float cAAnnuel(int annee){
        float cAAnnuel = 0;
        for (Exposition e: expositions){
            if (e.getDateexpo().getYear() == annee){
                cAAnnuel = cAAnnuel + e.chiffreAffaire();
            }
        }
        return cAAnnuel;
    }
}
