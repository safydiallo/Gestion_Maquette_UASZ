package com.uasz.demo.MS_Emploi.Interface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.uasz.demo.MS_Emploi.Modele.Emploi.Repartition;
import com.uasz.demo.MS_Emploi.Modele.Emploi.Seance;

import java.util.List;
@FeignClient(name="emploiDuTemps-service", url = "localhost:8083")
public interface RepartitionProxy {
    @GetMapping(path="api/repartition")
    List<Repartition> lister();
    @PostMapping(path = "api/repartition/ajouter")
    Repartition ajouterRepartition(@RequestBody Repartition repartition);
    @PutMapping(path = "api/repartition/modifier/{id}")
    Repartition modifierUe(@RequestBody Repartition repartition, @PathVariable Long id);
    @DeleteMapping(path = "api/repartition/supprimer/{id}")
    Repartition supprimer_repartition(@PathVariable Long id);
    @GetMapping(path = "api/repartition/details/{id}")
    List<Seance> detailsRepartition(@PathVariable Long id );
    @GetMapping(path = "api/repartition/rechercher/{id}")
    Repartition rechercher_repartition(@PathVariable Long id);
    @GetMapping(path="api/repartition/afficherLesSeances")
    List<Seance> afficherLesSeances(@RequestBody Repartition repartition);
}

