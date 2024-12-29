package com.uasz.demo.Modele.Maquette;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uasz.demo.Modele.Utilisateur.Utilisateur;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JsonIgnore
    private List<Module>modules;
}
