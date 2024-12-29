package com.uasz.demo.Service.Emploi;


import com.uasz.demo.Modele.Emploi.Salle;
import com.uasz.demo.Repository.Emploi.SalleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Transactional
@Service
public class SalleService {
    @Autowired
    private SalleRepository salleRepository;
    public Salle ajouterSalle(Salle salle){
        salleRepository.save(salle);
        return salle;
    }
    public List<Salle> listerSalle(){
        return salleRepository.findAll();
    }
    public Salle rechercherSalle(Long id){
        return salleRepository.findById(id).get();

    }

    public Salle modifierSalle(Salle salle){
        Salle sallemodifier =rechercherSalle(salle.getId());
        sallemodifier.setLibelle(salle.getLibelle());
        sallemodifier.setCode(salle.getCode());
        sallemodifier.setCapacity(salle.getCapacity());
        sallemodifier.setDescription(salle.getDescription());
        sallemodifier.setDateCreation(salle.getDateCreation());
        sallemodifier.setBatiment(salle.getBatiment());
        return salleRepository.save(sallemodifier);

    }

    public Boolean supprimerSalle(Salle salle){
        Salle sallemodifier=rechercherSalle(salle.getId());
        if(sallemodifier!=null){
            salleRepository.delete(salle);
            return  true;
        }
        else return false;

    }
    public Salle modifier_salle(Salle salle, Long id){
        salle.setId(id);
        return salleRepository.save(salle);
    }
    public void supprimer_salle(Long id){
        salleRepository.deleteById(id);
    }
}
