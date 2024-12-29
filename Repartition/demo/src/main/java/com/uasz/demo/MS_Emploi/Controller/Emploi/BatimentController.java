package com.uasz.demo.MS_Emploi.Controller.Emploi;



import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uasz.demo.MS_Emploi.Interface.BatimentProxy;
import com.uasz.demo.MS_Emploi.Modele.Emploi.Batiment;
import com.uasz.demo.MS_Emploi.Modele.Emploi.Salle;

import java.util.List;

@Controller
@AllArgsConstructor
public class BatimentController {
    @Autowired
    private BatimentProxy batimentProxy;

    @RequestMapping(value="/emploiDuTemps/batiment", method= RequestMethod.GET)
    public String Lister_batiment(Model model){
        List<Batiment> batimentList=batimentProxy.listerBatiment();
        model.addAttribute("ListeDesBatiments",batimentList);
        return  "batiment";
    }

    @RequestMapping(value="/emploiDuTemps/ajouterBatiment",method=RequestMethod.POST)
    public String ajouter_batiment(Model model,Batiment batiment){
        batimentProxy.ajouterBatiment(batiment);
        return "redirect:/emploiDuTemps/batiment";
    }

    @RequestMapping(value = "/emploiDuTemps/supprimerBatiment",method = RequestMethod.GET)
    public String supprimerBatiment(Model model, Long id){
        batimentProxy.supprimer_batiment(id);
        return "redirect:/emploiDuTemps/batiment";
    }

    @RequestMapping(value = "/emploiDuTemps/modifierBatiment",method = RequestMethod.POST)
    public String modifierBatiment(Model model,Batiment batiment,Long id){
        batimentProxy.modifierbatiment(batiment,id);
        return "redirect:/emploiDuTemps/batiment";
    }

    @RequestMapping(value = "/emploiDuTemps/detailsBatiment",method = RequestMethod.GET)
    public String detailsBatiment(Model model, @RequestParam("id") Long id ){
        Batiment batiment=batimentProxy.rechercher_batiment(id);
        List<Salle> salleList=batimentProxy.afficherLesSalles(batiment);
        model.addAttribute("batiment",batiment);
        model.addAttribute("ListeDesSalles",salleList);
        return "emploiDuTemps/detailsBatiment";
    }

}
