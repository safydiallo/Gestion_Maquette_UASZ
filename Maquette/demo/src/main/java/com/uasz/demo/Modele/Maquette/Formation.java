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
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String description;
    private Date datecreation;
    @ManyToOne
    private Filiere filiere;
    @ManyToOne
    private Niveau niveau;
    @OneToOne
    private Maquette maquette;
    @OneToMany(mappedBy = "formation")
    private List<Classe> classes;
}
