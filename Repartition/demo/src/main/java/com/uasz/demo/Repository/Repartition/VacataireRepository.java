package com.uasz.demo.Repository.Repartition;


import com.uasz.demo.Modele.Repartition.Vacataire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacataireRepository extends JpaRepository<Vacataire,Long> {
}
