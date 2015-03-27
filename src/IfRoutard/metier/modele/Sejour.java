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
 * @author mhaidara
 */
@Entity
@DiscriminatorValue("Sejour")
public class Sejour extends Voyage{
    
    private String residence;

    public Sejour(String nom, int duree, String description, String code, String res) {
        super(nom, duree, description, code);
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
        String toReturn;
        toReturn = super.toString() +
                "Résidence : " + this.getResidence() + 
                "\n\n*Périodes et tarifs\n";
        for (Options option : options) {
            toReturn += "Au départ de " + option.getLieuDepart() + " le " + option.getDateDepart() + " -Tarif : "
                    +option.getTarif() + " -Transport aérien : " + option.getTypeTransport() + "\n";
        }
        return toReturn;
    }
    
    @Override
    public String getType(){
        return "Séjour (" + this.getDuree() + " jours, "+ this.getResidence() +")" ;
    }
    

    
}
