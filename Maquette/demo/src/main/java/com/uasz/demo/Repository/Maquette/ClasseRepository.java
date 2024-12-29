package com.uasz.demo.Repository.Maquette;


import com.uasz.demo.Modele.Maquette.Classe;
import com.uasz.demo.Modele.Maquette.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasseRepository extends JpaRepository<Classe,Long> {
    @Query("SELECT e FROM Groupe e WHERE e.classe = ?1 ")
    List<Groupe> findByClasse(Classe classe);
}

