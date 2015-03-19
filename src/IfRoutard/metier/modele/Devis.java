/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfRoutard.metier.modele;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author elmhaidara
 */
@Entity
public class Devis {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDepart;
    
    private int nbPersonnes;
    
    private String contrat;

    @ManyToOne
    private Client client;
    
    @ManyToOne
    private Conseiller conseiller;
    
    @OneToOne
    private Options options;
    
    @OneToOne
    private Voyage voyage;
    
    public Devis(Date dateDepart, int nbPersonnes, String contrat) {
        this.dateDepart = dateDepart;
        this.nbPersonnes = nbPersonnes;
        this.contrat = contrat;
    }

    public Devis() {
    }

    public long getId() {
        return id;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public int getNbPersonnes() {
        return nbPersonnes;
    }

    public void setNbPersonnes(int nbPersonnes) {
        this.nbPersonnes = nbPersonnes;
    }

    public String getContrat() {
        return contrat;
    }

    public void setContrat(String contrat) {
        this.contrat = contrat;
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
    
    
    
}
