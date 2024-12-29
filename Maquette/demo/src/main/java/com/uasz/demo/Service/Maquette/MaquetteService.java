package com.uasz.demo.Service.Maquette;


import com.uasz.demo.Modele.Maquette.Maquette;
import com.uasz.demo.Modele.Maquette.Module;
import com.uasz.demo.Repository.Maquette.MaquetteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Transactional
@Service
public class MaquetteService {
    @Autowired
    private MaquetteRepository maquetteRepository;

    public Maquette ajouterMaquette(Maquette maquette){
        maquette.setDatecreation(new Date());
        maquetteRepository.save(maquette);
        return maquette;
    }

    public List<Maquette> listerMaquette(){return maquetteRepository.findAll();}

    public Maquette rechercherMaquette(Long id){
        return maquetteRepository.findById(id).get();
    }

    public  List<Module> afficherLesModules(Maquette maquette){
        return maquetteRepository.findByMaquette(maquette);
    }

    public Maquette modifierMaquette(Maquette maquette){
        Maquette maquette1=rechercherMaquette(maquette.getId());
        maquette1.setId(maquette.getId());
        maquette1.setDescription(maquette.getDescription());
        maquette1.setDatecreation(maquette.getDatecreation());
        maquette1.setDatecreation(new Date());
        return maquetteRepository.save(maquette1);
    }

    public Boolean supprimerMaquette(Maquette maquette){
        Maquette maquette1=rechercherMaquette(maquette.getId());
        if(maquette1 != null){
            maquetteRepository.delete(maquette);
            return true;
        }
        else{
            return false;
        }
    }

    public Maquette modifier_maquette(Maquette maquette, Long id){
        maquette.setId(id);
        return maquetteRepository.save(maquette);
    }
    public void supprimer_maquette(Long id){
        maquetteRepository.deleteById(id);
    }
}


