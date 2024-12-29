package com.uasz.demo.RestController.Maquette;


import com.uasz.demo.Modele.Maquette.Niveau;
import com.uasz.demo.Modele.Maquette.Semestre;
import com.uasz.demo.Service.Maquette.NiveauService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/niveau")
@AllArgsConstructor
public class NiveauRestController {
    @Autowired
    private NiveauService niveauService;

    @GetMapping
    public ResponseEntity<?> Lister_niveau(){
        List<Niveau> niveauList=niveauService.listerNiveau();
        return new ResponseEntity<>(niveauList, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouterNiveau(@RequestBody Niveau niveau){
        niveauService.ajouterNiveau(niveau);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/rechercher/{id}")
        public Niveau rechercher_niveau(@PathVariable Long id){
            return niveauService.rechercherNiveau(id);
        }


    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimer_niveau(@PathVariable Long id){
        niveauService.supprimer_niveau(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Void> modifier_niveau(@RequestBody Niveau niveau, @PathVariable Long id){
        niveauService.modifier_niveau(niveau,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
