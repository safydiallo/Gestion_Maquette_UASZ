package com.uasz.demo.MSMaquette.Controller.Maquette;



import com.uasz.demo.MSMaquette.Interface.GroupeProxy;
import com.uasz.demo.MSMaquette.Modele.Maquette.Groupe;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

@Controller
@AllArgsConstructor
public class GroupeController {
    @Autowired
    private GroupeProxy groupeProxy;

    @RequestMapping(value = "/maquette/groupe", method = RequestMethod.GET)
    public String listeGroupe(Model model){
        List<Groupe> listGroupe=groupeProxy.listeGroupe();
        model.addAttribute("ListeDesGroupes",listGroupe);
        return "groupe";
    }

    @RequestMapping(value = "/maquette/ajouterGroupe",method = RequestMethod.POST)
    public String ajouterGroupe(Model model, Groupe groupe){
        groupeProxy.ajouterGroupe(groupe);
        return "redirect:/maquette/detailsClasse?id="+groupe.getClasse().getId();
    }

    @RequestMapping(value = "/maquette/supprimerGroupe",method = RequestMethod.GET)
    public String supprimeGroupe(Model model,Groupe groupe){
        Long id=groupe.getClasse().getId();
        groupeProxy.supprimer_groupe(id);
        return "redirect:/maquette/detailsClasse?id="+id;
    }

    @RequestMapping(value = "/maquette/modifierGroupe",method = RequestMethod.POST)
    public String modifierEns(Model model,Groupe groupe,Long id){
        groupeProxy.modifiergroupe(groupe,id);
        return "redirect:/maquette/detailsClasse?id="+groupe.getClasse().getId();
    }



}
