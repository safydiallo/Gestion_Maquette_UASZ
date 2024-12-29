package com.uasz.demo.RestController.Emploi;


import com.uasz.demo.Modele.Emploi.Salle;
import com.uasz.demo.Service.Emploi.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/salle")
public class SalleRestController {
    @Autowired
    private SalleService salleService;

    @GetMapping
    public ResponseEntity<?> Lister_salle(){
        List<Salle> salleList=salleService.listerSalle();
        return new ResponseEntity<>(salleList, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouter_salle(@RequestBody Salle salle){
        salleService.ajouterSalle(salle);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimer_salle(@PathVariable Long id){
        salleService.supprimer_salle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/rechercher/{id}")
        public Salle rechercher_salle(@PathVariable Long id){
            return salleService.rechercherSalle(id);
        }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Void> modifierUe(@RequestBody Salle salle, @PathVariable Long id){
        salleService.modifier_salle(salle,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
