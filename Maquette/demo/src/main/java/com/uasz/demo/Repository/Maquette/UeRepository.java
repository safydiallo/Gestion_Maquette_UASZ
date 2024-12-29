package com.uasz.demo.Repository.Maquette;
import com.uasz.demo.Modele.Maquette.EC;

import com.uasz.demo.Modele.Maquette.UE;
import org.hibernate.mapping.Selectable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UeRepository extends JpaRepository<UE,Long> {
    @Query("SELECT e FROM EC e WHERE e.ue = ?1 ")
    List<EC> findByUE(UE ue);
}
