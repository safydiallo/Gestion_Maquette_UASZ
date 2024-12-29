package com.uasz.demo.MSRepartition.Interface;


import com.uasz.demo.MSRepartition.Modele.Vacataire;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="repartition-service",url="localhost:8082")
public interface VacataireProxy {
    @GetMapping(path = "api/vacataire")
    List<Vacataire> listerVac();
    @PostMapping(path = "api/vacataire/ajouter")
    Vacataire ajouterVac(@RequestBody Vacataire vacataire);
    @PutMapping(path = "api/vacataire/modifier/{id}")
    Vacataire modifierVacataire(@RequestBody Vacataire vacataire, @PathVariable Long id);
    @DeleteMapping(path = "api/vacataire/supprimer/{id}")
    Vacataire supprimer_vacataire(@PathVariable Long id);
    @GetMapping("/rechercher/{id}")
    Vacataire rechercher_vacataire(@PathVariable Long id);

}
