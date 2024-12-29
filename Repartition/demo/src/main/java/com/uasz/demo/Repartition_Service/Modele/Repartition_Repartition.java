package com.uasz.demo.Repartition_Service.Modele;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repartition_Repartition {
   
    private Long id;
    private String description;
    private Date dateCreation;
    private Long idEnseignement;
    private String enseignement;
    private Long idClasse;
    private String classe;
    private int nbreGroupe;
    private int credit;
    private String semestre;

    private int effectif;
    private int tp;
    private int td;
    private int cm;
    private String ueLibelle;


    private Long idModule;
    private String cours;
    private int coefficient;
    private int duree;
    private Long idEnseignant;
    private String enseignantNom;
    private String enseignantPrenom;
    private Long idSeance;
    private String seance;
    private int dureeSeance;

   
}
