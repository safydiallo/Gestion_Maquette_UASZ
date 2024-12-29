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
public class Emploi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int duree;
    private int debut;
    private int fin;
    private Date dateCreation;
    @OneToMany(mappedBy = "emploi")
    private List<Seance> seances;
}
