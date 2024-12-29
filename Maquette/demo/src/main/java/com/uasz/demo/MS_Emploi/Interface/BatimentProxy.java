package com.uasz.demo.MS_Emploi.Interface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.uasz.demo.MS_Emploi.Modele.Emploi.Batiment;
import com.uasz.demo.MS_Emploi.Modele.Emploi.Salle;

import java.util.List;

@FeignClient(name="emploiDuTemps-service", url = "localhost:8083")
public interface BatimentProxy {
    @GetMapping(path = "api/batiment")
    List<Batiment> listerBatiment();
    @PostMapping(path = "api/batiment/ajouter")
    Batiment ajouterBatiment(@RequestBody Batiment batiment);
    @PutMapping(path = "api/batiment/modifier/{id}")
    Batiment modifierbatiment(@RequestBody Batiment batiment, @PathVariable Long id);
    @DeleteMapping(path = "api/batiment/supprimer/{id}")
    Batiment supprimer_batiment(@PathVariable Long id);
    @GetMapping(path = "api/batiment/details/{id}")
    List<Salle> detailsBatiment(@PathVariable Long id);
    @GetMapping(path = "api/batiment/rechercher/{id}")
    Batiment  rechercher_batiment(@PathVariable Long id);
    @GetMapping(path="api/batiment/afficherLesSalles")
    List<Salle> afficherLesSalles(@RequestBody Batiment batiment);
}
