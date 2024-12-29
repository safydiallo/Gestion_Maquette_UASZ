package com.uasz.demo.RestController.Maquette;


import com.uasz.demo.Modele.Maquette.Enseignement;
import com.uasz.demo.Modele.Maquette.Groupe;
import com.uasz.demo.Modele.Maquette.Semestre;
import com.uasz.demo.Service.Maquette.GroupeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/groupe")
@AllArgsConstructor
public class GroupeRestController {
    @Autowired
    private GroupeService groupeService;

    @GetMapping
    public ResponseEntity<?> listeGroupe(){
        List<Groupe> listGroupe=groupeService.listerGroupe();
        return new ResponseEntity<>(listGroupe, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouterGroupe(@RequestBody Groupe groupe){
        groupeService.ajouterGroupe(groupe);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimer_groupe(@PathVariable Long id){
        groupeService.supprimer_groupe(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Void> modifiergroupe(@RequestBody Groupe groupe, @PathVariable Long id){
        groupeService.modifier_groupe(groupe,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/details/{id}")
    public ResponseEntity<?> detailsGroupe( @PathVariable Long id){
        Groupe groupe=groupeService.rechercherGroupe(id);
        List<Enseignement> enseignementList=groupeService.afficherLesEnseignements(groupe);
        return new ResponseEntity<>(enseignementList, HttpStatus.OK);
    }
     @GetMapping("/rechercher/{id}")
        public Groupe rechercher_groupe(@PathVariable Long id){
            return groupeService.rechercherGroupe(id);
        }

}
