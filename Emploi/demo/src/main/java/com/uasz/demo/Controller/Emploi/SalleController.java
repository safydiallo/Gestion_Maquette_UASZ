package com.uasz.demo.Controller.Emploi;


import com.uasz.demo.Modele.Emploi.Salle;
import com.uasz.demo.Service.Emploi.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Controller
public class SalleController {
    @Autowired
    private SalleService salleService;

    @RequestMapping(value="/emploiDuTemps/salle", method= RequestMethod.GET)
    public String Lister_salle(Model model){
        List<Salle> salleList=salleService.listerSalle();
        model.addAttribute("ListeDesSalles",salleList);
        return  "salle";
    }

    @RequestMapping(value="/emploiDuTemps/ajouterSalle",method=RequestMethod.POST)
    public String ajouter_salle(Model model,Salle salle){
        salleService.ajouterSalle(salle);
        return "redirect:/emploiDuTemps/detailsBatiment?id="+salle.getBatiment().getId();
    }

    @RequestMapping(value = "/emploiDuTemps/supprimerSalle",method = RequestMethod.GET)
    public String supprimeSalle(Model model, Salle salle){
        salleService.supprimerSalle(salle);
        return "redirect:/emploiDuTemps/detailsBatiment?id="+salle.getBatiment().getId();
    }

    @RequestMapping(value = "/emploiDuTemps/modifierSalle",method = RequestMethod.POST)
    public String modifierSalle(Model model,Salle salle){
        Long id=salle.getBatiment().getId();
        salleService.modifierSalle(salle);
        return "redirect:/emploiDuTemps/detailsBatiment?id="+id;
    }

}
