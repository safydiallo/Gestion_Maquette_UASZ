package com.uasz.demo.Controller.Maquette;


import com.uasz.demo.Modele.Maquette.Niveau;
import com.uasz.demo.Service.Maquette.NiveauService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@AllArgsConstructor
public class NiveauController {
    @Autowired
    private NiveauService niveauService;

    @RequestMapping(value= "/maquette/niveau",method = RequestMethod.GET)
    public String listerNiveau(Model model){
        List<Niveau> listNiveau=niveauService.listerNiveau();
        model.addAttribute("ListeDesNiveaux",listNiveau);
        return "niveau";
    }

    @RequestMapping(value = "/maquette/ajouterNiveau",method = RequestMethod.POST)
    public String ajouterNiveau(Model model, Niveau niveau){
        niveauService.ajouterNiveau(niveau);
        return "redirect:/maquette/detailsCycle?id="+niveau.getCycle().getId();
    }

    @RequestMapping(value = "/maquette/supprimerNiveau",method = RequestMethod.GET)
    public String supprimeNiveau(Model model, Niveau niveau){
        Long id=niveau.getCycle().getId();
        niveauService.supprimerNiveau(niveau);
        return "redirect:/maquette/detailsCycle?id="+id;
    }

    @RequestMapping(value = "/maquette/modifierNiveau",method = RequestMethod.POST)
    public String modifierNiveau(Model model,Niveau niveau){
        niveauService.modifierNiveau(niveau);
        return "redirect:/maquette/detailsCycle?id="+niveau.getCycle().getId();
    }


}
