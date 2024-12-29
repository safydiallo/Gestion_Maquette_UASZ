package com.uasz.demo.Controller.Maquette;


import com.uasz.demo.Modele.Maquette.Classe;
import com.uasz.demo.Modele.Maquette.Semestre;
import com.uasz.demo.Service.Maquette.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SemestreController{
    @Autowired
    private SemestreService semestreService;

    @RequestMapping(value = "/maquette/semestre", method = RequestMethod.GET)
    public String listerSemestre(Model model){
        List<Semestre> listSemestre=semestreService.listerSemestre();
        model.addAttribute("ListeDesSemestres",listSemestre);
        return "semestre";
    }

    @RequestMapping(value = "/maquette/ajouterSemestre",method = RequestMethod.POST)
    public String ajouterSemestre(Model model,Semestre semestre){
        semestreService.ajouterSemestre(semestre);
        return "redirect:/maquette/semestre";
    }

    @RequestMapping(value = "/maquette/supprimerSemestre",method = RequestMethod.GET)
    public String supprimeEns(Model model, Semestre semestre){
        semestreService.supprimerSemestre(semestre);
        return "redirect:/maquette/semestre";
    }

    @RequestMapping(value = "/maquette/modifierSemestre",method = RequestMethod.POST)
    public String modifierEns(Model model,Semestre semestre){
        semestreService.modifierSemestre(semestre);
        return "redirect:/maquette/semestre";
    }

    @RequestMapping(value = "/maquette/detailsSemestreModule",method = RequestMethod.GET)
    public String detailsSemestreModule(Model model, @RequestParam("id") Long id ){
        Semestre semestre=semestreService.rechercherSemestre(id);
        List<Module> moduleList=semestreService.afficherLesModules(semestre);
        model.addAttribute("semestre",semestre);
        model.addAttribute("ListeDesModules",moduleList);
        return "detailsSemestreModule";
    }

    @RequestMapping(value = "/maquette/detailsSemestreClasse",method = RequestMethod.GET)
    public String detailsSemestreClasse(Model model, @RequestParam("id") Long id ){
        Semestre semestre=semestreService.rechercherSemestre(id);
        List<Classe> classeList=semestreService.afficherLesClasses(semestre);
        model.addAttribute("semestre",semestre);
        model.addAttribute("ListeDesClasses",classeList);
        return "detailsSemestreClasse";
    }

}
