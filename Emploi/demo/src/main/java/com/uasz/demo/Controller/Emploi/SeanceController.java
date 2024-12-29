package com.uasz.demo.Controller.Emploi;


import com.uasz.demo.Modele.Emploi.Deroulement;
import com.uasz.demo.Modele.Emploi.Salle;
import com.uasz.demo.Modele.Emploi.Seance;
import com.uasz.demo.Service.Emploi.SalleService;
import com.uasz.demo.Service.Emploi.SeanceService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
@AllArgsConstructor
public class SeanceController {
    @Autowired
    private SeanceService seanceService;
    @Autowired
    private SalleService salleService;

    @RequestMapping(value="/emploiDuTemps/seance", method= RequestMethod.GET)
    public String Lister_seance(Model model){
        List<Seance> seanceList=seanceService.listerSeance();
        model.addAttribute("ListeDesSeances",seanceList);
        List<Salle> salleList=salleService.listerSalle();
        model.addAttribute("ListeDesSalles",salleList);
        return  "seance";
    }

    @RequestMapping(value="/emploiDuTemps/ajouterSeance",method=RequestMethod.POST)
    public String ajouter_seance(Model model,Seance seance){
        seanceService.ajouterSeance(seance);
        return "redirect:/emploiDuTemps/detailsRepartition?id="+seance.getRepartition().getId();
    }

    @RequestMapping(value = "/emploiDuTemps/supprimerSeance",method = RequestMethod.GET)
    public String supprimeSeance(Model model,Seance seance){
        seanceService.supprimerSeance(seance);
        return "redirect:/emploiDuTemps/seance";
    }

    @RequestMapping(value = "/emploiDuTemps/modifierSeance",method = RequestMethod.POST)
    public String modifierSeance(Model model,Seance seance){
        seanceService.modifierSeance(seance);
        return "redirect:/emploiDuTemps/seance";
    }

    @RequestMapping(value = "/emploiDuTemps/detailsSeance",method = RequestMethod.GET)
    public String detailsSeance(Model model, @RequestParam("id") Long id ){
        Seance seance=seanceService.rechercherSeance(id);
        List<Deroulement> deroulementList=seanceService.afficherLesDeroulements(seance);
        model.addAttribute("seance",seance);
        model.addAttribute("ListeDesDeroulements",deroulementList);
        return "detailsSeance";
    }

}
