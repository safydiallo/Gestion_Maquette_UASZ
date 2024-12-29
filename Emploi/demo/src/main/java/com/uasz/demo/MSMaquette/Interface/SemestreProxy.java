package com.uasz.demo.MSMaquette.Interface;

import com.uasz.demo.MSMaquette.Modele.Maquette.Classe;
import com.uasz.demo.MSMaquette.Modele.Maquette.Module;
import com.uasz.demo.MSMaquette.Modele.Maquette.Semestre;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="maquette-service",url="localhost:8081")
public interface SemestreProxy {
    @GetMapping(path = "api/semestre")
    List<Semestre> listerSemestre();
    @PostMapping(path="api/semestre/ajouter")
    Semestre ajouterSemestre(@RequestBody Semestre semestre);

    @GetMapping(path = "api/semestre/rechercher/{id}")
    Semestre rechercher_semestre(@PathVariable Long id);
    @PutMapping(path = "api/semestre/modifier/{id}")
    Semestre modifier_semestre(@RequestBody Semestre semestre, @PathVariable Long id);
    @DeleteMapping(path = "api/semestre/supprimer/{id}")
    Semestre supprimer_semestre(@PathVariable Long id);
    @GetMapping(path = "api/semestre/detailsModule/{id}")
    List<Module> detailsSemestreModule(@PathVariable Long id );
    @GetMapping(path = "api/semestre/detailsClasse/{id}")
    List<Classe> detailsSemestreClasse(@PathVariable Long id);

}
