package com.uasz.demo.MSMaquette.Interface;

import com.uasz.demo.MSMaquette.Modele.Maquette.Classe;
import com.uasz.demo.MSMaquette.Modele.Maquette.Formation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="maquette-service",url="localhost:8081")
public interface FormationProxy {
    @GetMapping(path = "api/formation")
    List<Formation> listeFormation();
    @PostMapping(path = "api/formation/ajouter")
    Formation ajouterFormation(@RequestBody Formation formation );
    @PutMapping(path = "api/formation/modifier/{id}")
    Formation modifierformation(@RequestBody Formation formation, @PathVariable Long id);
    @DeleteMapping(path = "api/formation/supprimer/{id}")
    Formation supprimer_formation(@PathVariable Long id);
    @GetMapping(path = "api/formation/details/{id}")
    List<Classe> detailsFormation(@PathVariable Long id );
    @GetMapping(path = "api/formation/rechercher/{id}")
    Formation rechercher_formation(@PathVariable Long id);

}
