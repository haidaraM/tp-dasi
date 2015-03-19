/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfRoutard.metier.modele;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author elmhaidara
 */
@Entity
@DiscriminatorValue("Circuit")
public class Circuit extends Voyage{
    private String transport;
    private int kilometrage;

    public Circuit(String nom, int duree, String description,String code, String transport, int distance) {
        super(nom, duree, description, code);
        this.transport = transport;
        this.kilometrage = distance;
    }

    public Circuit() {
       super();
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int distance) {
        this.kilometrage = distance;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Moyen de transport: "+ transport +" -- "+
                "Distance : " + kilometrage +" -- ";
                
    }
    
       
}
