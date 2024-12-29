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
public class Semestre {
    
    private  Long id;
    private  String libelle;
    private String description;
    private Date datecreation;
    @OneToMany(mappedBy = "semestre")
    private List<Classe> classes;
    @OneToMany(mappedBy = "semestre")
    private List<Module> modules;
}
