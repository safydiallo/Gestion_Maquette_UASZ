package com.uasz.demo.MSMaquette.Modele.Maquette;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Groupe {
    
    private  Long id;
    private  String libelle;
    private int numero;
    private int effectif;
    private String description;
    private Date datecreation;
    @OneToMany(mappedBy = "groupe")
    private List<Enseignement> enseignements;
    @ManyToOne
    private Classe classe;
}
