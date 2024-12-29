package com.uasz.demo.Repository.Repartition;

import com.uasz.demo.Modele.Repartition.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant,Long> {
}
