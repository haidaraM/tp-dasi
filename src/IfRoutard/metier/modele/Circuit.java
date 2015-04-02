package IfRoutard.metier.modele;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * <b> Circuit est la classe représentant un voyage de type Circuit. </b>
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

    /**
     * Retourne le transport par lequel le circuit va s'effectuer.
     * @return 
     */
    public String getTransport() {
        return transport;
    }

    /**
     * Met à jour le transport par lequel le circuit va s'effectuer.
     * @param transport 
     */
    public void setTransport(String transport) {
        this.transport = transport;
    }

    /**
     * Retourne le kilometrage du circuit.
     * @return 
     */
    public int getKilometrage() {
        return kilometrage;
    }

    /**
     * Met à jour le kilometrage du circuit.
     * @param distance 
     */
    public void setKilometrage(int distance) {
        this.kilometrage = distance;
    }

    /**
     * Description détaillée du circuit.
     * @return 
     */
    @Override
    public String toString() {
        int i = 0;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String toReturn;
        toReturn = super.toString() +
                "Transport : " + this.getTransport() + "\nNombre de Kilomètres parcourus : " + this.getKilometrage() + 
                " kms\n\n*Périodes et tarifs\n";
        for (Options option : options) {
            toReturn += i +" -- Au départ de " + option.getLieuDepart() + " le " + format.format(option.getDateDepart()) + " -Tarif : "
                    +option.getTarif() + " -Transport aérien : " + option.getTypeTransport() + "\n";
            i++;
        }
        return toReturn;
    }
    /**
     * Retourne une description succincte sur circuit.
     * @return 
     */
    @Override
    public String getType(){
        return  "Circuit (" + this.getDuree() + " jours, " + this.getKilometrage() + " km," + this.getTransport() + ")";
    }
    
       
}
