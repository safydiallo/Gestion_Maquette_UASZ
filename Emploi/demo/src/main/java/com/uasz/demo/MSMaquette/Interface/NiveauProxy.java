package com.uasz.demo.MSMaquette.Interface;

import com.uasz.demo.MSMaquette.Modele.Maquette.Niveau;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="maquette-service",url="localhost:8081")
public interface NiveauProxy {
    @GetMapping(path = "api/niveau")
    List<Niveau> Lister_niveau();
    @PostMapping(path ="api/niveau/ajouter" )
    Niveau ajouterNiveau(@RequestBody Niveau niveau);
    @GetMapping(path="api/niveau/rechercher/{id}")
    Niveau rechercher_niveau(@PathVariable Long id);
    @DeleteMapping(path = "api/niveau/supprimer/{id}")
    Niveau supprimer_niveau(@PathVariable Long id);
    @PutMapping(path = "api/niveau/modifier/{id}")
    Niveau modifier_niveau(@RequestBody Niveau niveau, @PathVariable Long id);


}
