package com.uasz.demo.MS_Emploi.Interface;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.uasz.demo.MS_Emploi.Modele.Emploi.Emploi;
import com.uasz.demo.MS_Emploi.Modele.Emploi.Seance;

import java.util.List;

@FeignClient(name="emploiDuTemps-service", url = "localhost:8083")
public interface EmploiProxy {
    @GetMapping(path = "api/emploi")
    List<Emploi> Lister_emploi();
    @PostMapping(path ="api/emploi/ajouter")
    Emploi ajouterEmploi(@RequestBody Emploi emploi);
    @PutMapping(path="api/emploi/modifier/{id}")
    Emploi modifieremploi(@RequestBody Emploi emploi, @PathVariable Long id);
    @DeleteMapping(path = "api/emploi/supprimer/{id}")
    Emploi supprimer_emploi(@PathVariable Long id);
    @GetMapping(path="api/emploi/details/{id}")
    Emploi detailsEmploi(@PathVariable Long id );
    @GetMapping(path = "api/emploi/rechercher/{id}")
    Emploi rechercher_emploi(@PathVariable Long id);
    @GetMapping(path="api/emploi/afficherLesSeances")
    List<Seance> afficherLesSeances(@RequestBody Emploi emploi);
}
