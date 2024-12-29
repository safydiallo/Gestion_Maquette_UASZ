package com.uasz.demo.RestController.Maquette;


import com.uasz.demo.Modele.Maquette.EC;
import com.uasz.demo.Modele.Maquette.Enseignement;
import com.uasz.demo.Service.Maquette.EcService;
import com.uasz.demo.Service.Maquette.UeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ec")
@AllArgsConstructor
public class EcRestController {
    @Autowired
    private EcService ecService;
    @Autowired
    private UeService ueService;

    @GetMapping
    public ResponseEntity<?> listeEC(){
        List<EC> ecList=ecService.listerEc();
        return new ResponseEntity<>(ecList, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouterEc(@RequestBody EC ec){
        ecService.ajouterEc(ec);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimer_ec(@PathVariable Long id){
        ecService.supprimer_ec(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Void> modifierec(@RequestBody EC ec, @PathVariable Long id){
        ecService.modifier_ec(ec,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/rechercher/{id}")
    public EC rechercher_ec(@PathVariable Long id){
        return ecService.rechercherEc(id);
    }
}
