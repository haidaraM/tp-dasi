/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfRoutard.metier.modele;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        String barre_verticale = "-------------------------------------------------------------------------------";
        DateFormat format = new SimpleDateFormat("EEEE dd MMMM yyyy");
        String la_date = "Date : " + format.format(date);
        String le_client = client.toString();
        String le_conseiller = "Votre conseiller pour ce voyage est : " + conseiller.toString();
        String titre_voyage = "Votre voyage : "+voyage.getNom();
        String le_type = voyage.getType();
        String le_depart = "Depart : " +format.format(options.getDateDepart()) +" de " + options.getLieuDepart();
        String le_transport = options.getTypeTransport();
        String desc_voyage = voyage.getDescription();
        String barre_verticale2 = "----------------------";
        String les_personnes = "Nombre de personnes : "+nbPersonnes;
        String le_tarif = "Tarif par personne : "+ options.getTarif() +" €";
        String total = "TOTAL : " + nbPersonnes*options.getTarif() +" €";
        return barre_verticale +"\n"+
                la_date +"\n"+
                le_client + "\n\n"+
                le_conseiller +"\n\n"+
                titre_voyage +"\n"+
                le_type +"\n\n"+
                le_depart +"\n"+
                le_transport +"\n\n"+
                desc_voyage +"\n\n"+
                barre_verticale2 +"\n"+
                les_personnes+"\n"+
                le_tarif +"\n"+
                total +"\n"
                ;
        
    }
}
