package com.uasz.demo.Modele.Maquette;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;


import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String libelle;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dateCreation;
    @OneToMany(mappedBy = "cycle")
    private List<Niveau> niveaux;
    @Override
    public String toString() {
         return "Cycle{" +
            "id=" + id +
            ", libelle='" + libelle + '\'' +
            ", description='" + description + '\'' +
            ", dateCreation=" + dateCreation +
            '}';
}
}

