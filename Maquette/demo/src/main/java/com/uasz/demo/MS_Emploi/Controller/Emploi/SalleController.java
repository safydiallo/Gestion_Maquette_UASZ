package com.uasz.demo.MS_Emploi.Controller.Emploi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.demo.MS_Emploi.Interface.SalleProxy;
import com.uasz.demo.MS_Emploi.Modele.Emploi.Salle;

import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
@Controller
public class SalleController {
    @Autowired
    private SalleProxy salleProxy;

    @RequestMapping(value="/emploiDuTemps/salle", method= RequestMethod.GET)
    public String Lister_salle(Model model){
        List<Salle> salleList= salleProxy.Lister_salle();
        model.addAttribute("ListeDesSalles",salleList);
        return  "salle";
    }

    @RequestMapping(value="/emploiDuTemps/ajouterSalle",method=RequestMethod.POST)
    public String ajouter_salle(Model model,Salle salle){
         salleProxy.ajouter_salle(salle);
        return "redirect:/emploiDuTemps/detailsBatiment?id="+salle;
    }

    @RequestMapping(value = "/emploiDuTemps/supprimerSalle",method = RequestMethod.GET)
    public String supprimeSalle(Model model, Long id){
         salleProxy.supprimer_salle(id);
        return "redirect:/emploiDuTemps/detailsBatiment?id="+id;
    }

    @RequestMapping(value = "/emploiDuTemps/modifierSalle",method = RequestMethod.POST)
    public String modifierSalle(Model model,Salle salle,Long id){
         salleProxy.modifierUe(salle,id);
        return "redirect:/emploiDuTemps/detailsBatiment?id="+id;
    }

}
