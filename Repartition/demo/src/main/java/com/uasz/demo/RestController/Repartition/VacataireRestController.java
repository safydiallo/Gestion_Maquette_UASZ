package com.uasz.demo.RestController.Repartition;


import com.uasz.demo.Modele.Repartition.Vacataire;
import com.uasz.demo.Service.Repartition.VacataireService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vacataire")
@AllArgsConstructor
public class VacataireRestController {
    @Autowired
    private VacataireService vacataireService;

    @GetMapping
    public ResponseEntity<?> listerVac(){
        List<Vacataire> listVac=vacataireService.listerVac();
        return new ResponseEntity<>(listVac, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouterVac(@RequestBody Vacataire vacataire){
        vacataireService.ajouterVac(vacataire);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimer_vacataire(@PathVariable Long id){
        vacataireService.supprimer_vacataire(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Void> modifierVacataire(@RequestBody Vacataire vacataire, @PathVariable Long id){
        vacataireService.modifier_vacataire(vacataire,id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    public Vacataire rechercher_vacataire(@PathVariable Long id){
        return vacataireService.rechercherVac(id);
    }
}
