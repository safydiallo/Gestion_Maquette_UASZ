package com.uasz.demo.Service.Maquette;


import com.uasz.demo.Modele.Maquette.Filiere;
import com.uasz.demo.Modele.Maquette.Formation;
import com.uasz.demo.Repository.Maquette.FiliereRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class FiliereService {
    @Autowired
    private FiliereRepository filiereRepository;

    public Filiere ajouterFiliere(Filiere filiere){
        filiereRepository.save(filiere);
        return filiere;
    }

    public List<Filiere> listerFiliere(){ return filiereRepository.findAll();}

    public Filiere rechercherFiliere(Long id){
        return filiereRepository.findById(id).get();
    }

    public  List<Formation> afficherLesFormations(Filiere filiere){
        return filiereRepository.findByFiliere(filiere);
    }

    public Filiere modifierFiliere(Filiere filiere){
        Filiere filiere1=rechercherFiliere(filiere.getId());
        filiere1.setId(filiere.getId());
        filiere1.setLibelle(filiere.getLibelle());
        filiere1.setDescription(filiere.getDescription());
        filiere1.setDatecreation(filiere.getDatecreation());
        return filiereRepository.save(filiere1);
    }

    public Boolean supprimerFiliere(Filiere filiere){
        Filiere filiere1=rechercherFiliere(filiere.getId());
        if(filiere1 != null){
            filiereRepository.delete(filiere);
            return true;
        }
        else {
            return false;
        }
    }

    public Filiere modifier_filiere(Filiere filiere, Long id){
        filiere.setId(id);
        return filiereRepository.save(filiere);
    }
    public void supprimer_filiere(Long id){
        filiereRepository.deleteById(id);
    }
}
