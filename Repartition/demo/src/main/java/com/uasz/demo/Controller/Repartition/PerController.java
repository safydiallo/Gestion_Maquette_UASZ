package com.uasz.demo.Controller.Repartition;

import com.uasz.demo.Modele.Repartition.PER;
import com.uasz.demo.Service.Repartition.PerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller

public class PerController {
    @Autowired
    private PerService perService;

    @RequestMapping(value = "/repartition/per", method = RequestMethod.GET)
    public String listerPer(Model model){
        List<PER> listPER=perService.listerPer();
        model.addAttribute("ListeDesPers",listPER);
        return "per";
    }
    @RequestMapping(value = "/repartition/ajouterPer", method = RequestMethod.POST)
    public String ajouterPer(Model model, PER per){
        perService.ajouterPer(per);
        return "redirect:/repartition/per";
    }

    @RequestMapping(value = "/repartition/supprimerPer",method = RequestMethod.GET)
    public String supprimePer(Model model, PER per){
        perService.supprimerPer(per);
        return "redirect:/repartition/per";
    }

    @RequestMapping(value = "/repartition/modifierPer",method = RequestMethod.POST)
    public String modifierPer(Model model,PER per){
        perService.modifierPer(per);
        return "redirect:/repartition/per";
    }

}
