package com.uasz.demo.RestController.Maquette;


import com.uasz.demo.Modele.Maquette.Maquette;
import com.uasz.demo.Modele.Maquette.Module;
import com.uasz.demo.Modele.Maquette.Semestre;
import com.uasz.demo.Service.Maquette.MaquetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/maquette")
public class MaquetteRestController {
    @Autowired
    private MaquetteService maquetteService;

    @GetMapping
    public ResponseEntity<?> listerMaquette(){
        List<Maquette> listMaquette=maquetteService.listerMaquette();
        return new ResponseEntity<>(listMaquette, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouterMaquette(@RequestBody Maquette maquette){
        maquetteService.ajouterMaquette(maquette);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimer_Maquette(@PathVariable Long id){
        maquetteService.supprimer_maquette(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Void> modifiermaquette(@RequestBody Maquette maquette, @PathVariable Long id){
        maquetteService.modifier_maquette(maquette,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<?> detailsMaquette(@PathVariable Long id ){
        Maquette maquette=maquetteService.rechercherMaquette(id);
        List<Module> moduleList=maquetteService.afficherLesModules(maquette);
        return new ResponseEntity<>(moduleList, HttpStatus.OK);
    }

    @GetMapping("/rechercher/{id}")
        public Maquette rechercher_maquette(@PathVariable Long id){
            return maquetteService.rechercherMaquette(id);
        }
}
