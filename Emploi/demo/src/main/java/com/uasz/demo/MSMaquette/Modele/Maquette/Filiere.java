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
public class Filiere {
    
    private Long id;
    private String libelle;
    private String description;
    private Date datecreation;
    @OneToMany(mappedBy = "filiere")
    private List<Formation> formations;
}
