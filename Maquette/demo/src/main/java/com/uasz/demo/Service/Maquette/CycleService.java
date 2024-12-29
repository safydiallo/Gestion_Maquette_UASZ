package com.uasz.demo.Service.Maquette;


import com.uasz.demo.Modele.Maquette.Cycle;
import com.uasz.demo.Modele.Maquette.Niveau;
import com.uasz.demo.Repository.Maquette.CycleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class CycleService {
    @Autowired
    private CycleRepository cycleRepository;

    public Cycle ajouterCycle(Cycle cycle){
        cycleRepository.save(cycle);
        return cycle;
    }

    public  List<Niveau> afficherLesNiveaux(Cycle cycle){
        return cycleRepository.findByCycle(cycle);
    }

    public Cycle afficherCycle(Long id){
        return cycleRepository.findById(id).get();
    }
    public List<Cycle> listerCycle(){
        return cycleRepository.findAll();
    }

    public Cycle rechercherCycle(Long id){
        return cycleRepository.findById(id).get();
    }

    public Cycle modifierCycle( Cycle cycle){
        Cycle cyclemodifier=rechercherCycle(cycle.getId());
        cyclemodifier.setLibelle(cycle.getLibelle());
        cyclemodifier.setDescription(cycle.getDescription());
        cyclemodifier.setDateCreation(new Date());
        return cycleRepository.save(cyclemodifier);
    }

    public Boolean supprimerCycle(Cycle cycle){
        Cycle cycleSupp=rechercherCycle(cycle.getId());
        if(cycleSupp!=null){
            cycleRepository.delete(cycle);
            return true;
        }else {
            return false;
        }
    }

    public Cycle modifier_cycle(Cycle cycle, Long id){
        cycle.setId(id);
        return cycleRepository.save(cycle);
    }
    public void supprimer_cycle(Long id){
        cycleRepository.deleteById(id);
    }
}
