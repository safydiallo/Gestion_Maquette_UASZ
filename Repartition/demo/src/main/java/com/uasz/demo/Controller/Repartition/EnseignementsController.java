package com.uasz.demo.Controller.Repartition;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.uasz.demo.Modele.Repartition.Enseignements;
import com.uasz.demo.Service.Repartition.EnseignementsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@AllArgsConstructor
@Controller
public class EnseignementsController {
    @Autowired
    private EnseignementsService enseignementsService;

    @RequestMapping(value = "/repartition/enseignements",method = RequestMethod.GET)
    public String listerEnseignements(Model model) {
        List<Enseignements> listEns = enseignementsService.listerEnseignement();
        model.addAttribute("ListeDesEnseignements", listEns);
        return "enseignements";
    }

    

     @RequestMapping(value = "/maquette/enseignement", method = RequestMethod.POST)
    public String ajouterEnseignements(Model model, @RequestParam(value = "slave", required = false) String slaveJson) {
        if (slaveJson != null && !slaveJson.isEmpty()) {
            Enseignements slave = convertJsonToObject(slaveJson, Enseignements.class);
            enseignementsService.ajouterEnseignements(slave);
            model.addAttribute("slave", slave);
        }


            return "redirect:/repartition/enseignements";
    }
    private <T> T convertJsonToObject(String json, Class<T> objectType) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, objectType);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/repartition/supprimerEnseignements",method = RequestMethod.GET)
    public String supprimerEnseignements(Model model, Enseignements enseignements){
        enseignementsService.supprimerEnseignements(enseignements);
        return "redirect:/repartition/enseignements";
    }

    @RequestMapping(value = "/repartition/modifierEnseignements",method = RequestMethod.POST)
    public String modifierEnseignements(Model model,Enseignements enseignements){
        enseignementsService.modifierEnseignements(enseignements);
        return "redirect:/repartition/enseignements";
    }

}
