package com.uasz.demo.MSMaquette.Interface;

import com.uasz.demo.MSMaquette.Modele.Maquette.Filiere;
import com.uasz.demo.MSMaquette.Modele.Maquette.Formation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="maquette-service",url="localhost:8081")
public interface FiliereProxy {
    @GetMapping(path = "api/filiere")
    List<Filiere> listeFiliere();
    @PostMapping(path = "api/filiere/ajouter")
    Filiere ajouterFiliere(@RequestBody Filiere filiere);
    @PutMapping(path = "api/filiere/modifier/{id}")
    Filiere modifierFiliere(@RequestBody Filiere filiere, @PathVariable Long id);
    @DeleteMapping(path = "api/filiere/supprimer/{id}")
    Filiere supprimer_filiere(@PathVariable Long id);
    @GetMapping(path = "api/filiere/details/{id}")
    List<Formation> detailsFiliere(@PathVariable Long id);
    @GetMapping(path = "api/filiere/rechercher/{id}")
    Filiere rechercher_filiere(@PathVariable Long id);
}
