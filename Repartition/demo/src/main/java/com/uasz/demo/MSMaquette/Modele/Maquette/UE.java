package com.uasz.demo.MSMaquette.Modele.Maquette;
import lombok.*;
import java.util.Date;
import java.util.List;


import com.uasz.demo.MSMaquette.Modele.Utilisateur.Utilisateur;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UE {

    private  Long id;
    private String libelle;
    private String code;
    private int credit;
    private int coefficient;
    private String description;
    private Date dateCreation;
    @ManyToOne
    private Utilisateur utilisateur;
    @OneToMany(mappedBy = "ue")
    private List<EC> ec;
    @OneToMany(mappedBy = "ue")
    private List<Module>modules;

}
