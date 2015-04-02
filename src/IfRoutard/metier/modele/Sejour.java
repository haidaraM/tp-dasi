package IfRoutard.metier.modele;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * <b> Sejour est la classe représentant un voyage de type Sejour. </b>
 * @author mhaidara
 */
@Entity
@DiscriminatorValue("Sejour")
public class Sejour extends Voyage{
    /**
     * Residence (hotel, palace, cabane, chalet, bungalow) durant le séjour.
     */
    private String residence;

    /**
     * Constructeur paramétrée.
     * @param nom Le nom du voyage
     * @param duree La durée en jour du séjour
     * @param description Description détaillée du séjour
     * @param code  Code unique
     * @param resid Residence du séjour
     */
    public Sejour(String nom, int duree, String description, String code, String resid) {
        super(nom, duree, description, code);
        this.residence = resid;
    }

    /**
     * Constructeur sans paramètre.
     */
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
     * @param residence La nouvelle résidence
     */
    public void setResidence(String residence) {
        this.residence = residence;
    }

    /**
     * Retourne une description détaillée du séjour.
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
