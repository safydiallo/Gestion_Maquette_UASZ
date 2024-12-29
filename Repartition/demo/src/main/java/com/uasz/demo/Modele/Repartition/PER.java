package com.uasz.demo.Modele.Repartition;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("PER")
public class PER extends Enseignant {
    private String matricule;

    public PER(Long id, String nom, String prenom, String grade, Date datecreation, String matricule,List<Repartitions> repartitions){
        super(id,nom,prenom,grade,datecreation,repartitions);
        this.matricule = matricule;
        
    }

    public Long getId()
    {
        return super.getId();
    }
    public String getNom()
    {
        return super.getNom();
    }
    public String getPrenom()
    {
        return super.getPrenom();
    }
    public String getGrade()
    {
        return super.getGrade();
    }
    public Date getDatecreation()
    {
        return super.getDatecreation();
    }

    ///////////Setters////////////////
    public void setId(Long id)
    {
        super.setId(id);
    }
    public void setNom(String nom)
    {
        super.setNom(nom);
    }
    public void setPrenom(String prenom)
    {
        super.setPrenom(prenom);
    }
    public void setGrade(String grade)
    {
        super.setGrade(grade);
    }
    public void setDatecreation(Date datecreation)
    {
        super.setDatecreation(datecreation);
    }
}