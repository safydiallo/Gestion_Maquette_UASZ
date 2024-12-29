package com.uasz.demo.MS_Emploi.Modele.Emploi;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deroulement {
    
    private Long id;
    private String objectifs;
    private String description;
    private Date dateCreation;
}
