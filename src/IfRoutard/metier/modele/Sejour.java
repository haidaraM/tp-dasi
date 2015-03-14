/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfRoutard.metier.modele;

import javax.persistence.Entity;

/**
 *
 * @author mhaidara
 */
@Entity
public class Sejour extends Voyage{
    
    private String residence;

    public Sejour(String nom, int duree, String description, String res) {
        super(nom, duree, description);
        this.residence = res;
    }

    public Sejour() {
        super();
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Residence : "+ residence +" -- ";
    }
    
    
    
}
