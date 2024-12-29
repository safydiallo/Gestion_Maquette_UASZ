package com.uasz.demo.Repartition_Service.Service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.uasz.demo.Repartition_Service.Modele.Repartition_Repartition;

import com.uasz.demo.Service.Repartition.RepartitionsService;

import jakarta.transaction.Transactional;
@Transactional
@Service
public class RepartitionService_Repartition {
    
    @Autowired
    private RepartitionsService repartitionsService;

    public List<Repartition_Repartition> lister_Repartition_Repartition(){
        List<com.uasz.demo.Modele.Repartition.Repartitions> repartitions=repartitionsService.listerRepartitions();
        List<Repartition_Repartition> repartition_Repartition=new ArrayList<>();
        for(int i=0;i<repartitions.size(); i++){
            Repartition_Repartition repartition_Repartition2=new Repartition_Repartition();
            repartition_Repartition2.setId(repartitions.get(i).getId());
            repartition_Repartition2.setDescription(repartitions.get(i).getDescription());
            repartition_Repartition2.setDateCreation(repartitions.get(i).getDatecreation());
            repartition_Repartition2.setIdEnseignement(repartitions.get(i).getEnseignements().getId());
            repartition_Repartition2.setEnseignement(repartitions.get(i).getEnseignements().getLibelle());
            repartition_Repartition2.setIdEnseignant(repartitions.get(i).getEnseignant().getId());
            repartition_Repartition2.setEnseignantNom(repartitions.get(i).getEnseignant().getNom());
            repartition_Repartition2.setEnseignantPrenom(repartitions.get(i).getEnseignant().getPrenom());
            repartition_Repartition2.setIdModule(repartitions.get(i).getEnseignements().getIdModule());
            repartition_Repartition2.setCours(repartitions.get(i).getEnseignements().getCours());
            repartition_Repartition2.setCoefficient(repartitions.get(i).getEnseignements().getCoefficient());
            repartition_Repartition2.setDuree(repartitions.get(i).getEnseignements().getDuree());
            repartition_Repartition2.setIdClasse(repartitions.get(i).getEnseignements().getIdClasse());
            repartition_Repartition2.setClasse(repartitions.get(i).getEnseignements().getClasse());
            repartition_Repartition2.setEffectif(repartitions.get(i).getEnseignements().getEffectif());
            repartition_Repartition2.setCm(repartitions.get(i).getEnseignements().getCm());
            repartition_Repartition2.setTd(repartitions.get(i).getEnseignements().getTd());
            repartition_Repartition2.setTp(repartitions.get(i).getEnseignements().getTp());
            repartition_Repartition2.setUeLibelle(repartitions.get(i).getEnseignements().getUeLibelle());
            repartition_Repartition2.setNbreGroupe(repartitions.get(i).getEnseignements().getNbreGroupe());
            repartition_Repartition2.setCredit(repartitions.get(i).getEnseignements().getCredit());
            repartition_Repartition2.setSemestre(repartitions.get(i).getEnseignements().getSemestre());
            

            repartition_Repartition.add(repartition_Repartition2);
        }
        return repartition_Repartition;
    }
}
