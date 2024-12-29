package com.uasz.demo.Service.Emploi;


import com.uasz.demo.Modele.Emploi.Repartition;
import com.uasz.demo.Modele.Emploi.Seance;
import com.uasz.demo.Repository.Emploi.RepartitionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Transactional
@Service
public class RepartitionService {
    @Autowired
    private RepartitionRepository repartitionRepository;
    public Repartition ajouterRepartition(Repartition repartition){
        repartitionRepository.save(repartition);
        return repartition;
    }
    public List<Repartition> listerRepartition(){
        return repartitionRepository.findAll();
    }
    public Repartition rechercherRepartition(Long id){
        return repartitionRepository.findById(id).get();
    }

    public  List<Seance> afficherLesSeances(Repartition repartition){
        return repartitionRepository.findByRepartition(repartition);
    }

    public Repartition modifierRepartition(Repartition repartition){
        Repartition repartitionmodifier =rechercherRepartition(repartition.getId());
        repartitionmodifier.setDescription(repartition.getDescription());
        repartitionmodifier.setDateCreation(repartition.getDateCreation());
        repartitionmodifier.setSeances(repartition.getSeances());

        return repartitionRepository.save(repartitionmodifier);

    }

    public Boolean supprimerRepartition(Repartition repartition){
        Repartition repartitionmodifier=rechercherRepartition(repartition.getId());
        if(repartitionmodifier!=null){
            repartitionRepository.delete(repartition);
            return  true;
        }
        else return false;

    }

    public Repartition modifier_repartition(Repartition repartition, Long id){
        repartition.setId(id);
        return repartitionRepository.save(repartition);
    }
    public void supprimer_repartition(Long id){
        repartitionRepository.deleteById(id);
    }
}
