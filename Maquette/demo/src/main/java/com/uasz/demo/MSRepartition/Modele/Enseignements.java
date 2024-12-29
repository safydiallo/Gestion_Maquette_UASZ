package com.uasz.demo.MSRepartition.Modele;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import com.uasz.demo.Modele.Maquette.Enseignement;
import com.uasz.demo.Modele.Maquette.Semestre;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enseignements {

    private Long id;
    private String libelle;
    private String objectifs;
    private String description;
    private Date dateCreation;
    private String cours;
    private int coefficient;
    private int duree;
    private String classe;
    private int effectif;
    private String libelleGroupe;
    private String semestre;
    private int nbreGroupe;
    private int credit;
    
    public Enseignements(Enseignement e){
        this.libelle=e.getLibelle();
        this.dateCreation=e.getDatecreation();
        this.id=e.getId();
        this.description=e.getDescription();
        this.dateCreation=e.getDatecreation();
        this.objectifs=e.getObjectifs();
        this.cours=e.getModule().getCours();
        this.classe=e.getClasse().getLibelle();
        this.effectif=e.getClasse().getEffectif();
        this.coefficient=e.getModule().getCoefficient();
        this.duree=e.getModule().getDuree();
        this.nbreGroupe=e.getClasse().getNbreGroupe();
        this.credit=e.getModule().getUe().getCredit();
        this.libelleGroupe=e.getGroupe().getLibelle();
        
        Semestre semestre = e.getClasse().getSemestre();
            if (semestre != null) {
                this.semestre = semestre.getLibelle();
            } else {
                // Gérez le cas où le semestre est null
                this.semestre = "Semestre non défini";
            }
    }
}
