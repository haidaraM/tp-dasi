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

/**
 *
 * @author elmhaidara
 */
@Entity
public class Pays {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String nom;
    
    private double population;
    
    private double superficie;
    
    private String region;
    
    private String capitale;
    
    private String code;
    
    private String langue;

    public Pays(String nom, double population, double superficie, String region, String capitale, String code, String langue) {
        this.nom = nom;
        this.population = population;
        this.superficie = superficie;
        this.region = region;
        this.capitale = capitale;
        this.code = code;
        this.langue = langue;
    }

    public Pays() {
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

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCapitale() {
        return capitale;
    }

    public void setCapitale(String capitale) {
        this.capitale = capitale;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }  

    @Override
    public String toString() {
        return "Pays : " + nom +" -- "+
                "Code : " + code + " -- " +
                "Langue " + langue +" -- "+
                "Superficie " + superficie;
    }
    
    
    
    
}
