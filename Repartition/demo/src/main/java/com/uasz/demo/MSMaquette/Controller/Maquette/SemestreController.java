package com.uasz.demo.MSMaquette.Controller.Maquette;

import com.uasz.demo.MSMaquette.Interface.SemestreProxy;
import com.uasz.demo.MSMaquette.Modele.Maquette.Semestre;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;
@AllArgsConstructor
@Controller
public class SemestreController{
    @Autowired
    private SemestreProxy semestreProxy;

    @RequestMapping(value = "/maquette/semestre", method = RequestMethod.GET)
    public String listerSemestre(Model model){
        List<Semestre> listSemestre= semestreProxy.listerSemestre();
        model.addAttribute("ListeDesSemestres",listSemestre);
        return "semestre";
    }

    @RequestMapping(value = "/maquette/ajouterSemestre",method = RequestMethod.POST)
    public String ajouterSemestre(Model model,Semestre semestre){
        semestreProxy.ajouterSemestre(semestre);
        return "redirect:/maquette/semestre";
    }

    @RequestMapping(value = "/maquette/supprimerSemestre",method = RequestMethod.GET)
    public String supprimeEns(Model model, Long id){
        semestreProxy.supprimer_semestre(id);
        return "redirect:/maquette/semestre";
    }

    @RequestMapping(value = "/maquette/modifierSemestre",method = RequestMethod.POST)
    public String modifierEns(Model model,Semestre semestre,Long id){
        semestreProxy.modifier_semestre(semestre,id);
        return "redirect:/maquette/semestre";
    }


}
