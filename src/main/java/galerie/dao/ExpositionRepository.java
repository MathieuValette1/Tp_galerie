package galerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import galerie.entity.Exposition;

public interface ExpositionRepository extends JpaRepository<Exposition, Integer>{
    /**
     * Calculer le chiffre d'affaires pour une exposition
     * @param id la clé primaire de l'exposition
     * @return le chiffre d'affaires de cette exposition
     */
    @Query(
            value =
            "SELECT sum(Transactions.prix_vente) "
            + "FROM Transactions INNER JOIN Exposition ON (Transactions.lieu_vente_id = Exposition.id)"
            + "WHERE Exposition.id = :id",
            nativeQuery = true
            )
    float chiffreAffairePour(Integer id);
    
}
    

