package com.uasz.demo.MS_Emploi.Controller.Emploi;



import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uasz.demo.MS_Emploi.Interface.DeroulementProxy;
import com.uasz.demo.MS_Emploi.Modele.Emploi.Deroulement;

import java.util.List;

@Controller
@AllArgsConstructor
public class DeroulementController {
    @Autowired
    private DeroulementProxy deroulementProxy;

    @RequestMapping(value="/emploiDuTemps/deroulement", method= RequestMethod.GET)
    public String Lister_deroulement(Model model){
        List<Deroulement> deroulementList=deroulementProxy.Lister_deroulement();
        model.addAttribute("ListeDesDeroulements",deroulementList);
        return  "deroulement";
    }

    @RequestMapping(value="/emploiDuTemps/ajouterDeroulement",method=RequestMethod.POST)
    public String ajouterDeroulement(Model model,Deroulement deroulement){
        deroulementProxy.ajouterDeroulement(deroulement);
        return "redirect:/emploiDuTemps/deroulement";
    }

    @RequestMapping(value = "/emploiDuTemps/supprimerDeroulemet",method = RequestMethod.GET)
    public String supprimeDeroulement(Model model, Long id){
        deroulementProxy.supprimer_deroulement(id);
        return "redirect:/emploiDuTemps/deroulement";
    }

    @RequestMapping(value = "/emploiDuTemps/modifierDeroulement",method = RequestMethod.POST)
    public String modifierDeroulement(Model model,Deroulement deroulement,Long id){
        deroulementProxy.modifierderoulement(deroulement,id);
        return "redirect:/emploiDuTemps/deroulement";
    }

}
