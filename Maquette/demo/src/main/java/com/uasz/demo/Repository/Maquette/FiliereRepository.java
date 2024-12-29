package com.uasz.demo.Repository.Maquette;


import com.uasz.demo.Modele.Maquette.Filiere;
import com.uasz.demo.Modele.Maquette.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FiliereRepository extends JpaRepository<Filiere,Long> {
    @Query("SELECT e FROM Formation e WHERE e.filiere = ?1 ")
    List<Formation> findByFiliere(Filiere filiere);
}
