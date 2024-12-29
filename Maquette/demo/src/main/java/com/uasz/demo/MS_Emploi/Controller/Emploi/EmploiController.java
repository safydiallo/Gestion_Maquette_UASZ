package com.uasz.demo.MS_Emploi.Controller.Emploi;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uasz.demo.MS_Emploi.Interface.EmploiProxy;
import com.uasz.demo.MS_Emploi.Modele.Emploi.Emploi;
import com.uasz.demo.MS_Emploi.Modele.Emploi.Seance;

import java.util.List;

@Controller
@AllArgsConstructor
public class EmploiController {
    @Autowired
    private EmploiProxy emploiProxy;

    @RequestMapping(value="/emploiDuTemps/emploi", method= RequestMethod.GET)
    public String Lister_emploi(Model model){
        List<Emploi> emploiList=emploiProxy.Lister_emploi();
        model.addAttribute("ListeDesEmplois",emploiList);
        return  "emploi";
    }

    @RequestMapping(value="/emploiDuTemps/ajouterEmploi",method=RequestMethod.POST)
    public String ajouterEmploi(Model model,Emploi emploi){
        emploiProxy.ajouterEmploi(emploi);
        return "redirect:/emploiDuTemps/emploi";
    }

    @RequestMapping(value = "/supprimerEmploi",method = RequestMethod.GET)
    public String supprimerEmploi(Model model,Long id){
        emploiProxy.supprimer_emploi(id);
        return "redirect:/emploiDuTemps/emploi";
    }

    @RequestMapping(value = "/emploiDuTemps/modifierEmploi",method = RequestMethod.POST)
    public String modifierEmploi(Model model,Emploi emploi,Long id){
        emploiProxy.modifieremploi(emploi,id);
        return "redirect:/emploiDuTemps/emploi";
    }

    @RequestMapping(value = "/emploiDuTemps/detailsEmploi",method = RequestMethod.GET)
    public String detailsEmploi(Model model, @RequestParam("id") Long id ){
        Emploi emploi=emploiProxy.rechercher_emploi(id);
        List<Seance> seanceList=emploiProxy.afficherLesSeances(emploi);
        model.addAttribute("emploi",emploi);
        model.addAttribute("ListeDesSeances",seanceList);
        return "detailsEmploi";
    }

}
