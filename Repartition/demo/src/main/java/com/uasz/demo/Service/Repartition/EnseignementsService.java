package com.uasz.demo.Service.Repartition;


import com.uasz.demo.Modele.Repartition.Enseignements;
import com.uasz.demo.Repository.Repartition.EnseignementsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Transactional
@Service
public class EnseignementsService {
    @Autowired
    private EnseignementsRepository enseignementsRepository;

    public Enseignements ajouterEnseignements(Enseignements enseignements){
        enseignements.setDateCreation(new Date());
        enseignementsRepository.save(enseignements);
        return enseignements;
    }

    public List<Enseignements> listerEnseignement(){return enseignementsRepository.findAll();}

    public Enseignements rechercherEnseignements(Long id){
        return enseignementsRepository.findById(id).get();
    }

    public Enseignements modifierEnseignements(Enseignements enseignements){
        Enseignements enseignements1=rechercherEnseignements(enseignements.getId());
        enseignements1.setId(enseignements.getId());
        enseignements1.setLibelle(enseignements.getLibelle());
        enseignements1.setObjectifs(enseignements.getObjectifs());
        enseignements1.setDescription(enseignements.getDescription());
        enseignements.setDateCreation(new Date());
        return enseignementsRepository.save(enseignements1);
    }

    public Boolean supprimerEnseignements(Enseignements enseignements){
        Enseignements enseignements1=rechercherEnseignements(enseignements.getId());
        if (enseignements1 != null){
            enseignementsRepository.delete(enseignements);
            return true;
        }else{
            return false;
        }
    }

    public Enseignements modifier_enseignements(Enseignements enseignements, Long id){
        enseignements.setId(id);
        return enseignementsRepository.save(enseignements);
    }
    public void supprimer_enseignements(Long id){
        enseignementsRepository.deleteById(id);
    }
}
