package com.uasz.demo.Modele.Maquette;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enseignement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String libelle;
    private String objectifs;
    private String description;
    private Date datecreation;
    @ManyToOne
    private Classe classe;
    @ManyToOne
    private Groupe groupe;
    @ManyToOne
    private Module module;
    
}
