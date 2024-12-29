package com.uasz.demo.Service.Maquette;


import com.uasz.demo.Modele.Maquette.EC;
import com.uasz.demo.Modele.Maquette.UE;
import com.uasz.demo.Repository.Maquette.UeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Transactional
@Service
public class UeService {
    @Autowired
    private UeRepository ueRepository;

    public List<UE> listerUE(){
        return ueRepository.findAll();
    }

    public UE afficherUe(Long id){
        return ueRepository.findById(id).get();
    }

    public  List<EC> afficherLesEC(UE ue){
        return ueRepository.findByUE(ue);
    }
    public UE rechercherUE(Long id){
        return ueRepository.findById(id).get();
    }

   public UE modifierUE(UE ue){
        UE uemodifier =rechercherUE(ue.getId());
        uemodifier.setId(ue.getId());
        uemodifier.setLibelle(ue.getLibelle());
        uemodifier.setCode(ue.getCode());
        uemodifier.setCredit(ue.getCredit());
        uemodifier.setCoefficient(ue.getCoefficient());
        uemodifier.setDescription(ue.getDescription());
        return ueRepository.save(uemodifier);
    }
    public Boolean supprimerUe(UE ue){
        UE uemodifier=rechercherUE(ue.getId());
        if(uemodifier!=null){
            ueRepository.delete(ue);
            return  true;
        }
        else return false;
    }


    public UE ajouterUE(UE ue){
        ueRepository.save(ue);
        return ue;
    }

    public UE modifier_UE(UE ue, Long id){
        ue.setId(id);
        return ueRepository.save(ue);
    }
    public void supprimer_Ue(Long id){
        ueRepository.deleteById(id);
    }
}

