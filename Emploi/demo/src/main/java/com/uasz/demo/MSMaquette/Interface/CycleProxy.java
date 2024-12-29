package com.uasz.demo.MSMaquette.Interface;

import com.uasz.demo.MSMaquette.Modele.Maquette.Cycle;
import com.uasz.demo.MSMaquette.Modele.Maquette.Niveau;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="maquette-service",url="localhost:8081")
public interface CycleProxy {
    @GetMapping(path = "api/cycle")
    List<Cycle> listeCycle();
    @PostMapping(path = "api/cycle/ajouter")
    Cycle ajouterCycle(@RequestBody Cycle cycle);
    @PutMapping(path = "api/cycle/modifier/{id}")
    Cycle modifiercycle(@RequestBody Cycle cycle, @PathVariable Long id);
    @DeleteMapping(path = "api/cycle/supprimer/{id}")
    Cycle supprimer_cycle(@PathVariable Long id);
    @GetMapping("api/cycle/details/{id}")
    List<Niveau> detailsCycle(@PathVariable Long id);
    @GetMapping(path="api/cycle/rechercher/{id}")
    Cycle rechercher_cycle(@PathVariable Long id);

}
