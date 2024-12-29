package com.uasz.demo.Repartition_Service.Modele;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enseignement_Repartition {

    private Long id;
    private String libelle;
    private String objectifs;
    private String description;
    private Date dateCreation;
    private Long idModule;
    private String cours;
    private int coefficient;
    private int duree;
    private Long idClasse;
    private String classe;
    private int nbreGroupe;
    private int effectif;
    

    private int cm;
    private int td;
    private int tp;
    private String ueLibelle;
    private int credit;

    private Long idGroupe;
    private String libelleGroupe;
    private String semestre;
    
}
