package com.uasz.demo.Repartition_Service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.uasz.demo.Modele.Maquette.Enseignement;
import com.uasz.demo.Repartition_Service.Modele.Enseignement_Repartition;
import com.uasz.demo.Service.Maquette.EnseignementService;

import jakarta.transaction.Transactional;

import java.util.*;
@Transactional
@Service

public class EnseignementService_Repartition {
    @Autowired
    private EnseignementService enseignementService;

    public List<Enseignement_Repartition> lister_Enseignement_Repartition(){
        List<Enseignement> enseignements=enseignementService.listerEnseignement();
        List<Enseignement_Repartition> enseignement_repartitions=new ArrayList<>();
        for (int i=0; i<enseignements.size();i++){
            Enseignement_Repartition enseignement_repartition=new Enseignement_Repartition();
            enseignement_repartition.setId(enseignements.get(i).getId());
            enseignement_repartition.setLibelle(enseignements.get(i).getLibelle());
            enseignement_repartition.setObjectifs(enseignements.get(i).getObjectifs());
            enseignement_repartition.setDescription(enseignements.get(i).getDescription());
            enseignement_repartition.setDateCreation(enseignements.get(i).getDatecreation());
            enseignement_repartition.setIdModule(enseignements.get(i).getModule().getId());
            enseignement_repartition.setCours(enseignements.get(i).getModule().getCours());
            enseignement_repartition.setCoefficient(enseignements.get(i).getModule().getCoefficient());
            enseignement_repartition.setDuree(enseignements.get(i).getModule().getDuree());
            enseignement_repartition.setIdClasse(enseignements.get(i).getClasse().getId());
            enseignement_repartition.setClasse(enseignements.get(i).getClasse().getLibelle());
            enseignement_repartition.setEffectif(enseignements.get(i).getClasse().getEffectif());
            enseignement_repartition.setNbreGroupe(enseignements.get(i).getClasse().getNbreGroupe());
            if(enseignements.get(i).getModule().getEc() !=null){
                enseignement_repartition.setCm(enseignements.get(i).getModule().getEc().getCm());
                enseignement_repartition.setTd(enseignements.get(i).getModule().getEc().getTd());
                enseignement_repartition.setTp(enseignements.get(i).getModule().getEc().getTp());
            }

            if(enseignements.get(i).getModule().getUe() !=null){
                enseignement_repartition.setUeLibelle(enseignements.get(i).getModule().getUe().getLibelle());
                enseignement_repartition.setCredit(enseignements.get(i).getModule().getUe().getCredit());
            }
            
            
            
            if (enseignements.get(i).getGroupe() !=null){
                enseignement_repartition.setIdGroupe(enseignements.get(i).getGroupe().getId());
                enseignement_repartition.setLibelleGroupe(enseignements.get(i).getGroupe().getLibelle());

            }
            enseignement_repartition.setSemestre(enseignements.get(i).getClasse().getSemestre().getLibelle());
            enseignement_repartitions.add(enseignement_repartition);
        }
        return enseignement_repartitions;
    }
   
    
}
