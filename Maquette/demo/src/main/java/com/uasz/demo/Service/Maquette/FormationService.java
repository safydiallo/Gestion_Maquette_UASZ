package com.uasz.demo.Service.Maquette;


import com.uasz.demo.Modele.Maquette.Classe;
import com.uasz.demo.Modele.Maquette.Formation;
import com.uasz.demo.Repository.Maquette.FormationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class FormationService {
    @Autowired
    private FormationRepository formationRepository;

    public Formation ajouterFormation(Formation formation){
        formationRepository.save(formation);
        return formation;
    }

    public List<Formation> listerFormation(){return formationRepository.findAll();}

    public Formation rechercherFormation(Long id ){
        return formationRepository.findById(id).get();
    }

    public  List<Classe> afficherLesClasses(Formation formation){
        return formationRepository.findByFormation(formation);
    }
    public Formation modifierFormation(Formation formation){
        Formation formation1=rechercherFormation(formation.getId());
        formation1.setId(formation.getId());
        formation1.setLibelle(formation.getLibelle());
        formation1.setDescription(formation.getDescription());
        formation1.setDatecreation(formation.getDatecreation());
        return formationRepository.save(formation1);

    }

    public Boolean supprimerFormation(Formation formation){
        Formation formation1=rechercherFormation(formation.getId());
        if(formation1 != null){
            formationRepository.delete(formation);
            return true;
        }else{
            return false;
        }
    }
    public Formation modifier_formation(Formation formation, Long id){
        formation.setId(id);
        return formationRepository.save(formation);
    }
    public void supprimer_formation(Long id){
        formationRepository.deleteById(id);
    }








}
