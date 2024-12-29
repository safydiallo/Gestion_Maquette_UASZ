package com.uasz.demo.MSMaquette.Controller.Maquette;


import com.uasz.demo.MSMaquette.Interface.CycleProxy;
import com.uasz.demo.MSMaquette.Modele.Maquette.Cycle;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

@Controller
@AllArgsConstructor
public class CycleController {
    @Autowired
    private CycleProxy cycleProxy;

    @RequestMapping(value = "/maquette/cycle", method = RequestMethod.GET)
    public String listeCycle(Model model){
        List<Cycle> cycleList=cycleProxy.listeCycle();
        model.addAttribute("ListeDesCycles",cycleList);
        return "cycle";
    }

    @RequestMapping(value = "/maquette/ajouterCycle", method = RequestMethod.POST)
    public String ajouterCycle(Model model, Cycle cycle){
        cycleProxy.ajouterCycle(cycle);
        return "redirect:/maquette/cycle";
    }

    @RequestMapping(value = "/maquette/modifierCycle",method = RequestMethod.POST)
    public String modifierCycle(Model model, Cycle cycle,Long id){
        cycleProxy.modifiercycle(cycle, id);
        return "redirect:/maquette/cycle";
    }

    @RequestMapping(value = "/maquette/supprimerCycle",method = RequestMethod.GET)
    public String supprimerCycle(Model model,Long id){
        cycleProxy.supprimer_cycle(id);
        return "redirect:/maquette/cycle";
    }

}
