package com.uasz.demo.RestController.Maquette;


import com.uasz.demo.Modele.Maquette.Cycle;
import com.uasz.demo.Modele.Maquette.EC;
import com.uasz.demo.Modele.Maquette.Niveau;
import com.uasz.demo.Service.Maquette.CycleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cycle")
@AllArgsConstructor
public class CycleRestController {
    @Autowired
    private CycleService cycleService;

    @GetMapping
    public ResponseEntity<?> listeCycle(){
        List<Cycle> cycleList=cycleService.listerCycle();
        return new ResponseEntity<>(cycleList, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouterCycle(@RequestBody Cycle cycle){
        cycleService.ajouterCycle(cycle);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimer_cycle(@PathVariable Long id){
        cycleService.supprimer_cycle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Void> modifiercycle(@RequestBody Cycle cycle, @PathVariable Long id){
        cycleService.modifier_cycle(cycle,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<?> detailsCycle(@PathVariable Long id){
        Cycle cycle=cycleService.afficherCycle(id);
        List<Niveau> listNiveau=cycleService.afficherLesNiveaux(cycle);
        return new ResponseEntity<>(listNiveau, HttpStatus.OK);
    }
    @GetMapping("/rechercher/{id}")
    public Cycle rechercher_cycle(@PathVariable Long id){
        return cycleService.rechercherCycle(id);
    }
}
