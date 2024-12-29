package com.uasz.demo.MSRepartition.Controller.Repartition;

import com.uasz.demo.MSRepartition.Interface.PERProxy;
import com.uasz.demo.MSRepartition.Modele.PER;
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
public class PerController {
    @Autowired
    private PERProxy perProxy;

    @RequestMapping(value = "/repartition/per", method = RequestMethod.GET)
    public String listerPer(Model model){
        List<PER> listPER= perProxy.listerPer();
        model.addAttribute("ListeDesPers",listPER);
        return "per";
    }
    @RequestMapping(value = "/repartition/ajouterPer", method = RequestMethod.POST)
    public String ajouterPer(Model model, PER per){
        perProxy.ajouterPer(per);
        return "redirect:/repartition/per";
    }

    @RequestMapping(value = "/repartition/supprimerPer",method = RequestMethod.GET)
    public String supprimePer(Model model, Long id){
        perProxy.supprimer_per(id);
        return "redirect:/repartition/per";
    }

    @RequestMapping(value = "/repartition/modifierPer",method = RequestMethod.POST)
    public String modifierPer(Model model,PER per, Long id){
        perProxy.modifierPer(per,id);
        return "redirect:/repartition/per";
    }

}
