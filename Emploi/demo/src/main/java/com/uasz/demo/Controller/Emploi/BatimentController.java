package com.uasz.demo.Controller.Emploi;


import com.uasz.demo.Modele.Emploi.Batiment;
import com.uasz.demo.Modele.Emploi.Salle;
import com.uasz.demo.Service.Emploi.BatimentService;
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
public class BatimentController {
    @Autowired
    private BatimentService batimentService;

    @RequestMapping(value="/emploiDuTemps/batiment", method= RequestMethod.GET)
    public String Lister_batiment(Model model){
        List<Batiment> batimentList=batimentService.listerBatiment();
        model.addAttribute("ListeDesBatiments",batimentList);
        return  "batiment";
    }

    @RequestMapping(value="/emploiDuTemps/ajouterBatiment",method=RequestMethod.POST)
    public String ajouter_batiment(Model model,Batiment batiment){
        batimentService.ajouterBatiment(batiment);
        return "redirect:/emploiDuTemps/batiment";
    }

    @RequestMapping(value = "/emploiDuTemps/supprimerBatiment",method = RequestMethod.GET)
    public String supprimerBatiment(Model model, Batiment batiment){
        batimentService.supprimerBatiment(batiment);
        return "redirect:/emploiDuTemps/batiment";
    }

    @RequestMapping(value = "/emploiDuTemps/modifierBatiment",method = RequestMethod.POST)
    public String modifierBatiment(Model model,Batiment batiment){
        batimentService.modifierBatiment(batiment);
        return "redirect:/emploiDuTemps/batiment";
    }

    @RequestMapping(value = "/emploiDuTemps/detailsBatiment",method = RequestMethod.GET)
    public String detailsBatiment(Model model, @RequestParam("id") Long id ){
        Batiment batiment=batimentService.rechercherBatiment(id);
        List<Salle> salleList=batimentService.afficherLesSalles(batiment);
        model.addAttribute("batiment",batiment);
        model.addAttribute("ListeDesSalles",salleList);
        return "detailsBatiment";
    }

}
