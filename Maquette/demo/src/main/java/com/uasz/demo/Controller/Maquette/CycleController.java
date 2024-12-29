package com.uasz.demo.Controller.Maquette;


import com.uasz.demo.Modele.Maquette.Cycle;
import com.uasz.demo.Modele.Maquette.Niveau;
import com.uasz.demo.Service.Maquette.CycleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class CycleController {
    @Autowired
    private CycleService cycleService;

    @RequestMapping(value = "/maquette/cycle", method = RequestMethod.GET)
    public String listeCycle(Model model){
        List<Cycle> cycleList=cycleService.listerCycle();
        model.addAttribute("ListeDesCycles",cycleList);
        return "cycle";
    }

    @RequestMapping(value = "/maquette/ajouterCycle", method = RequestMethod.POST)
    public String ajouterCycle(Model model, Cycle cycle){
        cycleService.ajouterCycle(cycle);
        return "redirect:/maquette/cycle";
    }

    @RequestMapping(value = "/maquette/modifierCycle",method = RequestMethod.POST)
    public String modifierCycle(Model model, Cycle cycle){
        cycleService.modifierCycle(cycle);
        return "redirect:/maquette/cycle";
    }

    @RequestMapping(value = "/maquette/supprimerCycle",method = RequestMethod.GET)
    public String supprimerCycle(Model model,Cycle cycle){
        cycleService.supprimerCycle(cycle);
        return "redirect:/maquette/cycle";
    }

    @RequestMapping(value = "/maquette/detailsCycle", method = RequestMethod.GET)
    public String detailsCycle(Model model, @RequestParam("id") Long id){
        Cycle cycle=cycleService.afficherCycle(id);
        List<Niveau> listNiveau=cycleService.afficherLesNiveaux(cycle);
        model.addAttribute("cycle",cycle);
        model.addAttribute("ListeDesNiveaux",listNiveau);
        return "detailsCycle";
    }
}
