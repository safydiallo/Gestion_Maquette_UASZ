package com.uasz.demo.MSMaquette.Modele.Maquette;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Niveau {
    
    private Long id;
    private String libelle;
    private String description;
    private Date datecreation;
    @ManyToOne
    private Cycle cycle;
}
