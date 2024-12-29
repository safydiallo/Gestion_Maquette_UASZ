package com.uasz.demo.MSMaquette.Controller.Maquette;


import com.uasz.demo.MSMaquette.Interface.ModuleProxy;
import com.uasz.demo.MSMaquette.Modele.Maquette.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ModuleController{
    @Autowired
    private ModuleProxy moduleProxy;

    @RequestMapping(value= "/maquette/module",method = RequestMethod.GET)
    public String listerModule(Model model){
        List<Module> listModule=moduleProxy.listerModule();
        model.addAttribute("ListeDesModules",listModule);
        return "module";
    }

    @RequestMapping(value = "/maquette/ajouterModule", method = RequestMethod.POST)
    public String ajouterModule(Model model,Module module){
        moduleProxy.ajouterModule(module);
        return "redirect:/maquette/module";
    }

    @RequestMapping(value = "/maquette/supprimerModule",method = RequestMethod.GET)
    public String supprimeModule(Model model, Long id){
        moduleProxy.supprimer_module(id);
        return "redirect:/maquette/module";
    }

    @RequestMapping(value = "/maquette/modifierModule",method = RequestMethod.POST)
    public String modifierEns(Model model,Module module,Long id){
        moduleProxy.modifier_module(module, id);
        return "redirect:/maquette/module";
    }

}
