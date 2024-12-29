package com.uasz.demo.Modele.Repartition;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repartitions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String description;
    private Date datecreation;
    @ManyToOne
    private Enseignant enseignant;
    @ManyToOne
    private Enseignements enseignements;
    
}
