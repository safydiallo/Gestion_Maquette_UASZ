package com.uasz.demo.Repartition_Service.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uasz.demo.Repartition_Service.Modele.Repartition_Repartition;
import com.uasz.demo.Repartition_Service.Service.RepartitionService_Repartition;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("repartition")
public class RepartitionRestController_Repartition {
    @Autowired
    private RepartitionService_Repartition repartitionService_Repartition;

    @GetMapping(path="/repartition_Repartition")
    public List<Repartition_Repartition> lister_Repartition_Repartition(){
        return repartitionService_Repartition.lister_Repartition_Repartition();
    }
}

