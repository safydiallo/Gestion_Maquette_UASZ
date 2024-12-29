package com.uasz.demo.Controller.Maquette;


import com.uasz.demo.Modele.Maquette.EC;
import com.uasz.demo.Modele.Maquette.Module;
import com.uasz.demo.Modele.Maquette.UE;
import com.uasz.demo.Service.Maquette.EcService;
import com.uasz.demo.Service.Maquette.ModuleService;
import com.uasz.demo.Service.Maquette.UeService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@AllArgsConstructor
public class EcController {
    @Autowired
    private EcService ecService;
    @Autowired
    private UeService ueService;
     @Autowired
    private ModuleService moduleService;

    @RequestMapping(value = "/maquette/ec",method = RequestMethod.GET)
    public String listeEC(Model model){
        
            List<UE> ueList = ueService.listerUE(); // Récupérer la liste des UE
    
            for (UE ue : ueList) {
                List<EC> ecInUe = ecService.trouverEcParUe(ue); // Méthode à implémenter dans EcService
                ue.setEc(ecInUe); // Associer la liste des EC à l'UE
            }
    
            model.addAttribute("ListeDesUE", ueList); // Ajouter la liste des UE au modèle
    
            List<Module> listeModule=moduleService.listerModule();
             model.addAttribute("ListeDesModules",listeModule);
            return "ec"; // Retourner le nom de votre vue ou template
        
    }
    

    @RequestMapping(value = "/maquette/ajouterEc", method = RequestMethod.POST)
    public String ajouterEc(Model model, EC ec){
        ecService.ajouterEc(ec);
        return "redirect:/maquette/detailsUe?id="+ec.getUe().getId();
    }

    @RequestMapping(value = "/maquette/modifierEc", method = RequestMethod.POST)
    public String modifierEc(Model model, EC ec){
        ecService.modifierEc(ec);
        return "redirect:/maquette/detailsUe?id="+ec.getUe().getId();
    }
    @RequestMapping(value = "/maquette/supprimerEc", method = RequestMethod.GET)
    public String supprimerEc(Model model,EC ec){
        Long id=ec.getUe().getId();
        ecService.supprimeEC(ec);
        return "redirect:/maquette/detailsUe?id="+id;
    }
}
