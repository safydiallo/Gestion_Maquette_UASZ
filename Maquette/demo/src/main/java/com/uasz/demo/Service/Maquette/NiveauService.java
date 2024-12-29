package com.uasz.demo.Service.Maquette;


import com.uasz.demo.Modele.Maquette.Niveau;
import com.uasz.demo.Repository.Maquette.NiveauRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class NiveauService {
    @Autowired
    private NiveauRepository niveauRepository;

    public Niveau ajouterNiveau(Niveau niveau){
        return niveauRepository.save(niveau);
    }

    public List<Niveau> listerNiveau(){
        return niveauRepository.findAll();
    }

    public Niveau afficherNiveau(Long id){return niveauRepository.getById(id);}

    public Niveau rechercherNiveau(Long id){
        return niveauRepository.findById(id).get();
    }

    public Niveau modifierNiveau(Niveau niveau){
        Niveau niveau1=rechercherNiveau(niveau.getId());
        niveau1.setId(niveau.getId());
        niveau1.setLibelle(niveau.getLibelle());
        niveau1.setDescription(niveau.getDescription());
        niveau1.setDatecreation(niveau.getDatecreation());
        return niveauRepository.save(niveau1);
    }

    public Boolean supprimerNiveau(Niveau niveau){
        Niveau niveau1=rechercherNiveau(niveau.getId());
        if (niveau1 != null){
            niveauRepository.delete(niveau);
            return true;
        }else{
            return false;
        }
    }

    public Niveau modifier_niveau(Niveau niveau, Long id){
        niveau.setId(id);
        return niveauRepository.save(niveau);
    }
    public void supprimer_niveau(Long id){
        niveauRepository.deleteById(id);
    }
}
