package com.uasz.demo.Modele.Maquette;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String libelle;
    private String cours;
    private int coefficient;
    private int duree;
    private String objectifs;
    private String description;
    private Date datecreation;
    @ManyToOne
    @JsonIgnoreProperties("modules")
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
