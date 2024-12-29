package com.uasz.demo.MSMaquette.Interface;

import com.uasz.demo.MSMaquette.Modele.Maquette.EC;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="maquette-service",url="localhost:8081")
public interface ECProxy {
    @GetMapping(path = "api/ec")
    List<EC> listeEC();
    @PostMapping(path = "api/ec/ajouter")
    EC ajouterEc(@RequestBody EC ec);
    @PutMapping(path = "api/ec/modifier/{id}")
    EC modifierec(@RequestBody EC ec, @PathVariable Long id);
    @DeleteMapping(path = "api/ec/supprimer/{id}")
    EC supprimer_ec(@PathVariable Long id);
    @GetMapping(path = "api/ec/rechercher/{id}")
    EC rechercher_ec(@PathVariable Long id);

}
