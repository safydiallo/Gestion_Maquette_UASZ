package com.uasz.demo.Service.Maquette;


import com.uasz.demo.Modele.Maquette.Enseignement;
import com.uasz.demo.Modele.Maquette.Groupe;
import com.uasz.demo.Repository.Maquette.GroupeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class GroupeService {
    @Autowired
    private GroupeRepository groupeRepository;

    public Groupe ajouterGroupe(Groupe groupe){
        groupeRepository.save(groupe);
        return groupe;
    }

    public List<Groupe> listerGroupe(){
        return groupeRepository.findAll();
    }

    public Groupe rechercherGroupe(Long id){
        return groupeRepository.findById(id).get();
    }

    public  List<Enseignement> afficherLesEnseignements(Groupe groupe){
        return groupeRepository.findByGroupe(groupe);
    }
    public Groupe modifierGroupe(Groupe groupe){
        Groupe groupe1=rechercherGroupe(groupe.getId());
        groupe1.setId(groupe.getId());
        groupe1.setLibelle(groupe.getLibelle());
        groupe1.setNumero(groupe.getNumero());
        groupe1.setEffectif(groupe.getEffectif());
        groupe1.setDescription(groupe.getDescription());
        groupe1.setDatecreation(groupe.getDatecreation());
        return groupeRepository.save(groupe1);
    }
    public Boolean supprimerGroupe(Groupe groupe){
        Groupe groupe1=rechercherGroupe(groupe.getId());
        if(groupe1 != null){
            groupeRepository.delete(groupe);
            return true;
        }
        else {
            return false;
        }
    }

    public Groupe modifier_groupe(Groupe groupe, Long id){
        groupe.setId(id);
        return groupeRepository.save(groupe);
    }
    public void supprimer_groupe(Long id){
        groupeRepository.deleteById(id);
    }
}
