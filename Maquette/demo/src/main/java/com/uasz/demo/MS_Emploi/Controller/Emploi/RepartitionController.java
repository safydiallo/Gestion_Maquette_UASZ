package com.uasz.demo.MS_Emploi.Controller.Emploi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uasz.demo.MS_Emploi.Interface.RepartitionProxy;
import com.uasz.demo.MS_Emploi.Modele.Emploi.Repartition;
import com.uasz.demo.MS_Emploi.Modele.Emploi.Seance;

import lombok.AllArgsConstructor;

import java.util.List;
@Controller
@AllArgsConstructor
public class RepartitionController {
    @Autowired
    private RepartitionProxy repartitionProxy;

    @RequestMapping(value="/emploiDuTemps/repartition",method = RequestMethod.GET)
    public String lister(Model model){
        List<Repartition> listRepartition=repartitionProxy.lister();
        model.addAttribute("ListeDesRepartition",listRepartition);
        return "repartition";
    }

    @RequestMapping(value = "/emploiDuTemps/ajouterRepartition",method = RequestMethod.POST)
    public String ajouterRepartition(Model model, Repartition repartition){
        repartitionProxy.ajouterRepartition(repartition);
        return "redirect:/emploiDuTemps/repartition";
    }

    @RequestMapping(value = "/emploiDuTemps/supprimerRepartition",method = RequestMethod.GET)
    public String supprimeRepartition(Model model, Long id){
        repartitionProxy.supprimer_repartition(id);
        return "redirect:/repartition";
    }

    @RequestMapping(value = "/emploiDuTemps/modifierRepartition",method = RequestMethod.POST)
    public String modifierRepartition(Model model,Repartition repartition,Long id){
        repartitionProxy.modifierUe(repartition,id);
        return "redirect:/emploiDuTemps/repartition";
    }

    @RequestMapping(value = "/emploiDuTemps/detailsRepartition",method = RequestMethod.GET)
    public String detailsRepartition(Model model, @RequestParam("id") Long id ){
        Repartition repartition=repartitionProxy.rechercher_repartition(id);
        List<Seance> seanceList=repartitionProxy.afficherLesSeances(repartition);
        model.addAttribute("repartition",repartition);
        model.addAttribute("ListeDesSeances",seanceList);
        return "detailsRepartition";
    }

}
