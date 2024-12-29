package com.uasz.demo.MSRepartition.Controller.Repartition;

import com.uasz.demo.MSRepartition.Interface.VacataireProxy;
import com.uasz.demo.MSRepartition.Modele.Vacataire;
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
public class VacataireController {
    @Autowired
    private VacataireProxy vacataireProxy;

    @RequestMapping(value = "/repartition/vacataire", method = RequestMethod.GET)
    public String listerVac(Model model){
        List<Vacataire> listVac=vacataireProxy.listerVac();
        model.addAttribute("ListeDesVacs",listVac);
        return "vacataire";
    }
    @RequestMapping(value = "/repartition/ajouterVacataire", method = RequestMethod.POST)
    public String ajouterVac(Model model, Vacataire vacataire){
        vacataireProxy.ajouterVac(vacataire);
        return "redirect:/repartition/vacataire";
    }
    @RequestMapping(value = "/repartition/supprimerVac", method = RequestMethod.GET)
    public String supprimerVac(Model model, Long id){
        vacataireProxy.supprimer_vacataire(id);
        return "redirect:/repartition/vacataire";
    }
    @RequestMapping(value = "/repartition/modifierVac", method = RequestMethod.POST)
    public String modifierVac(Model model,Vacataire vacataire, Long id){
        vacataireProxy.modifierVacataire(vacataire,id);
        return "redirect:/repartition/vacataire";
    }
}
