package com.uasz.demo.RestController.Maquette;


import com.uasz.demo.Modele.Maquette.Filiere;
import com.uasz.demo.Modele.Maquette.Formation;
import com.uasz.demo.Service.Maquette.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/filiere")
public class FiliereRestController {
    @Autowired
    private FiliereService filiereService;

    @GetMapping
    public ResponseEntity<?> listeFiliere(){
        List<Filiere> listeFiliere=filiereService.listerFiliere();
        return new ResponseEntity<>(listeFiliere, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouterFiliere(@RequestBody Filiere filiere){
        filiereService.ajouterFiliere(filiere);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimer_filiere(@PathVariable Long id){
        filiereService.supprimer_filiere(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Void> modifierUe(@RequestBody Filiere filiere, @PathVariable Long id){
        filiereService.modifier_filiere(filiere,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<?> detailsFiliere(@PathVariable Long id){
        Filiere filiere=filiereService.rechercherFiliere(id);
        List<Formation> formationList=filiereService.afficherLesFormations(filiere);
        return new ResponseEntity<>(formationList, HttpStatus.OK);
    }

    @GetMapping("/rechercher/{id}")
    public Filiere rechercher_filiere(@PathVariable Long id){
        return filiereService.rechercherFiliere(id);
    }

}
