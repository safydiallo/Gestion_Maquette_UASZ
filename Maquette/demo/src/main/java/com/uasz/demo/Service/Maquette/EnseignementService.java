package com.uasz.demo.Service.Maquette;

import com.uasz.demo.Modele.Maquette.Enseignement;
import com.uasz.demo.Repository.Maquette.EnseignementRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class EnseignementService {
    @Autowired
    private EnseignementRepository enseignementRepository;

    public Enseignement ajouterEnseignement(Enseignement enseignement){
        enseignement.setDatecreation(new Date());
        enseignementRepository.save(enseignement);
        return enseignement;
    }

    public List<Enseignement> listerEnseignement(){ return enseignementRepository.findAll(); }

    public Enseignement rechercherEnseignement(Long id){
        return  enseignementRepository.findById(id).get();
    }

    public Enseignement modifierEnseignement(Enseignement enseignement){
        Enseignement enseignement1=rechercherEnseignement(enseignement.getId());
        enseignement1.setLibelle(enseignement.getLibelle());
        enseignement1.setObjectifs(enseignement.getObjectifs());
        enseignement1.setDescription(enseignement.getDescription());
        enseignement1.setDatecreation(enseignement.getDatecreation());
        enseignement1.setDatecreation(new Date());
        return enseignementRepository.save(enseignement1);
    }

    public Boolean supprimerEnseignement(Enseignement enseignement){
        Enseignement enseignementSupp=rechercherEnseignement(enseignement.getId());
        if(enseignementSupp!=null){
            enseignementRepository.delete(enseignement);
            return  true;
        }
        else {
            return false;
        }
    }

    public Enseignement modifier_enseignement(Enseignement enseignement, Long id){
        enseignement.setId(id);
        return enseignementRepository.save(enseignement);
    }
    public void supprimer_enseignement(Long id){
        enseignementRepository.deleteById(id);
    }
}
