package com.uasz.demo.MSMaquette.Interface;

import com.uasz.demo.MSMaquette.Modele.Maquette.Enseignement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="maquette-service",url="localhost:8081")
public interface EnseignementProxy {
    @GetMapping(path = "api/enseignement")
    List<Enseignement> listeEnseignement();
    @PostMapping(path = "api/enseignement/ajouter")
    Enseignement ajouterEnseignement(@RequestBody Enseignement enseignement);
    @DeleteMapping(path = "api/enseignement/supprimer/{id}")
    Enseignement supprimer_enseignement(@PathVariable Long id);
    @PutMapping(path = "api/enseignement/modifier/{id}")
    Enseignement modifierenseignement(@RequestBody Enseignement enseignement, @PathVariable Long id);
    @GetMapping(path = "api/enseignement/rechercher/{id}")
    Enseignement rechercher_enseignement(@PathVariable Long id);
}
