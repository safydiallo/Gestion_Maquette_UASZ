package com.uasz.demo.MSMaquette.Controller.Maquette;


import com.uasz.demo.MSMaquette.Interface.MaquetteProxy;
import com.uasz.demo.MSMaquette.Modele.Maquette.Maquette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MaquetteController {
    @Autowired
    private MaquetteProxy maquetteProxy;

    @RequestMapping(value = "/maquette/maquette", method = RequestMethod.GET)
    public String listerMaquette(Model model){
        List<Maquette> listMaquette=maquetteProxy.listerMaquette();
        model.addAttribute("ListeDesMaquettes",listMaquette);
        return "maquette";
    }

    

    @RequestMapping(value = "/maquette/ajouterMaquette", method = RequestMethod.POST)
    public String ajouterMaquette(Model model, Maquette maquette){
        maquetteProxy.ajouterMaquette(maquette);
        return "redirect:/maquette/maquette";
    }

    @RequestMapping(value = "/maquette/supprimerMaquette",method = RequestMethod.GET)
    public String supprimeMaquette(Model model, Long id){
        maquetteProxy.supprimer_Maquette(id);
        return "redirect:/maquette/maquette";
    }

    @RequestMapping(value = "/maquette/modifierMaquette",method = RequestMethod.POST)
    public String modifierMaquette(Model model,Maquette maquette,Long id){
        maquetteProxy.modifiermaquette(maquette, id);
        return "redirect:/maquette/maquette";
    }


}
