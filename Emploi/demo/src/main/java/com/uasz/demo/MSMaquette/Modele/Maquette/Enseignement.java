package com.uasz.demo.MSMaquette.Modele.Maquette;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enseignement {
    
    private  Long id;
    private String libelle;
    private String objectifs;
    private String description;
    private Date datecreation;
    private Long idModule;
    private String nomModule;
    private Long idClasse;
    private Long idGroupe;
    private String nomGroupe;
    

}
