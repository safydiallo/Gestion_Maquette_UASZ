package com.uasz.demo.MSMaquette.Interface;

import com.uasz.demo.MSMaquette.Modele.Maquette.Groupe;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="maquette-service",url="localhost:8081")
public interface GroupeProxy {
    @GetMapping(path = "api/groupe")
    List<Groupe> listeGroupe();
    @PostMapping(path = "api/groupe/ajouter")
    Groupe ajouterGroupe(@RequestBody Groupe groupe);
    @DeleteMapping(path = "api/groupe/supprimer/{id}")
    Groupe supprimer_groupe(@PathVariable Long id);
    @PutMapping(path = "api/groupe/modifier/{id}")
    Groupe modifiergroupe(@RequestBody Groupe groupe, @PathVariable Long id);
    @GetMapping(path = "api/groupe/rechercher/{id}")
    Groupe rechercher_groupe(@PathVariable Long id);
}
