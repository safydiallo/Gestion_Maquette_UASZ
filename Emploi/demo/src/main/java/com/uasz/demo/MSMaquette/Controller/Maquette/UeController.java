package com.uasz.demo.MSMaquette.Controller.Maquette;


import com.uasz.demo.MSMaquette.Interface.UEProxy;
import com.uasz.demo.MSMaquette.Modele.Maquette.UE;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

@Controller
@AllArgsConstructor
public class UeController {
    @Autowired
    private UEProxy ueProxy;

    @RequestMapping(value="/maquette/ue", method= RequestMethod.GET)
    public String Lister_ue(Model model){
        List<UE> ueList=ueProxy.lister_ue();
        model.addAttribute("ListeDesUE",ueList);
        return  "ue";
    }

    @RequestMapping(value="/maquette/ajouter_ue",method=RequestMethod.POST)
    public String ajouterUe(Model model,UE ue){
        ueProxy.ajouterUe(ue);
        return "redirect:/maquette/ue";
    }

    @RequestMapping(value = "/maquette/modifierUe", method = RequestMethod.POST)
    public String modifierUe(Model model,UE ue,Long id){
        ueProxy.modifierUe(ue, id);
        return "redirect:/maquette/ue";
    }
    @RequestMapping(value = "/maquette/supprimerUe", method = RequestMethod.GET)
    public String supprimerUe(Model model,Long id){
        ueProxy.supprimer_Ue(id);
        return "redirect:/maquette/ue";
    }





}
