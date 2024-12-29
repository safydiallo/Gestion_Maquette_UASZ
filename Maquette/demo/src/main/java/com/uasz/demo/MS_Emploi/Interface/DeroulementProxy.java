package com.uasz.demo.MS_Emploi.Interface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.uasz.demo.MS_Emploi.Modele.Emploi.Deroulement;

import java.util.List;

@FeignClient(name="emploiDuTemps-service", url = "localhost:8083")
public interface DeroulementProxy {
    @GetMapping(path="api/deroulement")
    List<Deroulement> Lister_deroulement();
    @PostMapping(path="api/deroulement/ajouter")
    Deroulement ajouterDeroulement(@RequestBody Deroulement deroulement);
    @PutMapping(path="api/deroulement/modifier/{id}")
    Deroulement modifierderoulement(@RequestBody Deroulement deroulement, @PathVariable Long id);
    @DeleteMapping(path="api/deroulement/supprimer/{id}")
    Deroulement supprimer_deroulement(@PathVariable Long id);
    @GetMapping(path="api/deroulement/rechercher/{id}")
    Deroulement rechercher_deroulement(@PathVariable Long id);
}
