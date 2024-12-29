package com.uasz.demo.MSRepartition.Controller.Repartition;

import com.uasz.demo.MSRepartition.Interface.EnseignantProxy;
import com.uasz.demo.MSRepartition.Modele.Enseignant;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@AllArgsConstructor
@Controller
public class EnseignantController {
    @Autowired
    private EnseignantProxy enseignantProxy;

    @RequestMapping(value="/repartition/enseignant",method = RequestMethod.GET)

    public String listerEnseignant(Model model){
        List<Enseignant> listEnseignant=enseignantProxy.listerEnseignant();
        model.addAttribute("listeDesEnseignants",listEnseignant);
        return "enseignant";
    }

    @RequestMapping(value = "/repartition/ajouterEnseignant",method = RequestMethod.POST)
    public String ajouterEnseignant(Model model, Enseignant enseignant){
        enseignantProxy.ajouterEnseignant(enseignant);
        return "redirect:/repartition/enseignant";
    }

    @RequestMapping(value = "/repartition/supprimerEnseignant",method = RequestMethod.GET)
    public String supprimeEnseignant(Model model, Long id){
        enseignantProxy.supprimer_enseignant(id);
        return "redirect:/repartition/enseignant";
    }

    @RequestMapping(value = "/repartition/modifierEnseignant",method = RequestMethod.POST)
    public String modifierEnseignant(Model model,Enseignant enseignant,Long id){
        enseignantProxy.modifierEnseignant(enseignant,id);
        return "redirect:/repartition/enseignant";
    }


}
