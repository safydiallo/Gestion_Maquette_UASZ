package com.uasz.demo.Service.Emploi;


import com.uasz.demo.Modele.Emploi.Batiment;
import com.uasz.demo.Modele.Emploi.Salle;
import com.uasz.demo.Repository.Emploi.BatimentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Transactional
@Service
public class BatimentService {
    @Autowired
    private BatimentRepository batimentRepository;
    public Batiment ajouterBatiment(Batiment batiment){
        batimentRepository.save(batiment);
        return batiment;
    }
    public List<Batiment> listerBatiment(){
        return batimentRepository.findAll();
    }
    public Batiment rechercherBatiment(Long id){
        return batimentRepository.findById(id).get();
    }

    public  List<Salle> afficherLesSalles(Batiment batiment){
        return batimentRepository.findByBatiment(batiment);
    }

    public Batiment modifierBatiment(Batiment batiment){
        Batiment batimentmodifier =rechercherBatiment(batiment.getId());
        batimentmodifier.setLibelle(batiment.getLibelle());
        batimentmodifier.setCode(batiment.getCode());
        batimentmodifier.setPosition(batiment.getPosition());
        batimentmodifier.setDescription(batiment.getDescription());
        batimentmodifier.setDateCreation(batiment.getDateCreation());
        batimentmodifier.setSalles(batiment.getSalles());
        return batimentRepository.save(batimentmodifier);

    }

    public Boolean supprimerBatiment(Batiment batiment){
        Batiment batimentmodifier=rechercherBatiment(batiment.getId());
        if(batimentmodifier!=null){
            batimentRepository.delete(batiment);
            return  true;
        }
        else return false;

    }

    public Batiment modifier_batiment(Batiment batiment, Long id){
        batiment.setId(id);
        return batimentRepository.save(batiment);
    }
    public void supprimer_batiment(Long id){
        batimentRepository.deleteById(id);
    }
}
