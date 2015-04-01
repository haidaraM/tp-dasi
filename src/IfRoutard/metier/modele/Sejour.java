/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfRoutard.metier.modele;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Cette classe représente un voyage de type séjour
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
    /**
     * Retourne la résidence dans lequel sur le séjour se déroulera
     * @return 
     */
    public String getResidence() {
        return residence;
    }
    
    /**
     * Met à jour la résidence dans lequel sur le séjour se déroulera.
     * @param residence 
     */
    public void setResidence(String residence) {
        this.residence = residence;
    }

    /**
     * Description détaillée du séjour.
     * @return 
     */
    @Override
    public String toString() {
        int i = 0;
        String toReturn;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        toReturn = super.toString() +
                "Résidence : " + this.getResidence() + 
                "\n\n*Périodes et tarifs\n";
        for (Options option : options) {
            toReturn += i + " -- Au départ de " + option.getLieuDepart() + " le " + format.format(option.getDateDepart()) + " -Tarif : "
                    +option.getTarif() + " -Transport aérien : " + option.getTypeTransport() + "\n";
            i++;
        }
        return toReturn;
    }
    
    /**
     * Retourne une description succincte du séjour.
     * @return 
     */
    @Override
    public String getType(){
        return "Séjour (" + this.getDuree() + " jours, "+ this.getResidence() +")" ;
    }
    
}
