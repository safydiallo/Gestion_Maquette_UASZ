package com.uasz.demo.RestController.Repartition;

import com.uasz.demo.Modele.Repartition.PER;
import com.uasz.demo.Modele.Repartition.Repartitions;
import com.uasz.demo.Service.Repartition.RepartitionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/repartitions")
public class RepartitionsRestController {
    @Autowired
    private RepartitionsService repartitionsService;

    @GetMapping
    public ResponseEntity<?> lister(){
        List<Repartitions> listRepartitions=repartitionsService.listerRepartitions();
        return new ResponseEntity<>(listRepartitions, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouterRepartitions(@RequestBody Repartitions repartitions){
        repartitionsService.ajouterRepartition(repartitions);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimer_repartitions(@PathVariable Long id){
        repartitionsService.supprimer_Ue(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Void> modifier_repartitions(@RequestBody Repartitions repartitions, @PathVariable Long id){
        repartitionsService.modifier_repartition(repartitions,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
     @GetMapping("/rechercher/{id}")
    public Repartitions rechercher_repartitions(@PathVariable Long id){
        return repartitionsService.rechercherRepartitions(id);
    }
    /*
    @GetMapping("/details/{id}")
    public ResponseEntity<?> detailsRepartitions( @PathVariable Long id ){
        Repartitions repartitions=repartitionsService.rechercherRepartitions(id);
        List<Seance> seanceList=repartitionsService.afficherLesSeances(repartitions);
        return new ResponseEntity<>(seanceList, HttpStatus.OK);
    }

     */

}
