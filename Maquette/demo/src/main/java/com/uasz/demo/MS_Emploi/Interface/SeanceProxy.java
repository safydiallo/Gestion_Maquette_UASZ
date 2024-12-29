package com.uasz.demo.MS_Emploi.Interface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.uasz.demo.MS_Emploi.Modele.Emploi.Seance;

import java.util.List;
@FeignClient(name="emploiDuTemps-service", url = "localhost:8083")
public interface SeanceProxy {
    @GetMapping(path = "api/seance")
    List<Seance> Lister_seance();
    @PostMapping(path = "api/seance/ajouter")
    Seance  ajouter_seance(@RequestBody Seance seance);
    @PutMapping(path = "api/seance/modifier/{id}")
    Seance modifierseance(@RequestBody Seance seance, @PathVariable Long id);
    @DeleteMapping(path = "api/seance/supprimer/{id}")
    Seance supprimer_seance(@PathVariable Long id);
    @GetMapping(path="api/seance/rechercher/{id}")
    Seance rechercher_seance(@PathVariable Long id);

}
