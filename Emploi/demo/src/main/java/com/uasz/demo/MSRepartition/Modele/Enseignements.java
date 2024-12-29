package com.uasz.demo.MSRepartition.Modele;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enseignements {

    private Long id;
    private String libelle;
    private String objectifs;
    private String description;
    private Date dateCreation;
    
}
