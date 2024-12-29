package com.uasz.demo.Repository.Emploi;


import com.uasz.demo.Modele.Emploi.Repartition;
import com.uasz.demo.Modele.Emploi.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RepartitionRepository extends JpaRepository<Repartition,Long> {
    @Query("SELECT e FROM Seance e WHERE e.repartition = ?1 ")
    List<Seance> findByRepartition(Repartition repartition);
}
