package com.uasz.demo.RestController.Emploi;



import com.uasz.demo.Modele.Emploi.Deroulement;
import com.uasz.demo.Service.Emploi.DeroulementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/deroulement")
@AllArgsConstructor
public class DeroulementRestController {
    @Autowired
    private DeroulementService deroulementService;

    @GetMapping
    public ResponseEntity<List<Deroulement>> Lister_deroulement(){
        List<Deroulement> deroulementList=deroulementService.listerDeroulement();
        return new ResponseEntity<>(deroulementList, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouterDeroulement(@RequestBody Deroulement deroulement){
        deroulementService.ajouterDeroulement(deroulement);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimer_deroulement(@PathVariable Long id){
        deroulementService.supprimer_deroulement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/rechercher/{id}")
        public Deroulement rechercher_deroulement(@PathVariable Long id){
            return deroulementService.rechercherDeroulement(id);
        }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Void> modifierderoulement(@RequestBody Deroulement deroulement, @PathVariable Long id){
        deroulementService.modifier_deroulement(deroulement,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
