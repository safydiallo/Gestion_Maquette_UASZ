package com.uasz.demo.Controller.Repartition;



import com.uasz.demo.MSMaquette.Modele.Maquette.Enseignement;
import com.uasz.demo.MS_Emploi.Interface.RepartitionProxy;
import com.uasz.demo.MS_Emploi.Modele.Emploi.Repartition;
import com.uasz.demo.Modele.Repartition.Enseignant;
import com.uasz.demo.Modele.Repartition.Enseignements;
import com.uasz.demo.Modele.Repartition.Repartitions;
import com.uasz.demo.Service.Repartition.EnseignantService;
import com.uasz.demo.Service.Repartition.EnseignementsService;
import com.uasz.demo.Service.Repartition.RepartitionsService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

@Controller
@AllArgsConstructor
public class RepartitionsController {
    @Autowired
    private RepartitionsService repartitionsService;
    @Autowired
    EnseignantService enseignantService;
    @Autowired
    EnseignementsService enseignementsService;
    @Autowired
    RepartitionProxy repartitionProxy;

    @RequestMapping(value = "/repartition/repartitions", method = RequestMethod.GET)
    public String listerRepartitions(Model model){
        List<Repartitions> listRepartitions=repartitionsService.listerRepartitions();
        model.addAttribute("ListeDesRepartitions",listRepartitions);

        List<Enseignant> listeEnseignants=enseignantService.listerEnseignant();
        model.addAttribute("listeDesEnseignants",listeEnseignants);
        List<Enseignements> listeEnseignements=enseignementsService.listerEnseignement();
        model.addAttribute("ListeDesEnseignements",listeEnseignements);
        return "repartitions";
    }

    @RequestMapping(value = "/repartition/ajouterRepartitions", method = RequestMethod.POST)
    public String ajouterRepartitions(Model model, Repartitions repartitions){
        Repartitions maitre =repartitionsService.ajouterRepartition(repartitions);
        Repartition slave= new Repartition(maitre);
        repartitionProxy.ajouterRepartition(slave);
        return "redirect:/repartition/repartitions";
    }

    @RequestMapping(value = "/repartition/supprimerRepartitions",method = RequestMethod.GET)
    public String supprimeRepartitions(Model model, Repartitions repartitions){
        repartitionsService.supprimerRepartitions(repartitions);
        return "redirect:/repartition/repartitions";
    }

    @RequestMapping(value = "/repartition/modifierRepartitions",method = RequestMethod.POST)
    public String modifierRepartitions(Model model,Repartitions repartitions){
        repartitionsService.modifierRepartitions(repartitions);
        return "redirect:/repartition/repartitions";
    }
    /*
    @RequestMapping(value = "/repartition/detailsRepartitions",method = RequestMethod.GET)
    public String detailsRepartitions(Model model, @RequestParam("id") Long id ){
        Repartitions repartitions=repartitionsService.rechercherRepartitions(id);
        List<Seance> seanceList=repartitionsService.afficherLesSeances(repartitions);
        model.addAttribute("repartitions",repartitions);
        model.addAttribute("ListeDesSeances",seanceList);
        return "detailsRepartitions";
    }
     */

    

}
