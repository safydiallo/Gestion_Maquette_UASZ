package com.uasz.demo.Service.Maquette;


import com.uasz.demo.Modele.Maquette.EC;
import com.uasz.demo.Modele.Maquette.UE;
import com.uasz.demo.Repository.Maquette.EcRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@Transactional
public class EcService {
    @Autowired
    private EcRepository ecRepository;

    public EC ajouterEc(EC ec){
        ec.setDatecreation(new Date());
        ecRepository.save(ec);
        return ec;
    }
     public List<EC> trouverEcParUe(UE ue) {
        return ecRepository.findByUe(ue); // Supposons que vous avez une méthode dans votre repository qui retourne les EC associés à une UE
    }
    public List<EC> listerEc(){
        
        return ecRepository.findAll();
    }

    public EC afficherEC(Long id){return ecRepository.findById(id).get();}

    public EC rechercherEc(Long id){
        return ecRepository.findById(id).get();
    }

    public EC modifierEc(EC ec){
        EC ecmodifie =rechercherEc(ec.getId());
        ecmodifie.setCode(ec.getCode());
        ecmodifie.setLibelle(ec.getLibelle());
        ecmodifie.setCode(ec.getCode());
        ecmodifie.setCm(ec.getCm());
        ecmodifie.setTd(ec.getTd());
        ecmodifie.setTp(ec.getTp());
        ecmodifie.setTpe(ec.getTpe());
        ecmodifie.setCoefficient(ec.getCoefficient());
        ecmodifie.setDescription(ec.getDescription());
        ecmodifie.setDatecreation(new Date());
        return ecRepository.save(ecmodifie);
    }

    public Boolean supprimeEC(EC ec ){
        EC ecSupp=rechercherEc(ec.getId());
        if(ecSupp!=null){
            ecRepository.delete(ec);
            return true;
        }else{
            return false;
        }
    }

    public EC modifier_ec(EC ec, Long id){
        ec.setId(id);
        return ecRepository.save(ec);
    }
    public void supprimer_ec(Long id){
        ecRepository.deleteById(id);
    }
}
