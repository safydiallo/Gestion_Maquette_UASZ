package com.uasz.demo.MSMaquette.Controller.Maquette;

import com.uasz.demo.MSMaquette.Interface.ECProxy;
import com.uasz.demo.MSMaquette.Modele.Maquette.EC;
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
    private ECProxy ecProxy;

    @RequestMapping(value = "/maquette/ec",method = RequestMethod.GET)
    public String listeEC(Model model){
        List<EC> ecList=ecProxy.listeEC();
        model.addAttribute("ListeDesEc",ecList);
        return "ec";
    }

    @RequestMapping(value = "/maquette/ajouterEc", method = RequestMethod.POST)
    public String ajouterEc(Model model, EC ec){
        ecProxy.ajouterEc(ec);
        return "redirect:/maquette/detailsUe?id="+ec.getUe().getId();
    }

    @RequestMapping(value = "/maquette/modifierEc", method = RequestMethod.POST)
    public String modifierEc(Model model, EC ec,Long id){
        ecProxy.modifierec(ec, id);
        return "redirect:/maquette/detailsUe?id="+ec.getUe().getId();
    }
    @RequestMapping(value = "/maquette/supprimerEc", method = RequestMethod.GET)
    public String supprimerEc(Model model,EC ec){
        Long id=ec.getUe().getId();
        ecProxy.supprimer_ec(id);
        return "redirect:/maquette/detailsUe?id="+id;
    }
}
