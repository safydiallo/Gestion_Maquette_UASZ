package com.uasz.demo.Repository.Emploi;

import com.uasz.demo.Modele.Emploi.Deroulement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeroulementRepository extends JpaRepository<Deroulement,Long> {
}
