package com.uasz.demo.Service.Emploi;


import com.uasz.demo.Modele.Emploi.Deroulement;
import com.uasz.demo.Repository.Emploi.DeroulementRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Transactional
@Service
public class DeroulementService {
    @Autowired
    private DeroulementRepository deroulementRepository;

    public Deroulement ajouterDeroulement(Deroulement deroulement){
        deroulementRepository.save(deroulement);
        return deroulement;
    }
    public List<Deroulement> listerDeroulement(){
        return deroulementRepository.findAll();
    }
    public Deroulement rechercherDeroulement(Long id){
        return deroulementRepository.findById(id).get();

    }

    public Deroulement modifierDeroulement(Deroulement deroulement){
        Deroulement deroulementmodifier =rechercherDeroulement(deroulement.getId());
        
        deroulementmodifier.setDescription(deroulement.getDescription());
        deroulementmodifier.setDateCreation(deroulement.getDateCreation());
        deroulementmodifier.setSeance(deroulement.getSeance());
        return deroulementRepository.save(deroulementmodifier);

    }

    public Boolean supprimerDeroulement(Deroulement deroulement){
        Deroulement deroulementmodifier=rechercherDeroulement(deroulement.getId());
        if(deroulementmodifier!=null){
            deroulementRepository.delete(deroulement);
            return  true;
        }
        else return false;

    }

    public Deroulement modifier_deroulement(Deroulement deroulement, Long id){
        deroulement.setId(id);
        return deroulementRepository.save(deroulement);
    }
    public void supprimer_deroulement(Long id){
        deroulementRepository.deleteById(id);
    }
}
