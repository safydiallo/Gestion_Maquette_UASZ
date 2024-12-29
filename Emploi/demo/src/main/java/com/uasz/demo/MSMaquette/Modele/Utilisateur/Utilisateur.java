package com.uasz.demo.MSMaquette.Modele.Utilisateur;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.uasz.demo.MSMaquette.Modele.Maquette.UE;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {
    
    private Long id;
    private String nom;
    private String prenom;
    private String role;
    @OneToMany(mappedBy = "utilisateur")
    private List<UE> ues;
}
