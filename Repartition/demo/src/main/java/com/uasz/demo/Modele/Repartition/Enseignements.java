package com.uasz.demo.Modele.Repartition;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enseignements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @OneToMany(mappedBy = "enseignements")
    private List<Repartitions> repartitions;
    
}
