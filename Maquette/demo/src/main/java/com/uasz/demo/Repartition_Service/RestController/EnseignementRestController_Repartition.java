package com.uasz.demo.Repartition_Service.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.uasz.demo.Modele.Maquette.Classe;
import com.uasz.demo.Modele.Maquette.Enseignement;
import com.uasz.demo.Repartition_Service.Modele.Enseignement_Repartition;
import com.uasz.demo.Repartition_Service.Service.EnseignementService_Repartition;


@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("maquette")
public class EnseignementRestController_Repartition {
    @Autowired
    private EnseignementService_Repartition enseignementService_Repartition;

    @GetMapping(path="/enseignements_Repartitions")
    public List<Enseignement_Repartition>  lister_Enseignement_Repartition(){
        return enseignementService_Repartition.lister_Enseignement_Repartition();
    }

    
}
