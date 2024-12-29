package com.uasz.demo.MS_Emploi.Modele.Emploi;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Batiment {
    
    private Long id;
    private String libelle;
    private String code;
    private String position;
    private String description;
    private Date dateCreation;
    

}
