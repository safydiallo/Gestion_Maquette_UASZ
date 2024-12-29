package com.uasz.demo.MSRepartition.Modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",length=10)
public class Enseignant {

    private Long id;
    private String nom;
    private String prenom;
    private String grade;
    private Date datecreation;
}
