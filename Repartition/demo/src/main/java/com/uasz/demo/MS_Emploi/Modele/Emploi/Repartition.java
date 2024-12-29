package com.uasz.demo.MS_Emploi.Modele.Emploi;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import com.uasz.demo.Modele.Repartition.Repartitions;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repartition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Date dateCreation;
    private String enseignement;
    private String classe;
    private String moduleLibelle;
    private String cours;
    private int effectif;
    private int cm;
    private int td;
    private int tp;
    private String ueLibelle;
    private int credit;
    private String semestre;
    private int nbreGroupe;
    private int coefficient;
    private int duree;
    private String enseignantNom;
    private String enseignantPrenom;


    public Repartition(Repartitions r){
        this.id=r.getId();
        this.description=r.getDescription();
        this.dateCreation=r.getDatecreation();
        this.enseignement=r.getEnseignements().getLibelle();
        this.classe=r.getEnseignements().getClasse();
        this.moduleLibelle=r.getEnseignements().getLibelle();
        this.cours=r.getEnseignements().getCours();
        this.coefficient=r.getEnseignements().getCoefficient();
        this.duree=r.getEnseignements().getDuree();
        this.enseignantNom=r.getEnseignant().getNom();
        this.enseignantPrenom=r.getEnseignant().getPrenom();
        this.cm=r.getEnseignements().getCm();
        this.td=r.getEnseignements().getTd();
        this.tp=r.getEnseignements().getTp();
        this.ueLibelle=r.getEnseignements().getUeLibelle();
        this.effectif=r.getEnseignements().getEffectif();
        this.credit=r.getEnseignements().getCredit();
        this.nbreGroupe=r.getEnseignements().getNbreGroupe();
        this.semestre=r.getEnseignements().getSemestre();
        
    }
}
