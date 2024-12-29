package com.uasz.demo.Repository.Repartition;


import com.uasz.demo.MS_Emploi.Modele.Emploi.Seance;
import com.uasz.demo.Modele.Repartition.Repartitions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RepartitionsRepository extends JpaRepository<Repartitions,Long> {
    /* 
    @Query("SELECT e FROM Seance e WHERE e.repartitions = ?1 ")
    List<Seance> findByRepartitions(Repartitions repartitions);
    */
     
}
