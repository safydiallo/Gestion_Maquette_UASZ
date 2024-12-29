package com.uasz.demo.RestController.Maquette;


import com.uasz.demo.Modele.Maquette.Enseignement;
import com.uasz.demo.Modele.Maquette.Filiere;
import com.uasz.demo.Service.Maquette.EnseignementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/enseignement")
public class EnseignementRestController {
    @Autowired
    private EnseignementService enseignementService;

    @GetMapping
    public ResponseEntity<?> listeEnseignement(){
        List<Enseignement> listEnseignement=enseignementService.listerEnseignement();
        return new ResponseEntity<>(listEnseignement, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouterEnseignement(@RequestBody Enseignement enseignement){
        enseignementService.ajouterEnseignement(enseignement);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimer_enseignement(@PathVariable Long id){
        enseignementService.supprimer_enseignement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Void> modifierenseignement(@RequestBody Enseignement enseignement, @PathVariable Long id){
        enseignementService.modifier_enseignement(enseignement,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/rechercher/{id}")
    public Enseignement rechercher_enseignement(@PathVariable Long id){
        return enseignementService.rechercherEnseignement(id);
    }
}
