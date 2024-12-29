package com.uasz.demo.MSMaquette.Interface;

import com.uasz.demo.MSMaquette.Modele.Maquette.Classe;
import com.uasz.demo.MSMaquette.Modele.Maquette.Groupe;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="maquette-service",url="localhost:8081")
public interface ClasseProxy {
    @GetMapping(path = "api/classe")
    List<Classe> listerClasse();
    @PostMapping(path = "api/classe/ajouter")
    Classe ajouterClasse(@RequestBody Classe classe);
    @PutMapping(path = "api/classe/modifier/{id}")
    Classe modifierUe(@RequestBody Classe classe, @PathVariable Long id);
    @DeleteMapping(path = "api/classe/supprimer/{id}")
    Classe supprimer_classe(@PathVariable Long id);
    @GetMapping(path = "api/classe/details/{id}")
    List<Groupe> detailsClasse(@PathVariable Long id);
    @GetMapping(path = "api/classe/rechercher/{id}")
    Classe rechercher_classe(@PathVariable Long id);
}
