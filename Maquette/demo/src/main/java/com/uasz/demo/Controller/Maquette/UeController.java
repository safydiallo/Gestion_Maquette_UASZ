package com.uasz.demo.Controller.Maquette;


import com.uasz.demo.Modele.Maquette.EC;
import com.uasz.demo.Modele.Maquette.Module;
import com.uasz.demo.Modele.Maquette.UE;
import com.uasz.demo.Service.Maquette.ModuleService;
import com.uasz.demo.Service.Maquette.UeService;
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
public class UeController {
    @Autowired
    private UeService ueService;
    @Autowired
    private ModuleService moduleService;

    @RequestMapping(value="/maquette/ue", method= RequestMethod.GET)
    public String Lister_ue(Model model){
        List<UE> ueList=ueService.listerUE();
        model.addAttribute("ListeDesUE",ueList);
        List<com.uasz.demo.Modele.Maquette.Module> listeModule=moduleService.listerModule();
        model.addAttribute("ListeDesModules",listeModule);
        return  "ue";
    }

    @RequestMapping(value="/maquette/ajouter_ue",method=RequestMethod.POST)
    public String ajouterUe(Model model,UE ue){
        ueService.ajouterUE(ue);
        return "redirect:/maquette/ue";
    }

    @RequestMapping(value = "/maquette/modifierUe", method = RequestMethod.POST)
    public String modifierUe(Model model,UE ue){
        ueService.modifierUE(ue);
        return "redirect:/maquette/ue";
    }
    @RequestMapping(value = "/maquette/supprimerUe", method = RequestMethod.GET)
    public String supprimerUe(Model model,UE ue){
        ueService.supprimerUe(ue);
        return "redirect:/maquette/ue";
    }

    @RequestMapping(value = "/maquette/detailsUe",method = RequestMethod.GET)
    public String detailsUe(Model model, @RequestParam("id") Long id ){
        UE ue=ueService.afficherUe(id);
        List<EC> ecList=ueService.afficherLesEC(ue);
        model.addAttribute("ue",ue);
        model.addAttribute("ListeDesEC",ecList);
        List<Module> listeModule=moduleService.listerModule();
        model.addAttribute("ListeDesModules",listeModule);
        return "detailsUe";
    }




}
