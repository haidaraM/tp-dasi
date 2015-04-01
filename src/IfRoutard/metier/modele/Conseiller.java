package IfRoutard.metier.modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author ebai
 */
@Entity
public class Conseiller implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private String prenom;
    private String mail;
    
    @OneToMany(mappedBy = "conseiller")
    private List<Devis> devis = new ArrayList();
    
    public Conseiller() {

    }

    public Conseiller(String nom, String prenom, String mail) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public List<Devis> getDevis() {
        return devis;
    }
    
    public int getNumClient()
    {
        return devis.size();
    }
    
    public String getPrenom() {
        return prenom;
    }
    public String getMail() {
        return mail;
    }

    @Override
    public String toString() {
        return nom +" "+prenom +"(" + mail+")";
    }

    

}
