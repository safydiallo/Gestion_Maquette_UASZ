package com.uasz.demo.MSMaquette.Interface;

import com.uasz.demo.MSMaquette.Modele.Maquette.Enseignement;
import com.uasz.demo.MSMaquette.Modele.Maquette.Module;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="maquette-service",url="localhost:8081")
public interface ModuleProxy {
    @GetMapping(path = "api/module")
    List<Module> listerModule();
    @PostMapping(path="api/module/ajouter")
    Module ajouterModule(@RequestBody Module module);
    @PutMapping(path = "api/module/modifier/{id}")
    Module modifier_module(@RequestBody Module module, @PathVariable Long id);
    @DeleteMapping(path = "api/module/supprimer/{id}")
    Module supprimer_module(@PathVariable Long id);
    @GetMapping(path = "api/mudule/details/{id}")
    List<Enseignement> detailsModule(@PathVariable Long id);
    @GetMapping(path="api/module/rechercher/{id}")
    Module rechercher_module(@PathVariable Long id);
}
