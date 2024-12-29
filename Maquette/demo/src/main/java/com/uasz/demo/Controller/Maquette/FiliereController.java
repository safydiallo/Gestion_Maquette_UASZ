package com.uasz.demo.Controller.Maquette;


import com.uasz.demo.Modele.Maquette.Filiere;
import com.uasz.demo.Modele.Maquette.Formation;
import com.uasz.demo.Service.Maquette.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FiliereController {
    @Autowired
    private FiliereService filiereService;

    @RequestMapping(value = "/maquette/filiere", method = RequestMethod.GET)
    public String listeFiliere(Model model){
        List<Filiere> listeFiliere=filiereService.listerFiliere();
        model.addAttribute("ListeFiliere",listeFiliere);
        return "filiere";
    }

    @RequestMapping(value = "/maquette/ajouterFiliere",method = RequestMethod.POST)
    public String ajouterFiliere(Model model,Filiere filiere){
        filiereService.ajouterFiliere(filiere);
        return  "redirect:/maquette/filiere";
    }
    @RequestMapping(value = "/supprimerFiliere",method = RequestMethod.GET)
    public String supprimeFiliere(Model model, Filiere filiere){
        filiereService.supprimerFiliere(filiere);
        return "redirect:/maquette/filiere";
    }

    @RequestMapping(value = "/maquette/modifierFiliere",method = RequestMethod.POST)
    public String modifierfiliere(Model model,Filiere filiere){
        filiereService.modifierFiliere(filiere);
        return "redirect:/maquette/filiere";
    }

    @RequestMapping(value = "/maquette/detailsFiliere",method = RequestMethod.GET)
    public String detailsFiliere(Model model, @RequestParam("id") Long id ){
        Filiere filiere=filiereService.rechercherFiliere(id);
        List<Formation> formationList=filiereService.afficherLesFormations(filiere);
        model.addAttribute("filiere",filiere);
        model.addAttribute("ListeDesFormations",formationList);
        return "detailsFiliere";
    }

}
