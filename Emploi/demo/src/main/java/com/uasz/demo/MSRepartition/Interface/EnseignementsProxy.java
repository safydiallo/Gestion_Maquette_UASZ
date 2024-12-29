package com.uasz.demo.MSRepartition.Interface;

import com.uasz.demo.MSRepartition.Modele.Enseignements;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="repartition-service",url="localhost:8082")
public interface EnseignementsProxy {
    @GetMapping(path = "api/enseignements")
    List<Enseignements> listerEnseignements();
    @PostMapping(path = "api/enseignements/ajouter")
    Enseignements ajouterEnseignements(@RequestBody Enseignements enseignements);
    @PutMapping(path = "api/enseignements/modifier/{id}")
    Enseignements modifierenseignements(@RequestBody Enseignements enseignements, @PathVariable Long id);
    @DeleteMapping(path ="api/enseignements/supprimer/{id}" )
    Enseignements supprimer_enseignements(@PathVariable Long id);
    @GetMapping(path = "api/enseignements/rechercher/{id}")
    Enseignements rechercher_enseignements(@PathVariable Long id);
}
