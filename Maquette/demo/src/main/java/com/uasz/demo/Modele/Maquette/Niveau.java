package com.uasz.demo.Modele.Maquette;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Niveau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String description;
    private Date datecreation;
    @ManyToOne
    private Cycle cycle;
    @OneToMany(mappedBy = "niveau")
    private List<Formation> formations;

    @Override
    public String toString() {
        return "Niveau{" +
            "id=" + id +
            ", libelle='" + libelle + '\'' +
            ", description='" + description + '\'' +
            ", datecreation=" + datecreation +
            '}';
}
}
