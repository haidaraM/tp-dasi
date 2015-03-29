/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfRoutard.metier.modele;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author elmhaidara
 */
@Entity
public class Devis implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    
    private int nbPersonnes;
    
    @JoinColumn(nullable = false)
    @ManyToOne
    private Client client;
    
    @JoinColumn(nullable = false)
    @ManyToOne
    private Conseiller conseiller;
    
    @JoinColumn(nullable = false)
    @OneToOne
    private Options options;
    
    @JoinColumn(nullable = false)
    @OneToOne
    private Voyage voyage;
    
    public Devis(Date date, int nbPersonnes) {
        this.date = date;
        this.nbPersonnes = nbPersonnes;
    }

    public Devis() {
    }

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date dateDepart) {
        this.date = dateDepart;
    }

    public int getNbPersonnes() {
        return nbPersonnes;
    }

    public void setNbPersonnes(int nbPersonnes) {
        this.nbPersonnes = nbPersonnes;
    }
    
    public Client getClient() {
        return client;
    }

    public Conseiller getConseiller() {
        return conseiller;
    }

    public Options getOptions() {
        return options;
    }

    public Voyage getVoyage() {
        return voyage;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setConseiller(Conseiller conseiller) {
        this.conseiller = conseiller;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }
    
    @Override
    public String toString(){
        return "-------------------------------------------------------------------------------\nDate : "
                + date + "\n" + client.getPrenom() +" "+ client.getNom() + 
                client.getAdresse() + "\n" + client.getNumeroTelephone() + 
                "\n\nVotre conseiller pour ce voyage : "+conseiller.getPrenom() + 
                " " + conseiller.getNom() +" ("+conseiller.getMail() + ")\n\nVotre voyage : "+
                voyage.getNom() + " ." +this.getVoyage().getPays().get(0) + "\n" + 
                voyage.getType() + "\n\nDépart : le" + options.getDateDepart() +" de " + options.getLieuDepart()+
                "\nTransport aérien (susceptible d'être modifié) : " +options.getLieuDepart()+ 
                "\n\n" + voyage.getDescription() + "\\nn----------------------\nNombre de personnes : " + nbPersonnes + 
                "\nTarif par personne : " + options.getTarif() + " € \nTOTAL : " + options.getTarif()*nbPersonnes + " €"                    
                ;
        
}
}
