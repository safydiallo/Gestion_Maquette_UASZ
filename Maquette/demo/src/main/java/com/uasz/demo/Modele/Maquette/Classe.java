package com.uasz.demo.Modele.Maquette;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String libelle;
    private int effectif;
    private int nbreGroupe;                  
    private String description;
    private Date dateCreation;
    @OneToMany(mappedBy = "classe")
    private  List<Enseignement> enseignement;
    @ManyToOne
    private Semestre semestre;
    @OneToMany (mappedBy = "classe")
    private List<Groupe> groupes;
    @ManyToOne
    private Formation formation;

}
