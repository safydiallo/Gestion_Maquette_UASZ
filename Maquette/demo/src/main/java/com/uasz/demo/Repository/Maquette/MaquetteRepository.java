package com.uasz.demo.Repository.Maquette;
import com.uasz.demo.Modele.Maquette.Maquette;
import com.uasz.demo.Modele.Maquette.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MaquetteRepository extends JpaRepository<Maquette,Long> {
    @Query("SELECT e FROM Module e WHERE e.maquette = ?1 ")
    List<Module> findByMaquette(Maquette maquette);
}
