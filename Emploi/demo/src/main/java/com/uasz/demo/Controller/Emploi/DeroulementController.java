package com.uasz.demo.Controller.Emploi;


import com.uasz.demo.Modele.Emploi.Deroulement;
import com.uasz.demo.Service.Emploi.DeroulementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@AllArgsConstructor
public class DeroulementController {
    @Autowired
    private DeroulementService deroulementService;

    @RequestMapping(value="/emploiDuTemps/deroulement", method= RequestMethod.GET)
    public String Lister_deroulement(Model model){
        List<Deroulement> deroulementList=deroulementService.listerDeroulement();
        model.addAttribute("ListeDesDeroulements",deroulementList);
        return  "deroulement";
    }

    @RequestMapping(value="/emploiDuTemps/ajouterDeroulement",method=RequestMethod.POST)
    public String ajouterDeroulement(Model model,Deroulement deroulement){
        deroulementService.ajouterDeroulement(deroulement);
        return "redirect:/emploiDuTemps/detailsSeance?id="+deroulement.getSeance().getId();
    }

    @RequestMapping(value = "/emploiDuTemps/supprimerDeroulement",method = RequestMethod.GET)
    public String supprimerDeroulement(Model model, Deroulement deroulement){
        deroulementService.supprimerDeroulement(deroulement);
        return "redirect:/emploiDuTemps/detailsSeance?id="+deroulement.getSeance().getId();
    }

    @RequestMapping(value = "/emploiDuTemps/modifierDeroulement",method = RequestMethod.POST)
    public String modifierDeroulement(Model model,Deroulement deroulement){
        Long id=deroulement.getSeance().getId();
        deroulementService.modifierDeroulement(deroulement);
        return "redirect:/emploiDuTemps/detailsSeance?id="+id;
    }

}
