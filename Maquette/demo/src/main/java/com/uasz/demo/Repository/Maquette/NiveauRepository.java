package com.uasz.demo.Repository.Maquette;
import com.uasz.demo.Modele.Maquette.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau,Long> {
}
