package com.uasz.demo.Controller.Maquette;


import com.uasz.demo.Modele.Maquette.Classe;
import com.uasz.demo.Modele.Maquette.EC;
import com.uasz.demo.Modele.Maquette.Formation;
import com.uasz.demo.Modele.Maquette.Maquette;
import com.uasz.demo.Modele.Maquette.Module;
import com.uasz.demo.Modele.Maquette.UE;
import com.uasz.demo.Service.Maquette.EcService;
import com.uasz.demo.Service.Maquette.FormationService;
import com.uasz.demo.Service.Maquette.MaquetteService;
import com.uasz.demo.Service.Maquette.ModuleService;
import com.uasz.demo.Service.Maquette.UeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MaquetteController {
    @Autowired
    private MaquetteService maquetteService;
    @Autowired
    private FormationService formationService;
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private UeService ueService;
    @Autowired
    private EcService ecService;

    @RequestMapping(value = "/maquette/maquette", method = RequestMethod.GET)
    public String listerMaquette(Model model){
        List<Maquette> listMaquette=maquetteService.listerMaquette();
        model.addAttribute("ListeDesMaquettes",listMaquette);
        List<Formation> listeFormation=formationService.listerFormation();
        model.addAttribute("ListeDeFormation",listeFormation);
        List<Module> listeModule=moduleService.listerModule();
        model.addAttribute("ListeDesModules",listeModule);
        return "maquette";
    }

    @RequestMapping(value = "/maquette/ajouterMaquette", method = RequestMethod.POST)
    public String ajouterMaquette(Model model, Maquette maquette){
        maquetteService.ajouterMaquette(maquette);
        return "redirect:/maquette/maquette";
    }

    @RequestMapping(value = "/maquette/supprimerMaquette",method = RequestMethod.GET)
    public String supprimeMaquette(Model model, Maquette maquette){
        maquetteService.supprimerMaquette(maquette);
        return "redirect:/maquette/maquette";
    }

    @RequestMapping(value = "/maquette/modifierMaquette",method = RequestMethod.POST)
    public String modifierMaquette(Model model,Maquette maquette){
        maquetteService.modifierMaquette(maquette);
        return "redirect:/maquette/maquette";
    }

    @RequestMapping(value = "/maquette/detailsMaquette",method = RequestMethod.GET)
    public String detailsMaquette(Model model, @RequestParam("id") Long id ){
        Maquette maquette=maquetteService.rechercherMaquette(id);
        List<Module> moduleList=moduleService.listerModule();
        List<UE> ueList = ueService.listerUE(); // Récupérer la liste des UE
    
            for (UE ue : ueList) {
                List<EC> ecInUe = ecService.trouverEcParUe(ue); // Méthode à implémenter dans EcService
                ue.setEc(ecInUe); // Associer la liste des EC à l'UE
            }
    
            model.addAttribute("ListeDesUE", ueList); 

            List<EC> allEC = ecService.listerEc(); 
            model.addAttribute("ListeDesEC", allEC);
        model.addAttribute("maquette",maquette);
        model.addAttribute("ListeDesModules",moduleList);
        return "detailsMaquette";
    }
}
