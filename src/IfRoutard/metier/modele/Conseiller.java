package IfRoutard.metier.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ebai
 */
@Entity
public class Conseiller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private String prenom;
    private String mail;

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
    
    
    public String getPrenom() {
        return prenom;
    }
    public String getMail() {
        return mail;
    }

     

}
