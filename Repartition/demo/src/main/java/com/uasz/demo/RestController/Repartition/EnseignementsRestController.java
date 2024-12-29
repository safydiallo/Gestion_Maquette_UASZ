package com.uasz.demo.RestController.Repartition;


import com.uasz.demo.Modele.Repartition.Enseignements;
import com.uasz.demo.Service.Repartition.EnseignementsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/enseignements")
public class EnseignementsRestController {
    @Autowired
    private EnseignementsService enseignementsService;

    @GetMapping
    public ResponseEntity<?> listerEnseignements() {
        List<Enseignements> listEns = enseignementsService.listerEnseignement();
        return new ResponseEntity<>(listEns, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouterEnseignements(@RequestBody Enseignements enseignements){
        enseignementsService.ajouterEnseignements(enseignements);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimer_enseignements(@PathVariable Long id){
        enseignementsService.supprimer_enseignements(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Void> modifierenseignements(@RequestBody Enseignements enseignements, @PathVariable Long id){
        enseignementsService.modifier_enseignements(enseignements,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/rechercher/{id}")
    public Enseignements rechercher_enseignements(@PathVariable Long id){
        return enseignementsService.rechercherEnseignements(id);
    }

}
