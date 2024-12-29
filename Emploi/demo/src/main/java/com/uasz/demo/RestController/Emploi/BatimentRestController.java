package com.uasz.demo.RestController.Emploi;



import com.uasz.demo.Modele.Emploi.Batiment;
import com.uasz.demo.Modele.Emploi.Salle;
import com.uasz.demo.Service.Emploi.BatimentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/batiment")
@AllArgsConstructor
public class BatimentRestController {
    @Autowired
    private BatimentService batimentService;

    @GetMapping
    public ResponseEntity<List<Batiment>> listerBatiment(){
        List<Batiment> batimentList = batimentService.listerBatiment();
        return new ResponseEntity<>(batimentList, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouterBatiment(@RequestBody Batiment batiment) {
        batimentService.ajouterBatiment(batiment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimer_batiment(@PathVariable Long id){
        batimentService.supprimer_batiment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Void> modifierbatiment(@RequestBody Batiment batiment, @PathVariable Long id){
        batimentService.modifier_batiment(batiment,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/rechercher/{id}")
        public Batiment rechercher_batiment(@PathVariable Long id){
            return batimentService.rechercherBatiment(id);
        }

    @GetMapping("/details/{id}")
    public ResponseEntity <List<Salle>> detailsBatiment(@PathVariable Long id) {
        Batiment batiment = batimentService.rechercherBatiment(id);
        List<Salle> salleList = batimentService.afficherLesSalles(batiment);
        return new ResponseEntity<>(salleList, HttpStatus.OK);
    }
    @GetMapping("/afficherLesSalles")
    public List<Salle> afficherLesSalles(@RequestBody Batiment batiment){
        return batimentService.afficherLesSalles(batiment);
    }

}
