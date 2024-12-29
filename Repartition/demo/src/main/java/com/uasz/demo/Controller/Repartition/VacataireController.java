package com.uasz.demo.Controller.Repartition;


import com.uasz.demo.Modele.Repartition.Vacataire;
import com.uasz.demo.Service.Repartition.VacataireService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@AllArgsConstructor
public class VacataireController {
    @Autowired
    private VacataireService vacataireService;

    @RequestMapping(value = "/repartition/vacataire", method = RequestMethod.GET)
    public String listerVac(Model model){
        List<Vacataire> listVac=vacataireService.listerVac();
        model.addAttribute("ListeDesVacs",listVac);
        return "vacataire";
    }
    @RequestMapping(value = "/repartition/ajouterVacataire", method = RequestMethod.POST)
    public String ajouterVac(Model model, Vacataire vacataire){
        vacataireService.ajouterVac(vacataire);
        return "redirect:/repartition/vacataire";
    }
    @RequestMapping(value = "/repartition/supprimerVac", method = RequestMethod.GET)
    public String supprimerVac(Model model, Vacataire vacataire){
        vacataireService.supprimerVac(vacataire);
        return "redirect:/repartition/vacataire";
    }
    @RequestMapping(value = "/repartition/modifierVac", method = RequestMethod.POST)
    public String modifierVac(Model model,Vacataire vacataire){
        vacataireService.modifierVac(vacataire);
        return "redirect:/repartition/vacataire";
    }
}
