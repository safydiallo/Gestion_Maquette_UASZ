package com.uasz.demo.RestController.Maquette;


import com.uasz.demo.Modele.Maquette.EC;
import com.uasz.demo.Modele.Maquette.UE;
import com.uasz.demo.Service.Maquette.UeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
@RequestMapping("api/ue")
@AllArgsConstructor
public class UeRestController {
    @Autowired
    private UeService ueService;

    @GetMapping
    public ResponseEntity<?> lister_ue(){
        List<UE> ueList=ueService.listerUE();
        return new ResponseEntity<>(ueList, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Void> ajouterUe(@RequestBody UE ue){
        ueService.ajouterUE(ue);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimer_Ue(@PathVariable Long id){
        ueService.supprimer_Ue(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Void> modifierUe(@RequestBody UE ue, @PathVariable Long id){
        ueService.modifier_UE(ue,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/rechercher/{id}")
        public UE rechercher_ue(@PathVariable Long id){
            return ueService.rechercherUE(id);
        }
    

    @GetMapping("/details/{id}")
    public ResponseEntity<?> detailsUe(@PathVariable Long id ){
        UE ue=ueService.afficherUe(id);
        List<EC> ecList=ueService.afficherLesEC(ue);
        return new ResponseEntity<>(ecList, HttpStatus.OK);
    }




}
