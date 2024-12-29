package com.uasz.demo.Repository.Emploi;


import com.uasz.demo.Modele.Emploi.Batiment;
import com.uasz.demo.Modele.Emploi.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BatimentRepository extends JpaRepository<Batiment,Long> {
    @Query("SELECT e FROM Salle e WHERE e.batiment = ?1 ")
    List<Salle> findByBatiment(Batiment batiment);
}
