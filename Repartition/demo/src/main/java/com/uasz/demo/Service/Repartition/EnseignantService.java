package com.uasz.demo.Service.Repartition;


import com.uasz.demo.Modele.Repartition.Enseignant;
import com.uasz.demo.Repository.Repartition.EnseignantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class EnseignantService {
    @Autowired
    private EnseignantRepository enseignantRepository;

    public Enseignant ajouterEnseignant(Enseignant enseignant){
        enseignant.setDatecreation(new Date());
        enseignantRepository.save(enseignant);
        return enseignant;
    }

    public List<Enseignant> listerEnseignant(){return enseignantRepository.findAll();}

    public Enseignant rechercherEnseignant(Long id){
        return enseignantRepository.findById(id).get();
    }

    public Enseignant modifierEnseignant(Enseignant enseignant){
        Enseignant enseignant1=rechercherEnseignant(enseignant.getId());
        enseignant1.setId(enseignant.getId());
        enseignant1.setNom(enseignant.getNom());
        enseignant1.setPrenom(enseignant.getPrenom());
        enseignant1.setGrade(enseignant.getGrade());
        enseignant1.setDatecreation(new Date());
        return enseignantRepository.save(enseignant1);
    }

    public Boolean supprimerEnseignant(Enseignant enseignant){
        Enseignant enseignant1=rechercherEnseignant(enseignant.getId());
        if(enseignant1 != null){
            enseignantRepository.delete(enseignant);
            return true;
        }else{
            return false;
        }
    }

    public Enseignant modifier_enseignant(Enseignant enseignant, Long id){
        enseignant.setId(id);
        return enseignantRepository.save(enseignant);
    }
    public void supprimer_enseignant(Long id){
        enseignantRepository.deleteById(id);
    }
}
