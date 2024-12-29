package com.uasz.demo.MSMaquette.Interface;

import com.uasz.demo.MSMaquette.Modele.Maquette.Maquette;
import com.uasz.demo.MSMaquette.Modele.Maquette.Module;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="maquette-service",url="localhost:8081")
public interface MaquetteProxy {
    @GetMapping(path = "/maquette/api/maquette")
    List<Maquette> listerMaquette();
    @PostMapping(path = "/maquette/api/maquette/ajouter")
    Maquette ajouterMaquette(@RequestBody Maquette maquette);
    @DeleteMapping(path = "/maquette/api/maquette/supprimer/{id}")
    Maquette supprimer_Maquette(@PathVariable Long id);
    @PutMapping(path = "/maquette/api/maquette/modifier/{id}")
    Maquette modifiermaquette(@RequestBody Maquette maquette, @PathVariable Long id);
    @GetMapping(path = "/maquette/api/maquette/details/{id}")
    List<Module> detailsMaquette(@PathVariable Long id );
    @GetMapping(path = "/maquette/api/maquette/rechercher/{id}")
    Maquette rechercher_maquette(@PathVariable Long id);
}
