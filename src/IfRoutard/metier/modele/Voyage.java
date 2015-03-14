/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfRoutard.metier.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author ebai
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nom;
    private int duree;
    private String description;

    public Voyage( String nom, int duree, String description) {
        this.nom = nom;
        this.duree = duree;
        this.description = description;
    }

    public Voyage() {
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Nom " + nom +" -- "+
                "Durée " + duree +" -- "+
                " Description " + description +" -- ";
    }
    
    
       
}
