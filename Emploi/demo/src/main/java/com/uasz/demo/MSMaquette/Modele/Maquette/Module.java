package com.uasz.demo.MSMaquette.Modele.Maquette;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Module {
    
    private  Long id;
    private  String libelle;
    private String cours;
    private int duree;
    private String objectifs;
    private String description;
    private Date datecreation;
    @ManyToOne
    private UE ue;
    @ManyToOne
    private EC ec;
    @ManyToOne
    private Semestre semestre;
    @OneToMany (mappedBy = "module")
    private List<Enseignement>enseignements;
    @ManyToOne
    private Maquette maquette;

}
