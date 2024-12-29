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
public class Batiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String code;
    private String position;
    private String description;
    private Date dateCreation;
    @OneToMany(mappedBy = "batiment")
    private List<Salle> salles;

}
