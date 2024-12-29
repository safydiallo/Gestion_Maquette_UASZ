package com.uasz.demo.Modele.Maquette;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
