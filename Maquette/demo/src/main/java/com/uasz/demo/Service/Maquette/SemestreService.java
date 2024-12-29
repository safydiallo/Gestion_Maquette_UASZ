package com.uasz.demo.Service.Maquette;


import com.uasz.demo.Modele.Maquette.Classe;
import com.uasz.demo.Modele.Maquette.Semestre;
import com.uasz.demo.Repository.Maquette.SemestreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class SemestreService {
    @Autowired
    private SemestreRepository semestreRepository;

    public Semestre ajouterSemestre(Semestre semestre){
        semestreRepository.save(semestre);
        return semestre;
    }

    public List<Semestre> listerSemestre(){
        return semestreRepository.findAll();
    }

    public Semestre rechercherSemestre(Long id){
        return semestreRepository.findById(id).get();
    }

    public  List<Module> afficherLesModules(Semestre semestre){
        return semestreRepository.findBySemestreModule(semestre);
    }
    public  List<Classe> afficherLesClasses(Semestre semestre){
        return semestreRepository.findBySemestreClasse(semestre);
    }

    public Semestre modifierSemestre(Semestre semestre){
        Semestre semestre1=rechercherSemestre(semestre.getId());
        semestre1.setId(semestre.getId());
        semestre1.setLibelle(semestre.getLibelle());
        semestre1.setDescription(semestre.getDescription());
        semestre1.setDatecreation(semestre.getDatecreation());
        return semestreRepository.save(semestre1);
    }

    public Boolean supprimerSemestre(Semestre semestre){
        Semestre semestre1=rechercherSemestre(semestre.getId());
        if(semestre != null){
            semestreRepository.delete(semestre);
            return true;
        }else{
            return false;
        }
    }

    public Semestre modifier_semestre(Semestre semestre, Long id){
        semestre.setId(id);
        return semestreRepository.save(semestre);
    }
    public void supprimer_semestre(Long id){
        semestreRepository.deleteById(id);
    }
}
