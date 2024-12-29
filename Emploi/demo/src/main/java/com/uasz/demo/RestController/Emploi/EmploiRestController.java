package com.uasz.demo.RestController.Emploi;


import com.uasz.demo.Modele.Emploi.Emploi;
import com.uasz.demo.Modele.Emploi.Seance;
import com.uasz.demo.Service.Emploi.EmploiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/emploi")
@AllArgsConstructor
public class EmploiRestController {
    @Autowired
    private EmploiService emploiService;

    @GetMapping
    public ResponseEntity<?> Lister_emploi(){
        List<Emploi> emploiList=emploiService.listerEmploi();
        return new ResponseEntity<>(emploiList, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouterEmploi(@RequestBody Emploi emploi){
        emploiService.ajouterEmploi(emploi);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimer_emploi(@PathVariable Long id){
        emploiService.supprimer_emploi(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/rechercher/{id}")
        public Emploi rechercher_emploi(@PathVariable Long id){
            return emploiService.rechercherEmploi(id);
        }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Void> modifieremploi(@RequestBody Emploi emploi, @PathVariable Long id){
        emploiService.modifier_emploi(emploi,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<?> detailsEmploi(@PathVariable Long id ){
        Emploi emploi=emploiService.rechercherEmploi(id);
        List<Seance> seanceList=emploiService.afficherLesSeances(emploi);
        return new ResponseEntity<>(seanceList, HttpStatus.OK);
    }
    @GetMapping("/afficherLesSeances")
    public List<Seance> afficherLesSeances(@RequestBody Emploi emploi){
        return emploiService.afficherLesSeances(emploi);
    }
    

}
