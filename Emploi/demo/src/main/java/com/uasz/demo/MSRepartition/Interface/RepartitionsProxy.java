package com.uasz.demo.MSRepartition.Interface;

import com.uasz.demo.MSRepartition.Modele.Repartitions;
import com.uasz.demo.Modele.Emploi.Repartition;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



import java.util.List;
@FeignClient(name="repartition-service",url="localhost:8082")
public interface RepartitionsProxy {
    @GetMapping(path = "api/repartitions")
    List<Repartitions> lister();
    @GetMapping(path = "repartition/repartition_Repartition")
    List<Repartition> lister_Repartition_Repartition();

    @PostMapping(path = "api/repartitions/ajouter")
    Repartitions ajouterRepartitions(@RequestBody Repartitions repartitions);
    @DeleteMapping(path="api/repartitions/supprimer/{id}")
    Repartitions supprimer_repartitions(@PathVariable Long id);
    @PutMapping(path="api/repartitions/modifier/{id}")
    Repartitions modifier_repartitions(@RequestBody Repartitions repartitions, @PathVariable Long id);
    @GetMapping(path = "api/repartitions/rechercher/{id}")
    Repartitions rechercher_repartitions(@PathVariable Long id);
}
