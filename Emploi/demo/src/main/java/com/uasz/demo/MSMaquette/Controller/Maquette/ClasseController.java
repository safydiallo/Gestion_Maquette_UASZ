package com.uasz.demo.MSMaquette.Controller.Maquette;

import com.uasz.demo.MSMaquette.Interface.ClasseProxy;
import com.uasz.demo.MSMaquette.Modele.Maquette.Classe;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class ClasseController {
    @Autowired
    private ClasseProxy classeProxy;

    @RequestMapping(value="/maquette/classe",method = RequestMethod.GET)

    public String listerClasse(Model model){
        List<Classe> listeClasse=classeProxy.listerClasse();
        model.addAttribute("ListeDesClasses",listeClasse);
        return "classe";
    }
    @RequestMapping(value = "/maquette/ajouterClasse", method = RequestMethod.POST)
    public String ajouterClasse(Model model, Classe classe){
        classeProxy.ajouterClasse(classe);
        return "redirect:/maquette/classe";
    }

    @RequestMapping(value = "/maquette/modifierClasse",method = RequestMethod.POST)
    public String modifierClasse(Model model,Classe classe,Long id){
        classeProxy.modifierUe(classe, id);
        return "redirect:/maquette/classe";
    }

    @RequestMapping(value = "/maquette/supprimerClasse",method = RequestMethod.GET)
    public String supprimerClasse(Model model,Long id){
        classeProxy.supprimer_classe(id);
        return "redirect:/maquette/classe";
    }
}
