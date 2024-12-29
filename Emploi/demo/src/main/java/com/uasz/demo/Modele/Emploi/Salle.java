package com.uasz.demo.Modele.Emploi;

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
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String code;
    private int capacity;
    private String description;
    private Date dateCreation;

    @ManyToOne
    private Batiment batiment;
    @OneToMany(mappedBy = "salle")
    private List<Seance> seances;

}
