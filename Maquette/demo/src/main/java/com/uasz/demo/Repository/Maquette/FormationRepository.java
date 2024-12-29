package com.uasz.demo.Repository.Maquette;


import com.uasz.demo.Modele.Maquette.Classe;
import com.uasz.demo.Modele.Maquette.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FormationRepository extends JpaRepository<Formation,Long> {
    @Query("SELECT e FROM Classe e WHERE e.formation = ?1 ")
    List<Classe> findByFormation(Formation formation);
}
