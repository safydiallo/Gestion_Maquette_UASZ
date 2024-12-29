package com.uasz.demo.RestController.Emploi;



import com.uasz.demo.Modele.Emploi.Seance;
import com.uasz.demo.Service.Emploi.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/seance")
public class SeanceRestController {
    @Autowired
    private SeanceService seanceService;

    @GetMapping
    public ResponseEntity<?> Lister_seance(){
        List<Seance> seanceList=seanceService.listerSeance();
        return new ResponseEntity<>(seanceList, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouter_seance(@RequestBody Seance seance){
        seanceService.ajouterSeance(seance);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimer_seance(@PathVariable Long id){
        seanceService.supprimer_seance(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Void> modifierseance(@RequestBody Seance seance, @PathVariable Long id){
        seanceService.modifier_seance(seance,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/rechercher/{id}")
        public Seance rechercher_seance(@PathVariable Long id){
            return seanceService.rechercherSeance(id);
        }
}
