package com.uasz.demo.Modele.Emploi;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jour;
    private int duree;
    private int dateDebut;
    private int dateFin;
    private int numero;
    private Date dateCreation;
    @ManyToOne
    private Emploi emploi;
    @OneToOne(mappedBy = "seance",fetch = FetchType.LAZY)
    private Deroulement deroulement ;
    @ManyToOne
    private Repartition repartition;
    @ManyToOne
    private Salle salle;
   
}
