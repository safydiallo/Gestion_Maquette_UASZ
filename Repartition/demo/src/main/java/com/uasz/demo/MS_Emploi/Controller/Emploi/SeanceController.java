package com.uasz.demo.MS_Emploi.Controller.Emploi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.demo.MS_Emploi.Interface.SeanceProxy;
import com.uasz.demo.MS_Emploi.Modele.Emploi.Seance;

import lombok.AllArgsConstructor;

import java.util.List;
@Controller
@AllArgsConstructor
public class SeanceController {
    @Autowired
    private SeanceProxy seanceProxy;

    @RequestMapping(value="/emploiDuTemps/seance", method= RequestMethod.GET)
    public String Lister_seance(Model model){
        List<Seance> seanceList=seanceProxy.Lister_seance();
        model.addAttribute("ListeDesSeances",seanceList);
        return  "seance";
    }

    @RequestMapping(value="/emploiDuTemps/ajouterSeance",method=RequestMethod.POST)
    public String ajouter_seance(Model model,Seance seance){
        seanceProxy.ajouter_seance(seance);
        return "redirect:/emploiDuTemps/seance";
    }

    @RequestMapping(value = "/emploiDuTemps/supprimerSeance",method = RequestMethod.GET)
    public String supprimeSeance(Model model,Long id){
        seanceProxy.supprimer_seance(id);
        return "redirect:/emploiDuTemps/seance";
    }

    @RequestMapping(value = "/emploiDuTemps/modifierSeance",method = RequestMethod.POST)
    public String modifierSeance(Model model,Seance seance,Long id){
        seanceProxy.modifierseance(seance,id);
        return "redirect:/emploiDuTemps/seance";
    }



}
