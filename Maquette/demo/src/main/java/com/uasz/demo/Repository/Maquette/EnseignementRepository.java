package com.uasz.demo.Repository.Maquette;


import com.uasz.demo.Modele.Maquette.Enseignement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignementRepository extends JpaRepository<Enseignement,Long> {
}
