package com.uasz.demo.MSMaquette.Modele.Maquette;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;


import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cycle {
    
    private  Long id;
    private String libelle;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dateCreation;
    @OneToMany(mappedBy = "cycle")
    private List<Niveau> niveaux;
}

