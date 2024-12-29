package com.uasz.demo.Service.Repartition;


import com.uasz.demo.Modele.Repartition.Enseignant;
import com.uasz.demo.Modele.Repartition.PER;
import com.uasz.demo.Repository.Repartition.PerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class PerService {
    @Autowired
    private PerRepository perRepository;

    @Autowired
    private EnseignantService enseignantService;

    public PER ajouterPer(PER per){
         Enseignant enseignant=new Enseignant();
         enseignant.setNom(per.getNom());
         enseignant.setPrenom(per.getPrenom());
         enseignant.setGrade(per.getGrade());
         enseignant.setDatecreation(new Date());
         Enseignant e=enseignantService.ajouterEnseignant(enseignant);
         per.setId(e.getId());
         per.setMatricule(per.getMatricule());
        perRepository.save(per);
        return per;
    }

    public List<PER> listerPer(){
        return perRepository.findAll();
    }

    public PER rechercherPer(Long id){
        return perRepository.findById(id).get();
    }

    public PER modifierPer(PER per){
        PER per1=rechercherPer(per.getId());
        per1.setId(per.getId());
        per1.setMatricule(per.getMatricule());
        per1.setNom(per.getNom());
        per1.setPrenom(per.getPrenom());
        per1.setGrade(per.getGrade());
        per1.setDatecreation(new Date());
        return perRepository.save(per1);
    }

    public Boolean supprimerPer(PER per){
        PER per1=rechercherPer(per.getId());
        if (per1 !=null){
            perRepository.delete(per);
            return true;
        }else {
            return false;
        }
    }
    public PER modifier_per(PER per, Long id){
        per.setId(id);
        return perRepository.save(per);
    }
    public void supprimer_per(Long id){
        perRepository.deleteById(id);
    }
}
