package com.uasz.demo.Repository.Repartition;


import com.uasz.demo.Modele.Repartition.PER;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerRepository extends JpaRepository<PER,Long> {
}
