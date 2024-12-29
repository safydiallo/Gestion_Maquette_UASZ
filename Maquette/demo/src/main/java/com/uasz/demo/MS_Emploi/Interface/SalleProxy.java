package com.uasz.demo.MS_Emploi.Interface;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.uasz.demo.MS_Emploi.Modele.Emploi.Salle;
@FeignClient(name="emploiDuTemps-service", url = "localhost:8083")
public interface SalleProxy {
    @GetMapping(path="api/salle")
    List<Salle> Lister_salle();
    @PostMapping(path = "api/salle/ajouter")
    Salle ajouter_salle(@RequestBody Salle salle);
    @PutMapping(path = "api/salle/modifier/{id}")
    Salle modifierUe(@RequestBody Salle salle, @PathVariable Long id);
    @DeleteMapping(path = "api/salle/supprimer/{id}")
    Salle supprimer_salle(@PathVariable Long id);
    @GetMapping(path="api/salle/rechercher/{id}")
    Salle rechercher_salle(@PathVariable Long id);
}
