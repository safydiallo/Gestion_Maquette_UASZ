package com.uasz.demo.MS_Emploi.Modele.Emploi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seance {

    private Long id;
    private String jour;
    private int duree;
    private int dateDebut;
    private int dateFin;
    private int numero;
    private Date dateCreation;
}
