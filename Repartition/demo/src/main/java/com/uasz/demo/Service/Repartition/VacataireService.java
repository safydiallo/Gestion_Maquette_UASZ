package com.uasz.demo.Service.Repartition;

import com.uasz.demo.Modele.Repartition.Vacataire;
import com.uasz.demo.Repository.Repartition.VacataireRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class VacataireService {
    @Autowired
    private VacataireRepository vacataireRepository;

    public Vacataire ajouterVac(Vacataire vac){
        vac.setDatecreation(new Date());
        vacataireRepository.save(vac);
        return vac;
    }

    public List<Vacataire> listerVac(){
        return vacataireRepository.findAll();
    }

    public Vacataire rechercherVac(Long id){
        return vacataireRepository.findById(id).get();
    }

    public Vacataire modifierVac(Vacataire vac){
        Vacataire vac1=rechercherVac(vac.getId());
        vac1.setId(vac.getId());
        vac1.setSpecialite(vac.getSpecialite());
        vac1.setNom(vac.getNom());
        vac1.setPrenom(vac.getPrenom());
        vac1.setGrade(vac.getGrade());
        vac1.setDatecreation(new Date());
        return vacataireRepository.save(vac1);
    }

    public Boolean supprimerVac(Vacataire vac){
        Vacataire vac1=rechercherVac(vac.getId());
        if (vac1 !=null){
            vacataireRepository.delete(vac);
            return true;
        }else {
            return false;
        }
    }

    public Vacataire modifier_vacataire(Vacataire vacataire, Long id){
        vacataire.setId(id);
        return vacataireRepository.save(vacataire);
    }
    public void supprimer_vacataire(Long id){
        vacataireRepository.deleteById(id);
    }
}
