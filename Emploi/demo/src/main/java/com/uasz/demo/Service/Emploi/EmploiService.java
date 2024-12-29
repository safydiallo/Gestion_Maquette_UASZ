package com.uasz.demo.Service.Emploi;

import com.uasz.demo.Modele.Emploi.Emploi;
import com.uasz.demo.Modele.Emploi.Seance;
import com.uasz.demo.Repository.Emploi.EmploiRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Transactional
@Service
public class EmploiService {
    @Autowired
    private EmploiRepository emploiRepository;
    public Emploi ajouterEmploi(Emploi emploi){
        emploiRepository.save(emploi);
        return emploi;
    }
    public List<Emploi> listerEmploi(){
        return emploiRepository.findAll();
    }
    public Emploi rechercherEmploi(Long id){
        return emploiRepository.findById(id).get();
    }

    public  List<Seance> afficherLesSeances(Emploi emploi){
        return emploiRepository.findByEmploi(emploi);
    }

    public Emploi modifierEmploi(Emploi emploi){
        Emploi emploimodifier =rechercherEmploi(emploi.getId());
        emploimodifier.setDuree(emploi.getDuree());
        emploimodifier.setDebut(emploi.getDebut());
        emploimodifier.setFin(emploi.getFin());
        emploimodifier.setDateCreation(emploi.getDateCreation());
        emploimodifier.setSeances(emploi.getSeances());

        return emploiRepository.save(emploimodifier);

    }

    public Boolean supprimerEmploi(Emploi emploi){
        Emploi emploimodifier=rechercherEmploi(emploi.getId());
        if(emploimodifier!=null){
            emploiRepository.delete(emploi);
            return  true;
        }
        else return false;

    }

    public Emploi modifier_emploi(Emploi  emploi, Long id){
        emploi.setId(id);
        return emploiRepository.save(emploi);
    }
    public void supprimer_emploi(Long id){
        emploiRepository.deleteById(id);
    }
}
