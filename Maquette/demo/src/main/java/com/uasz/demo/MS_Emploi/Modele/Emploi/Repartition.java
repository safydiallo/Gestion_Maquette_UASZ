package com.uasz.demo.MS_Emploi.Modele.Emploi;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repartition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Date dateCreation;
}
