package com.uasz.demo.MSMaquette.Controller.Maquette;


import com.uasz.demo.MSMaquette.Interface.EnseignementProxy;
import com.uasz.demo.MSMaquette.Modele.Maquette.Enseignement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EnseignementController {
    @Autowired
    private EnseignementProxy enseignementProxy;

    @RequestMapping(value = "/maquette/enseignement",method = RequestMethod.GET)
    public String listeEnseignement(Model model){
        List<Enseignement> listEnseignement=enseignementProxy.listeEnseignement();
        model.addAttribute("ListDesEnseignement",listEnseignement);
        return "enseignement";
    }

    @RequestMapping(value = "/maquette/ajouterEns", method = RequestMethod.POST)
    public String ajouterEnseignement(Model model,Enseignement enseignement){
        enseignementProxy.ajouterEnseignement(enseignement);
        return "redirect:/maquette/enseignement";
    }

    @RequestMapping(value = "/maquette/supprimerEns",method = RequestMethod.GET)
    public String supprimeEns(Model model,Long id){
        enseignementProxy.supprimer_enseignement(id);
        return "redirect:/maquette/enseignement";
    }

    @RequestMapping(value = "/maquette/modifierEns",method = RequestMethod.POST)
    public String modifierEns(Model model,Enseignement enseignement,Long id){
        enseignementProxy.modifierenseignement(enseignement, id);
        return "redirect:/maquette/enseignement";
    }


}
