package com.uasz.demo.Modele.Emploi;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repartition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Date dateCreation;
    private Long idEnseignement;
    private String enseignement;
    private Long idClasse;
    private String classe;

    private int effectif;
    private int cm;
    private int td;
    private int tp;
    private String ueLibelle;
    private int nbreGroupe;
    private int credit;
    private String semestre;

    private Long idModule;
    private String cours;
    private int coefficient;
    private int duree;
    private Long idEnseignant;
    private String enseignantNom;
    private String enseignantPrenom;
    @OneToMany(mappedBy = "repartition")
    private List<Seance> seances;
    
}
