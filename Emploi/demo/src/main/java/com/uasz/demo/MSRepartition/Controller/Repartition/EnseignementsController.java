package com.uasz.demo.MSRepartition.Controller.Repartition;


import com.uasz.demo.MSRepartition.Interface.EnseignementsProxy;
import com.uasz.demo.MSRepartition.Modele.Enseignements;
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
public class EnseignementsController {
    @Autowired
    private EnseignementsProxy enseignementsProxy;

    @RequestMapping(value = "/repartition/enseignements",method = RequestMethod.GET)
    public String listerEnseignements(Model model) {
        List<Enseignements> listEns =enseignementsProxy.listerEnseignements();
        model.addAttribute("ListeDesEnseignements", listEns);
        return "enseignements";
    }

    @RequestMapping(value = "/repartition/ajouterEnseignements",method = RequestMethod.POST)
    public String ajouterEnseignements(Model model, Enseignements enseignements){
        enseignementsProxy.ajouterEnseignements(enseignements);
        return "redirect:/repartition/enseignements";
    }

    @RequestMapping(value = "/repartition/supprimerEnseignements",method = RequestMethod.GET)
    public String supprimerEnseignements(Model model, Long id){
        enseignementsProxy.supprimer_enseignements(id);
        return "redirect:/repartition/enseignements";
    }

    @RequestMapping(value = "/repartition/modifierEnseignements",method = RequestMethod.POST)
    public String modifierEnseignements(Model model,Enseignements enseignements, Long id){
        enseignementsProxy.modifierenseignements(enseignements,id);
        return "redirect:/repartition/enseignements";
    }

}
