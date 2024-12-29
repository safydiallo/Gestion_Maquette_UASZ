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
public class EC {
    
    private  Long id;
    private String libelle;
    private String code;
    private int cm;
    private int td;
    private int tp;
    private int tpe;
    private int volumeht;
    private int coefficient;
    private String description;
    private Date datecreation;
    @ManyToOne
    private UE ue;
    @OneToMany(mappedBy = "ec")
    private List<Module> module;


}
