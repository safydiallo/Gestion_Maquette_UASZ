package com.uasz.demo.RestController.Emploi;


import com.uasz.demo.Modele.Emploi.Emploi;
import com.uasz.demo.Modele.Emploi.Repartition;
import com.uasz.demo.Modele.Emploi.Seance;
import com.uasz.demo.Service.Emploi.RepartitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/repartition")
public class RepartitionRestController {
    @Autowired
    private RepartitionService repartitionService;

    @GetMapping
    public ResponseEntity<?> lister(){
        List<Repartition> listRepartition=repartitionService.listerRepartition();
        return new ResponseEntity<>(listRepartition, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouterRepartition(@RequestBody Repartition repartition){
        repartitionService.ajouterRepartition(repartition);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimer_repartition(@PathVariable Long id){
        repartitionService.supprimer_repartition(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Void> modifierUe(@RequestBody Repartition repartition, @PathVariable Long id){
        repartitionService.modifier_repartition(repartition,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/rechercher/{id}")
        public Repartition rechercher_repartition(@PathVariable Long id){
            return repartitionService.rechercherRepartition(id);
        }


    @GetMapping("/details/{id}")
    public ResponseEntity<?> detailsRepartition(@PathVariable Long id ){
        Repartition repartition=repartitionService.rechercherRepartition(id);
        List<Seance> seanceList=repartitionService.afficherLesSeances(repartition);
        return new ResponseEntity<>(seanceList, HttpStatus.OK);
    }
     @GetMapping("/afficherLesSeances")
    public List<Seance> afficherLesSeances(@RequestBody Repartition repartition){
        return repartitionService.afficherLesSeances(repartition);
    }

}
