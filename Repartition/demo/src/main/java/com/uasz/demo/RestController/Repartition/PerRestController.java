package com.uasz.demo.RestController.Repartition;


import com.uasz.demo.Modele.Repartition.Enseignements;
import com.uasz.demo.Modele.Repartition.PER;
import com.uasz.demo.Service.Repartition.PerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/per")
public class PerRestController {
    @Autowired
    private PerService perService;

    @GetMapping
    public ResponseEntity<?> listerPer(){
        List<PER> listPER=perService.listerPer();
        return new ResponseEntity<>(listPER, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouterPer(@RequestBody PER per){
        perService.ajouterPer(per);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimer_per(@PathVariable Long id){
        perService.supprimer_per(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Void> modifierPer(@RequestBody PER per, @PathVariable Long id){
        perService.modifier_per(per,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
     @GetMapping("/rechercher/{id}")
    public PER rechercher_per(@PathVariable Long id){
        return perService.rechercherPer(id);
    }

}
