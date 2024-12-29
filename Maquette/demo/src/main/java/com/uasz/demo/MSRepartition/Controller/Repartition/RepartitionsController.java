package com.uasz.demo.MSRepartition.Controller.Repartition;

import com.uasz.demo.MSRepartition.Interface.RepartitionsProxy;
import com.uasz.demo.MSRepartition.Modele.Repartitions;
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
public class RepartitionsController {
    @Autowired
    private RepartitionsProxy repartitionsProxy;

    @RequestMapping(value = "/repartition/repartitions", method = RequestMethod.GET)
    public String listerRepartitions(Model model){
        List<Repartitions> listRepartitions=repartitionsProxy.lister();
        model.addAttribute("ListeDesRepartitions",listRepartitions);
        return "repartitions";
    }

    @RequestMapping(value = "/repartition/ajouterRepartitions", method = RequestMethod.POST)
    public String ajouterRepartitions(Model model, Repartitions repartitions){
        repartitionsProxy.ajouterRepartitions(repartitions);
        return "redirect:/repartitions";
    }

    @RequestMapping(value = "/repartition/supprimerRepartitions",method = RequestMethod.GET)
    public String supprimeRepartitions(Model model, Long id){
        repartitionsProxy.supprimer_repartitions(id);
        return "redirect:/repartition/repartitions";
    }

    @RequestMapping(value = "/repartition/modifierRepartitions",method = RequestMethod.POST)
    public String modifierRepartitions(Model model,Repartitions repartitions,Long id){
        repartitionsProxy.modifier_repartitions(repartitions,id);
        return "redirect:/repartition/repartitions";
    }
    /*
    @RequestMapping(value = "/detailsRepartitions",method = RequestMethod.GET)
    public String detailsRepartitions(Model model, @RequestParam("id") Long id ){
        Repartitions repartitions=repartitionsService.rechercherRepartitions(id);
        List<Seance> seanceList=repartitionsService.afficherLesSeances(repartitions);
        model.addAttribute("repartitions",repartitions);
        model.addAttribute("ListeDesSeances",seanceList);
        return "detailsRepartitions";
    }

     */

}
