package com.uasz.demo.MSRepartition.Interface;


import com.uasz.demo.MSRepartition.Modele.PER;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@FeignClient(name="repartition-service",url="localhost:8082")
public interface PERProxy {
    @GetMapping(path = "api/per")
    List<PER> listerPer();
    @PostMapping(path = "api/per/ajouter")
    PER ajouterPer(@RequestBody PER per);
    @DeleteMapping(path="api/per/supprimer/{id}")
    PER supprimer_per(@PathVariable Long id);
    @PutMapping(path = "api/per/modifier/{id}")
    PER modifierPer(@RequestBody PER per, @PathVariable Long id);
    @GetMapping(path="api/per/rechercher/{id}")
    PER rechercher_per(@PathVariable Long id);

}
