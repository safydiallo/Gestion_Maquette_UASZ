package com.uasz.demo.MSRepartition.Modele;

import jakarta.persistence.DiscriminatorValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("VAC")
public class Vacataire extends Enseignant {
    private String specialite;

    public Vacataire(Long id, String nom, String prenom, String grade, Date datecreation, String specialite){
        super(id,nom,prenom,grade,datecreation);
        this.specialite = specialite;
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
