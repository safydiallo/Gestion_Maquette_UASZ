package com.uasz.demo.RestController.Maquette;


import com.uasz.demo.Modele.Maquette.Classe;
import com.uasz.demo.Modele.Maquette.Cycle;
import com.uasz.demo.Modele.Maquette.Groupe;
import com.uasz.demo.Service.Maquette.ClasseService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/classe")
@AllArgsConstructor
@NoArgsConstructor
public class ClasseRestController {
    @Autowired
    private ClasseService classeService;

    @GetMapping
    public ResponseEntity<?> listerClasse(){
        List<Classe> listeClasse=classeService.listerClasse();
        return new ResponseEntity<>(listeClasse, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouterClasse(@RequestBody Classe classe){
        classeService.ajouterClasse(classe);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimer_classe(@PathVariable Long id){
        classeService.supprimer_classe(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Void> modifierUe(@RequestBody Classe classe, @PathVariable Long id){
        classeService.modifier_classe(classe,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<?> detailsClasse(@PathVariable Long id){
        Classe classe=classeService.afficherClasse(id);
        List<Groupe> listeGroupe=classeService.afficherLesGroupe(classe);
        return new ResponseEntity<>(listeGroupe, HttpStatus.OK);
    }
     @GetMapping("/rechercher/{id}")
    public Classe rechercher_classe(@PathVariable Long id){
        return classeService.rechercherClasse(id);
    }



}
