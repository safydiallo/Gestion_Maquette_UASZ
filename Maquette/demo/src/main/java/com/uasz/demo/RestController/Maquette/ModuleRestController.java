package com.uasz.demo.RestController.Maquette;


import com.uasz.demo.Modele.Maquette.Enseignement;
import com.uasz.demo.Modele.Maquette.Module;
import com.uasz.demo.Modele.Maquette.Niveau;
import com.uasz.demo.Service.Maquette.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/module")
public class ModuleRestController {
    @Autowired
    private ModuleService moduleService;

    @GetMapping
    public ResponseEntity<?> listerModule(){
        List<Module> listModule=moduleService.listerModule();
        return new ResponseEntity<>(listModule, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouterModule(@RequestBody Module module){
        moduleService.ajouterModule(module);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimer_module(@PathVariable Long id){
        moduleService.supprimer_module(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Void> modifier_module(@RequestBody Module module, @PathVariable Long id){
        moduleService.modifier_module(module,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<?> detailsModule(@PathVariable Long id){
        Module module=moduleService.rechercherModule(id);
        List<Enseignement> enseignementList=moduleService.afficherLesEnseignements(module);
        return new ResponseEntity<>(enseignementList, HttpStatus.OK);
    }

     @GetMapping("/rechercher/{id}")
        public Module rechercher_module(@PathVariable Long id){
            return moduleService.rechercherModule(id);
        }

}
