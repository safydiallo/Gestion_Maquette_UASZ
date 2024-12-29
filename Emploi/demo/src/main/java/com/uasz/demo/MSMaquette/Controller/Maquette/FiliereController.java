package com.uasz.demo.MSMaquette.Controller.Maquette;

import com.uasz.demo.MSMaquette.Interface.FiliereProxy;
import com.uasz.demo.MSMaquette.Modele.Maquette.Filiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

@Controller
public class FiliereController {
    @Autowired
    private FiliereProxy filiereProxy;

    @RequestMapping(value = "/maquette/filiere", method = RequestMethod.GET)
    public String listeFiliere(Model model){
        List<Filiere> listeFiliere=filiereProxy.listeFiliere();
        model.addAttribute("ListeFiliere",listeFiliere);
        return "filiere";
    }

    @RequestMapping(value = "/maquette/ajouterFiliere",method = RequestMethod.POST)
    public String ajouterFiliere(Model model,Filiere filiere){
        filiereProxy.ajouterFiliere(filiere);
        return  "redirect:/maquette/filiere";
    }
    @RequestMapping(value = "/maquette/supprimerFiliere",method = RequestMethod.GET)
    public String supprimeFiliere(Model model, Long id){
        filiereProxy.supprimer_filiere(id);
        return "redirect:/maquette/filiere";
    }

    @RequestMapping(value = "/maquette/modifierFiliere",method = RequestMethod.POST)
    public String modifierfiliere(Model model,Filiere filiere,Long id){
        filiereProxy.modifierFiliere(filiere, id);
        return "redirect:/maquette/filiere";
    }

}
