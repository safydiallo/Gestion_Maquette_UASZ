package com.uasz.demo.MSMaquette.Controller.Maquette;

import com.uasz.demo.MSMaquette.Interface.FormationProxy;
import com.uasz.demo.MSMaquette.Modele.Maquette.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class FormationController {
    @Autowired
    private FormationProxy formationProxy;

    @RequestMapping(value = "/maquette/formation",method = RequestMethod.GET)
    public String listeFormation(Model model){
        List<Formation> formations=formationProxy.listeFormation();
        model.addAttribute("ListeDeFormation",formations);
        return "formation";
    }

    @RequestMapping(value = "/maquette/ajouterFormation", method = RequestMethod.POST)
    public String ajouterFormation(Model model, Formation formation ){
        formationProxy.ajouterFormation(formation);
        return "redirect:/maquette/formatition";
    }

    @RequestMapping(value = "/maquette/supprimerFormation",method = RequestMethod.GET)
    public String supprimeFormation(Model model, Long id){
        formationProxy.supprimer_formation(id);
        return "redirect:/maquette/formation";
    }

    @RequestMapping(value = "/maquette/modifierFormation",method = RequestMethod.POST)
    public String modifierFormation(Model model,Formation formation,Long id){
        formationProxy.modifierformation(formation,id);
        return "redirect:/maquette/formation";
    }

}
