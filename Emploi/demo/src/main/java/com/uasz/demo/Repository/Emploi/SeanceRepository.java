package com.uasz.demo.Repository.Emploi;


import com.uasz.demo.Modele.Emploi.Deroulement;
import com.uasz.demo.Modele.Emploi.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface SeanceRepository extends JpaRepository<Seance,Long> {
    List<Seance> findByRepartitionId(Long repartitionId);
    @Query("SELECT e FROM Deroulement e WHERE e.seance = ?1 ")
    List<Deroulement> findBySeance(Seance seance);
}
