package com.uasz.demo.Repository.Emploi;


import com.uasz.demo.Modele.Emploi.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleRepository extends JpaRepository<Salle,Long> {
}
