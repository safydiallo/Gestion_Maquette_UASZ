package com.uasz.demo.RestController.Maquette;


import com.uasz.demo.Modele.Maquette.Classe;
import com.uasz.demo.Modele.Maquette.Formation;
import com.uasz.demo.Modele.Maquette.Groupe;
import com.uasz.demo.Service.Maquette.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/formation")
public class FormationRestController {
    @Autowired
    private FormationService formationService;

    @GetMapping
    public ResponseEntity<?> listeFormation(){
        List<Formation> formations=formationService.listerFormation();
        return new ResponseEntity<>(formations, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouterFormation(@RequestBody Formation formation ){
        formationService.ajouterFormation(formation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimer_formation(@PathVariable Long id){
        formationService.supprimer_formation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Void> modifierformation(@RequestBody Formation formation, @PathVariable Long id){
        formationService.modifier_formation(formation,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/details/{id}")
    public ResponseEntity<?> detailsFormation(@PathVariable Long id ){
        Formation formation=formationService.rechercherFormation(id);
        List<Classe> classeList=formationService.afficherLesClasses(formation);
        return new ResponseEntity<>(classeList, HttpStatus.OK);
    }
     @GetMapping("/rechercher/{id}")
        public Formation rechercher_formation(@PathVariable Long id){
            return formationService.rechercherFormation(id);
        }
}
