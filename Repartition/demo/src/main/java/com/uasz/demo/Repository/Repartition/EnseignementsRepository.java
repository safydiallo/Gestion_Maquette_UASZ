package com.uasz.demo.Repository.Repartition;


import com.uasz.demo.Modele.Repartition.Enseignements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignementsRepository extends JpaRepository<Enseignements,Long> {
}
