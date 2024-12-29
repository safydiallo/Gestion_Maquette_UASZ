package com.uasz.demo.Service.Maquette;


import com.uasz.demo.Modele.Maquette.Classe;
import com.uasz.demo.Modele.Maquette.Groupe;
import com.uasz.demo.Repository.Maquette.ClasseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class ClasseService {
    @Autowired
    private ClasseRepository classeRepository;
    public Classe ajouterClasse(Classe classe){
        classeRepository.save(classe);
        return classe;
    }

    public List<Classe> listerClasse(){
        return classeRepository.findAll();
    }

    public  List<Groupe> afficherLesGroupe(Classe classe){
        return classeRepository.findByClasse(classe);
    }

    public Classe afficherClasse(Long id){
        return classeRepository.findById(id).get();
    }

    public Classe rechercherClasse(Long id){
        return classeRepository.findById(id).get();
    }

    public Classe modifierClasse(Classe classe){
        Classe classemodifier=rechercherClasse(classe.getId());
        classemodifier.setId(classe.getId());
        classemodifier.setLibelle(classe.getLibelle());
        classemodifier.setEffectif(classe.getEffectif());
        classemodifier.setNbreGroupe(classe.getNbreGroupe());
        classemodifier.setDescription(classe.getDescription());
        classemodifier.setDateCreation(classe.getDateCreation());
        return classeRepository.save(classemodifier);
    }
    public Boolean supprimerClasse(Classe classe){
        Classe classeSupp=rechercherClasse(classe.getId());
        if(classeSupp!=null){
            classeRepository.delete(classe);
            return true;
        }else {
            return false;
        }
    }

    public Classe modifier_classe(Classe classe, Long id){
        classe.setId(id);
        return classeRepository.save(classe);
    }
    public void supprimer_classe(Long id){
        classeRepository.deleteById(id);
    }
}

