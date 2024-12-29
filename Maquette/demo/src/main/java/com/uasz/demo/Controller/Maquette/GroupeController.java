package com.uasz.demo.Controller.Maquette;


import com.uasz.demo.Modele.Maquette.Enseignement;
import com.uasz.demo.Modele.Maquette.Groupe;
import com.uasz.demo.Service.Maquette.GroupeService;
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
public class GroupeController {
    @Autowired
    private GroupeService groupeService;

    @RequestMapping(value = "/maquette/groupe", method = RequestMethod.GET)
    public String listeGroupe(Model model){
        List<Groupe> listGroupe=groupeService.listerGroupe();
        model.addAttribute("ListeDesGroupes",listGroupe);
        return "groupe";
    }

    @RequestMapping(value = "/maquette/ajouterGroupe",method = RequestMethod.POST)
    public String ajouterGroupe(Model model, Groupe groupe){
        groupeService.ajouterGroupe(groupe);
        return "redirect:/maquette/detailsClasse?id="+groupe.getClasse().getId();
    }

    @RequestMapping(value = "/maquette/supprimerGroupe",method = RequestMethod.GET)
    public String supprimeGroupe(Model model,Groupe groupe){
        Long id=groupe.getClasse().getId();
        groupeService.supprimerGroupe(groupe);
        return "redirect:/maquette/detailsClasse?id="+id;
    }

    @RequestMapping(value = "/maquette/modifierGroupe",method = RequestMethod.POST)
    public String modifierEns(Model model,Groupe groupe){
        groupeService.modifierGroupe(groupe);
        return "redirect:/maquette/detailsClasse?id="+groupe.getClasse().getId();
    }

    @RequestMapping(value = "/maquette/detailsGroupe",method = RequestMethod.GET)
    public String detailsGroupe(Model model, @RequestParam("id") Long id ){
        Groupe groupe=groupeService.rechercherGroupe(id);
        List<Enseignement> enseignementList=groupeService.afficherLesEnseignements(groupe);
        model.addAttribute("groupe",groupe);
        model.addAttribute("ListeDesEnseignements",enseignementList);
        return "detailsGroupe";
    }

}
