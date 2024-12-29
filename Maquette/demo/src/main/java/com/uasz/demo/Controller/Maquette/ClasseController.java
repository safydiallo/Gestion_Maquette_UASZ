package com.uasz.demo.Controller.Maquette;


import com.uasz.demo.Modele.Maquette.Classe;
import com.uasz.demo.Modele.Maquette.Formation;
import com.uasz.demo.Modele.Maquette.Groupe;
import com.uasz.demo.Modele.Maquette.Semestre;
import com.uasz.demo.Service.Maquette.ClasseService;
import com.uasz.demo.Service.Maquette.SemestreService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class ClasseController {
    @Autowired
    private ClasseService classeService;
    @Autowired
    private SemestreService semestreService;

    @RequestMapping(value="/maquette/classe",method = RequestMethod.GET)

    public String listerClasse(Model model){
        List<Classe> listeClasse=classeService.listerClasse();
        model.addAttribute("ListeDesClasses",listeClasse);
        List<Semestre> listeSemestre=semestreService.listerSemestre();
        model.addAttribute("ListeDeFormation",listeSemestre);
        return "classe";
    }
    @RequestMapping(value = "/maquette/ajouterClasse", method = RequestMethod.POST)
    public String ajouterClasse(Model model, Classe classe){
        classeService.ajouterClasse(classe);
        return "redirect:/maquette/classe";
    }

    @RequestMapping(value = "/maquette/modifierClasse",method = RequestMethod.POST)
    public String modifierClasse(Model model,Classe classe){
        classeService.modifierClasse(classe);
        return "redirect:/maquette/classe";
    }

    @RequestMapping(value = "/maquette/supprimerClasse",method = RequestMethod.GET)
    public String supprimerClasse(Model model,Classe classe){
        classeService.supprimerClasse(classe);
        return "redirect:/maquette/classe";
    }

    @RequestMapping(value = "/maquette/detailsClasse", method = RequestMethod.GET)
    public String detailsClasse(Model model, @RequestParam("id") Long id){
        Classe classe=classeService.afficherClasse(id);
        List<Groupe> listeGroupe=classeService.afficherLesGroupe(classe);
        model.addAttribute("classe",classe);
        model.addAttribute("ListeDesGroupes",listeGroupe);
        return "detailsClasse";
    }



}
