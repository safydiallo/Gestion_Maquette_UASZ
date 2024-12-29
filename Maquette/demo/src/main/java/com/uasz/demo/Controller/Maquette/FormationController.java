package com.uasz.demo.Controller.Maquette;


import com.uasz.demo.Modele.Maquette.Classe;
import com.uasz.demo.Modele.Maquette.Formation;
import com.uasz.demo.Service.Maquette.FormationService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@AllArgsConstructor
@Controller
public class FormationController {
    @Autowired
    private FormationService formationService;

    @RequestMapping(value = "/maquette/formation",method = RequestMethod.GET)
    public String listeFormation(Model model){
        List<Formation> formations=formationService.listerFormation();
        model.addAttribute("ListeDeFormation",formations);
        return "formation";
    }

    @RequestMapping(value = "/maquette/ajouterFormation", method = RequestMethod.POST)
    public String ajouterFormation(Model model, Formation formation ){
        formationService.ajouterFormation(formation);
        return "redirect:/maquette/formation";
    }

    @RequestMapping(value = "/maquette/supprimerFormation",method = RequestMethod.GET)
    public String supprimeFormation(Model model, Formation formation){
        formationService.supprimerFormation(formation);
        return "redirect:/maquette/formation";
    }

    @RequestMapping(value = "/maquette/modifierFormation",method = RequestMethod.POST)
    public String modifierFormation(Model model,Formation formation){
        formationService.modifierFormation(formation);
        return "redirect:/maquette/formation";
    }

    @RequestMapping(value = "/maquette/detailsFormation",method = RequestMethod.GET)
    public String detailsFormation(Model model, @RequestParam("id") Long id ){
        Formation formation=formationService.rechercherFormation(id);
        List<Classe> classeList=formationService.afficherLesClasses(formation);
        model.addAttribute("formation",formation);
        model.addAttribute("ListeDesClasses",classeList);
        return "detailsFormation";
    }
}
