package com.uasz.demo.Controller.Emploi;


import com.uasz.demo.Modele.Emploi.Repartition;
import com.uasz.demo.Modele.Emploi.Salle;
import com.uasz.demo.Modele.Emploi.Seance;
import com.uasz.demo.Service.Emploi.RepartitionService;
import com.uasz.demo.Service.Emploi.SalleService;

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
public class RepartitionController {
    @Autowired
    private RepartitionService repartitionService;
    @Autowired
    private SalleService salleService;

    @RequestMapping(value="/emploiDuTemps/repartition",method = RequestMethod.GET)
    public String lister(Model model){
        List<Repartition> listRepartition=repartitionService.listerRepartition();
        model.addAttribute("ListeDesRepartition",listRepartition);
        return "repartition";
    }

    @RequestMapping(value = "/emploiDuTemps/ajouterRepartition",method = RequestMethod.POST)
    public String ajouterRepartition(Model model, Repartition repartition){
        repartitionService.ajouterRepartition(repartition);
        return "redirect:/emploiDuTemps/repartition";
    }

    @RequestMapping(value = "/emploiDuTemps/supprimerRepartition",method = RequestMethod.GET)
    public String supprimeRepartition(Model model, Repartition repartition){
        repartitionService.supprimerRepartition(repartition);
        return "redirect:/emploiDuTemps/repartition";
    }

    @RequestMapping(value = "/emploiDuTemps/modifierRepartition",method = RequestMethod.POST)
    public String modifierRepartition(Model model,Repartition repartition){
        repartitionService.modifierRepartition(repartition);
        return "redirect:/emploiDuTemps/repartition";
    }

    @RequestMapping(value = "/emploiDuTemps/detailsRepartition",method = RequestMethod.GET)
    public String detailsRepartition(Model model, @RequestParam("id") Long id ){
        Repartition repartition=repartitionService.rechercherRepartition(id);
        List<Seance> seanceList=repartitionService.afficherLesSeances(repartition);
        model.addAttribute("repartition",repartition);
        model.addAttribute("ListeDesSeances",seanceList);
        List<Salle> salleList=salleService.listerSalle();
        model.addAttribute("ListeDesSalles",salleList);
        return "detailsRepartition";
    }

}
