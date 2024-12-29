package com.uasz.demo.RestController.Maquette;


import com.uasz.demo.Modele.Maquette.Classe;
import com.uasz.demo.Modele.Maquette.Semestre;
import com.uasz.demo.Modele.Maquette.UE;
import com.uasz.demo.Service.Maquette.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/semestre")
public class SemestreRestController {
    @Autowired
    private SemestreService semestreService;

    @GetMapping
    public ResponseEntity<?> listerSemestre(){
        List<Semestre> listSemestre=semestreService.listerSemestre();
        return new ResponseEntity<>(listSemestre, HttpStatus.OK);
    }

     @GetMapping("/rechercher/{id}")
        public Semestre rechercher_semestre(@PathVariable Long id){
            return semestreService.rechercherSemestre(id);
        }

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouterSemestre(@RequestBody Semestre semestre){
        semestreService.ajouterSemestre(semestre);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimer_semestre(@PathVariable Long id){
        semestreService.supprimer_semestre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Void> modifier_semestre(@RequestBody Semestre semestre, @PathVariable Long id){
        semestreService.modifier_semestre(semestre,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/detailsModule/{id}")
    public ResponseEntity<?> detailsSemestreModule(@PathVariable Long id ){
        Semestre semestre=semestreService.rechercherSemestre(id);
        List<Module> moduleList=semestreService.afficherLesModules(semestre);
        return new ResponseEntity<>(moduleList, HttpStatus.OK);
    }

    @GetMapping("/detailsClasse/{id}")
    public ResponseEntity<?> detailsSemestreClasse(@PathVariable Long id){
        Semestre semestre=semestreService.rechercherSemestre(id);
        List<Classe> classeList=semestreService.afficherLesClasses(semestre);
        return new ResponseEntity<>(classeList, HttpStatus.OK);
    }

}
