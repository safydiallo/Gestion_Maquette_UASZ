package com.uasz.demo.Controller.Emploi;


import com.uasz.demo.Modele.Emploi.Emploi;
import com.uasz.demo.Modele.Emploi.Seance;
import com.uasz.demo.Service.Emploi.EmploiService;
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
public class EmploiController {
    @Autowired
    private EmploiService emploiService;
    @Autowired
    private SeanceService seanceService;

    @RequestMapping(value="/emploiDuTemps/emploi", method= RequestMethod.GET)
    public String Lister_emploi(Model model){
        List<Emploi> emploiList=emploiService.listerEmploi();
        model.addAttribute("ListeDesEmplois",emploiList);
        List<Seance> seanceList=seanceService.listerSeance();
        model.addAttribute("ListeDesSeances",seanceList);
        return  "emploi";
    }

    @RequestMapping(value="/emploiDuTemps/ajouterEmploi",method=RequestMethod.POST)
    public String ajouterEmploi(Model model,Emploi emploi){
        emploiService.ajouterEmploi(emploi);
        return "redirect:/emploiDuTemps/emploi";
    }

    @RequestMapping(value = "/emploiDuTemps/supprimerEmploi",method = RequestMethod.GET)
    public String supprimerEmploi(Model model, Emploi emploi){
        emploiService.supprimerEmploi(emploi);
        return "redirect:/emploiDuTemps/emploi";
    }

    @RequestMapping(value = "/emploiDuTemps/modifierEmploi",method = RequestMethod.POST)
    public String modifierEmploi(Model model,Emploi emploi){
        emploiService.modifierEmploi(emploi);
        return "redirect:/emploiDuTemps/emploi";
    }

    @RequestMapping(value = "/emploiDuTemps/detailsEmploi",method = RequestMethod.GET)
    public String detailsEmploi(Model model, @RequestParam("id") Long id ){
        Emploi emploi=emploiService.rechercherEmploi(id);
        List<Seance> seanceList=emploiService.afficherLesSeances(emploi);
        model.addAttribute("emploi",emploi);
        model.addAttribute("ListeDesSeances",seanceList);
        return "detailsEmploi";
    }

    

}
