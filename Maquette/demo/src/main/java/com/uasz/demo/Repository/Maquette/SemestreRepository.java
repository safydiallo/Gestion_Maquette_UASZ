package com.uasz.demo.Repository.Maquette;

import com.uasz.demo.Modele.Maquette.Classe;
import com.uasz.demo.Modele.Maquette.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SemestreRepository extends JpaRepository<Semestre,Long> {
    @Query("SELECT e FROM Module e WHERE e.semestre = ?1 ")
    List<Module> findBySemestreModule(Semestre semestre);
    @Query("SELECT e FROM Classe e WHERE e.semestre = ?1 ")
    List<Classe> findBySemestreClasse(Semestre semestre);
}
