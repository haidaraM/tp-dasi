/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfRoutard.metier.modele;

import javax.persistence.Entity;

/**
 *
 * @author elmhaidara
 */
@Entity
public class Circuit extends Voyage{
    private String transport;
    private int distance;

    public Circuit(String nom, int duree, String description, String transport, int distance) {
        super(nom, duree, description);
        this.transport = transport;
        this.distance = distance;
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Moyen de transport: "+ transport +" -- "+
                "Distance : " + distance +" -- ";
                
    }
    
    
    
    
    
}
