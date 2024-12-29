package com.uasz.demo.Repository.Maquette;

import com.uasz.demo.Modele.Maquette.Cycle;
import com.uasz.demo.Modele.Maquette.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CycleRepository extends JpaRepository<Cycle,Long> {
    @Query("SELECT e FROM Niveau e WHERE e.cycle = ?1 ")
    List<Niveau> findByCycle(Cycle cycle);
}
