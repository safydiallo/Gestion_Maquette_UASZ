package com.uasz.demo.RestController.Repartition;



import com.uasz.demo.Modele.Repartition.Enseignant;
import com.uasz.demo.Service.Repartition.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/enseignant")
public class EnseignantRestController {
    @Autowired
    private EnseignantService enseignantService;

    @GetMapping
    public ResponseEntity<?> listerEnseignant(){
        List<Enseignant> listEnseignant=enseignantService.listerEnseignant();
        return new ResponseEntity<>(listEnseignant, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouterEnseignant(@RequestBody Enseignant enseignant){
        enseignantService.ajouterEnseignant(enseignant);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimer_enseignant(@PathVariable Long id){
        enseignantService.supprimer_enseignant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/rechercher/{id}")
    public Enseignant rechercher_enseignant(@PathVariable Long id){
        return enseignantService.rechercherEnseignant(id);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Void> modifierUe(@RequestBody Enseignant enseignant, @PathVariable Long id){
        enseignantService.modifier_enseignant(enseignant,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
