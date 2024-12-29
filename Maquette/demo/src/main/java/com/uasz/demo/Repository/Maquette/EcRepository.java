package com.uasz.demo.Repository.Maquette;


import com.uasz.demo.Modele.Maquette.EC;
import com.uasz.demo.Modele.Maquette.UE;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcRepository extends JpaRepository<EC,Long> {
    List<EC> findByUe(UE ue);
}
