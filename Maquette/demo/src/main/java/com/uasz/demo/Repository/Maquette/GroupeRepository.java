package com.uasz.demo.Repository.Maquette;


import com.uasz.demo.Modele.Maquette.Enseignement;
import com.uasz.demo.Modele.Maquette.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GroupeRepository extends JpaRepository<Groupe,Long> {
    @Query("SELECT e FROM Enseignement e WHERE e.groupe = ?1 ")
    List<Enseignement> findByGroupe(Groupe groupe);
}
