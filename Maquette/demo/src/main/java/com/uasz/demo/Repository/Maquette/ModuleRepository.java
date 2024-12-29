package com.uasz.demo.Repository.Maquette;

import com.uasz.demo.Modele.Maquette.Enseignement;
import com.uasz.demo.Modele.Maquette.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ModuleRepository extends JpaRepository<Module,Long> {
    @Query("SELECT e FROM Enseignement e WHERE e.module = ?1 ")
    List<Enseignement> findByModule(Module module);
}
