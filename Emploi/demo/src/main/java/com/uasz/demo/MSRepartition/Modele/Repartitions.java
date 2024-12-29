package com.uasz.demo.MSRepartition.Modele;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data@AllArgsConstructor
@NoArgsConstructor
public class Repartitions {

    private  Long id;
    private String description;
    private Date datecreation;
    @ManyToOne
    private Enseignant enseignant;
    @ManyToOne
    private Enseignements enseignement;
}
