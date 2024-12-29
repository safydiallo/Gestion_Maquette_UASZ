package com.uasz.demo.Service.Maquette;

import com.uasz.demo.Modele.Maquette.Enseignement;
import com.uasz.demo.Modele.Maquette.Module;
import com.uasz.demo.Repository.Maquette.ModuleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class ModuleService {
    @Autowired
    private ModuleRepository moduleRepository;

    public Module ajouterModule(Module module){
        moduleRepository.save(module);
        return module;
    }

    public List<Module> listerModule(){return moduleRepository.findAll();}

    public  List<Enseignement> afficherLesEnseignements(Module module){
        return moduleRepository.findByModule(module);
    }

    public Module rechercherModule(Long id){
        return moduleRepository.findById(id).get();
    }

    public Module rechercherModule(Module module){
        Module module1=rechercherModule(module.getId());
        module1.setId(module.getId());
        module1.setLibelle(module.getLibelle());
        module1.setCours(module.getCours());
        module1.setCoefficient(module.getCoefficient());
        module1.setDuree(module.getDuree());
        module1.setObjectifs(module.getObjectifs());
        module1.setDescription(module.getDescription());
        module1.setDatecreation(module.getDatecreation());
        return  moduleRepository.save(module1);
    }

    public Boolean supprimerModule(Module module){
        Module module1=rechercherModule(module.getId());
        if (module1 != null){
            moduleRepository.delete(module);
            return true;
        }
        else {
            return false;
        }
    }

    public Module modifier_module(Module module, Long id){
        module.setId(id);
        return moduleRepository.save(module);
    }
    public void supprimer_module(Long id){
        moduleRepository.deleteById(id);
    }
}
