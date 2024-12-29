package com.uasz.demo.MSMaquette.Interface;

import com.uasz.demo.MSMaquette.Modele.Maquette.EC;
import com.uasz.demo.MSMaquette.Modele.Maquette.UE;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="maquette-service",url="localhost:8081")
public interface UEProxy {
    @GetMapping(path="api/ue")
    List<UE> lister_ue();

    @PostMapping(path="api/ue/ajouter")
    UE ajouterUe(@RequestBody UE ue);

    @GetMapping(path = "api/ue/rechercher/{id}")
    UE rechercher_ue(@PathVariable Long id);

    @PutMapping(path = "api/ue/modifier/{id}")
    UE modifierUe(@RequestBody UE ue, @PathVariable Long id);
    
    @DeleteMapping(path="api/ue/supprimer/{id}")
    UE supprimer_Ue(@PathVariable Long id);

    @GetMapping(path = "api/ue/details/{id}")
    List<EC> detailUe(@PathVariable Long id);
}
