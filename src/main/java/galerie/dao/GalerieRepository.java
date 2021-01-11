package galerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import galerie.entity.Galerie;

// This will be AUTO IMPLEMENTED by Spring 

public interface GalerieRepository extends JpaRepository<Galerie, Integer> {
    @Query("INSERT INTO Galeri VALUES(:id, galerie1, adresse1)")
    Galerie galerie1(Integer id);
}
