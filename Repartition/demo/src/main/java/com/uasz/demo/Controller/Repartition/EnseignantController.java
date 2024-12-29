package com.uasz.demo.Controller.Repartition;




import com.uasz.demo.Modele.Repartition.Enseignant;
import com.uasz.demo.Service.Repartition.EnseignantService;

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
    private EnseignantService enseignantService;

    @RequestMapping(value = "/repartition/enseignant",method = RequestMethod.GET)
    public String listerEnseignant(Model model){
        List<Enseignant> listEnseignant=enseignantService.listerEnseignant();
        model.addAttribute("listeDesEnseignants",listEnseignant);
        return "enseignant";
    }

    @RequestMapping(value = "/repartition/ajouterEnseignant",method = RequestMethod.POST)
    public String ajouterEnseignant(Model model, Enseignant enseignant){
        enseignantService.ajouterEnseignant(enseignant);
        return "redirect:/repartition/enseignant";
    }

    @RequestMapping(value = "/repartition/supprimerEnseignant",method = RequestMethod.GET)
    public String supprimeEnseignant(Model model, Enseignant enseignant){
        enseignantService.supprimerEnseignant(enseignant);
        return "redirect:/repartition/enseignant";
    }

    @RequestMapping(value = "/repartition/modifierEnseignant",method = RequestMethod.POST)
    public String modifierEnseignant(Model model,Enseignant enseignant){
        enseignantService.modifierEnseignant(enseignant);
        return "redirect:/repartition/enseignant";
    }


}
