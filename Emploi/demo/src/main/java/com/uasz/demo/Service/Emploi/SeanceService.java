package com.uasz.demo.Service.Emploi;


import com.uasz.demo.Modele.Emploi.Deroulement;
import com.uasz.demo.Modele.Emploi.Seance;
import com.uasz.demo.Repository.Emploi.SeanceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Transactional
@Service
public class SeanceService {
    @Autowired
    private SeanceRepository seanceRepository;
    public Seance ajouterSeance(Seance seance){
        seanceRepository.save(seance);
        return seance;
    }
    public List<Seance> listerSeance(){
        return seanceRepository.findAll();
    }
    public Seance rechercherSeance(Long id){
        return seanceRepository.findById(id).get();

    }
     public  List<Deroulement> afficherLesDeroulements(Seance seance){
        return seanceRepository.findBySeance(seance);
    }

    public Seance modifierSeance(Seance seance){
        Seance seancemodifier =rechercherSeance(seance.getId());
        seancemodifier.setJour(seance.getJour());
        seancemodifier.setDuree(seance.getDuree());
        seancemodifier.setDateDebut(seance.getDateDebut());
        seancemodifier.setDateFin(seance.getDateFin());
        seancemodifier.setNumero(seance.getNumero());
        seancemodifier.setDateCreation(seance.getDateCreation());
        seancemodifier.setEmploi(seance.getEmploi());
        seancemodifier.setDeroulement(seance.getDeroulement());
        seancemodifier.setRepartition(seance.getRepartition());
        /*
        seancemodifier.setRepartitions(seance.getRepartitions());

        */

        return seanceRepository.save(seancemodifier);

    }

    public Boolean supprimerSeance(Seance seance){
        Seance seancemodifier=rechercherSeance(seance.getId());
        if(seancemodifier!=null){
            seanceRepository.delete(seance);
            return  true;
        }
        else return false;

    }

    public Seance modifier_seance(Seance seance, Long id){
        seance.setId(id);
        return seanceRepository.save(seance);
    }
    public void supprimer_seance(Long id){
        seanceRepository.deleteById(id);
    }
}
