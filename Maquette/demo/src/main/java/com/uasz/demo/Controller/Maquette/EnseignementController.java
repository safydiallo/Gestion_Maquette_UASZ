package com.uasz.demo.Controller.Maquette;


import com.uasz.demo.MSRepartition.Controller.Repartition.EnseignementsController;
import com.uasz.demo.MSRepartition.Interface.EnseignementsProxy;
import com.uasz.demo.MSRepartition.Modele.Enseignements;
import com.uasz.demo.Modele.Maquette.Classe;
import com.uasz.demo.Modele.Maquette.Enseignement;
import com.uasz.demo.Modele.Maquette.Groupe;
import com.uasz.demo.Modele.Maquette.Module;
import com.uasz.demo.Service.Maquette.ClasseService;
import com.uasz.demo.Service.Maquette.EnseignementService;
import com.uasz.demo.Service.Maquette.GroupeService;
import com.uasz.demo.Service.Maquette.ModuleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EnseignementController {
    @Autowired
    private EnseignementService enseignementService;
     @Autowired
    private ClasseService classeService;
    @Autowired
    private GroupeService groupeService;
    @Autowired
    private ModuleService moduleService;
     @Autowired
    private EnseignementsController enseignementsController;
private final EnseignementsProxy enseignementsProxy;

    public EnseignementController(EnseignementsProxy enseignementsProxy) {
    this.enseignementsProxy = enseignementsProxy;
}

    @RequestMapping(value = "/maquette/enseignement",method = RequestMethod.GET)
    public String listeEnseignement(Model model){
        List<Enseignement> listEnseignement=enseignementService.listerEnseignement();
        model.addAttribute("ListDesEnseignement",listEnseignement);
        List<Classe> listeClasse=classeService.listerClasse();
        model.addAttribute("ListeDesClasses",listeClasse);
        List<Groupe> listeGroupe=groupeService.listerGroupe();
        model.addAttribute("ListeDesGroupes",listeGroupe);
        List<Module> listeModule=moduleService.listerModule();
        model.addAttribute("ListeDesModules",listeModule);

        return "enseignement";
    }

    @RequestMapping(value = "/maquette/ajouterEns", method = RequestMethod.POST)
    public String ajouterEnseignement(Model model,Enseignement enseignement){
    Enseignement maitre =enseignementService.ajouterEnseignement(enseignement);
        Enseignements slave= new Enseignements(maitre);
        enseignementsProxy.ajouterEnseignements(slave);
        return "redirect:/maquette/enseignement";
    }

    @RequestMapping(value = "/maquette/supprimerEns",method = RequestMethod.GET)
    public String supprimeEns(Model model,Enseignement enseignement){
        enseignementService.supprimerEnseignement(enseignement);
        return "redirect:/maquette/enseignement";
    }

    @RequestMapping(value = "/maquette/modifierEns",method = RequestMethod.POST)
    public String modifierEns(Model model,Enseignement enseignement){
        enseignementService.modifierEnseignement(enseignement);
        return "redirect:/maquette/enseignement";
    }


}
