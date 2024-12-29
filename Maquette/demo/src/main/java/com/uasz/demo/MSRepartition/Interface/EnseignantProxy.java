package com.uasz.demo.MSRepartition.Interface;


import com.uasz.demo.MSRepartition.Modele.Enseignant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(name="repartition-service",url="localhost:8082")
public interface EnseignantProxy {
    @GetMapping(path = "api/enseignant")
    List<Enseignant> listerEnseignant();
    @PostMapping(path = "api/enseignant/ajouter")
    Enseignant ajouterEnseignant(@RequestBody Enseignant enseignant);
    @PutMapping(path = "api/enseignant/modifier/{id}")
    Enseignant modifierEnseignant(@RequestBody Enseignant enseignant, @PathVariable Long id);
    @DeleteMapping(path = "api/enseignant/supprimer/{id}")
    Enseignant supprimer_enseignant(@PathVariable Long id);
    @GetMapping(path = "api/enseignant/rechercher/{id}")
    Enseignant rechercher_enseignant(@PathVariable Long id);
}
