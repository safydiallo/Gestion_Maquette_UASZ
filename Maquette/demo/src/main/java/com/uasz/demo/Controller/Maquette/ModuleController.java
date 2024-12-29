package com.uasz.demo.Controller.Maquette;


import com.uasz.demo.Modele.Maquette.EC;
import com.uasz.demo.Modele.Maquette.Enseignement;
import com.uasz.demo.Modele.Maquette.Maquette;
import com.uasz.demo.Modele.Maquette.Module;
import com.uasz.demo.Modele.Maquette.UE;
import com.uasz.demo.Service.Maquette.EcService;
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
public class ModuleController{
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private EcService ecService;
    @Autowired
    private UeService ueService;
    @Autowired
    private MaquetteService maquetteService;
    

    @RequestMapping(value= "/maquette/module",method = RequestMethod.GET)
    public String listerModule(Model model){
        List<Module> listModule=moduleService.listerModule();
        model.addAttribute("ListeDesModules",listModule);
        List<UE> ueList = ueService.listerUE(); // Récupérer la liste des UE
    
            for (UE ue : ueList) {
                List<EC> ecInUe = ecService.trouverEcParUe(ue); // Méthode à implémenter dans EcService
                ue.setEc(ecInUe); // Associer la liste des EC à l'UE
            }
    
            model.addAttribute("ListeDesUE", ueList); 

            List<EC> allEC = ecService.listerEc(); 
            model.addAttribute("ListeDesEC", allEC);

            List<Maquette> maquetteList = maquetteService.listerMaquette(); 
            model.addAttribute("ListeDesMaquette", maquetteList);

        return "module";
    }

    @RequestMapping(value = "/maquette/ajouterModule", method = RequestMethod.POST)
    public String ajouterModule(Model model,Module module){
        moduleService.ajouterModule(module);
        return "redirect:/maquette/module";
    }

    @RequestMapping(value = "/maquette/ajoutModule", method = RequestMethod.POST)
    public String ajoutModule(Model model,Module module){
        moduleService.ajouterModule(module);
        return "redirect:/maquette/detailsMaquette?id="+module.getMaquette().getId();
    }

    @RequestMapping(value = "/maquette/supprimerModule",method = RequestMethod.GET)
    public String supprimeModule(Model model, Module module){
        moduleService.supprimerModule(module);
        return "redirect:/maquette/module";
    }

    @RequestMapping(value = "/maquette/modifierModule",method = RequestMethod.POST)
    public String modifierEns(Model model,Module module,Long id){
        moduleService.modifier_module(module,id);
        return "redirect:/maquette/module";
    }

    @RequestMapping(value = "/maquette/detailsModule",method = RequestMethod.GET)
    public String detailsModule(Model model, @RequestParam("id") Long id ){
        Module module=moduleService.rechercherModule(id);
        List<Enseignement> enseignementList=moduleService.afficherLesEnseignements(module);
        model.addAttribute("module",module);
        model.addAttribute("ListeDesEnseignements",enseignementList);
        return "detailsModule";
    }

}
