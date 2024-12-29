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
public class Maquette {
    private  Long id;
    private String description;
    private Date datecreation;
    @OneToOne
    private Formation formation;
    @OneToMany(mappedBy = "maquette")
    private List<Module>modules;


}
