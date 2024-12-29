package com.uasz.demo.Service.Repartition;


import com.uasz.demo.Modele.Repartition.Repartitions;
import com.uasz.demo.Repository.Repartition.RepartitionsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class RepartitionsService {
    @Autowired
    private RepartitionsRepository repartitionsRepository;
    

    public Repartitions ajouterRepartition(Repartitions repartitions){
        repartitions.setDatecreation(new Date());
        repartitionsRepository.save(repartitions);
        return repartitions;
    }

    public List<Repartitions> listerRepartitions(){return  repartitionsRepository.findAll();}

    public Repartitions rechercherRepartitions(Long id){
        return  repartitionsRepository.findById(id).get();
    }

    

    public Repartitions modifierRepartitions(Repartitions repartitions){
        Repartitions repartitions1= rechercherRepartitions(repartitions.getId());
        repartitions1.setId(repartitions.getId());
        repartitions1.setDescription(repartitions.getDescription());
        repartitions1.setDatecreation(repartitions.getDatecreation());
        repartitions.setDatecreation(new Date());
        return repartitionsRepository.save(repartitions);
    }

    public Boolean supprimerRepartitions(Repartitions repartitions){
        Repartitions repartitions1=rechercherRepartitions(repartitions.getId());
        if(repartitions != null){
            repartitionsRepository.delete(repartitions);
            return true;
        }
        else{
            return false;
        }
        
    }

    public Repartitions modifier_repartition(Repartitions repartitions, Long id){
        repartitions.setId(id);
        return repartitionsRepository.save(repartitions);
    }
    public void supprimer_Ue(Long id){
        repartitionsRepository.deleteById(id);
    }
}


