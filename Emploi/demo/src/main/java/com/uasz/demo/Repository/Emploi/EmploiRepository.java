package com.uasz.demo.Repository.Emploi;


import com.uasz.demo.Modele.Emploi.Emploi;
import com.uasz.demo.Modele.Emploi.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmploiRepository extends JpaRepository<Emploi,Long> {
    @Query("SELECT e FROM Seance e WHERE e.emploi = ?1 ")
    List<Seance> findByEmploi(Emploi emploi);
}
