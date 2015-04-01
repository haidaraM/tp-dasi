package IfRoutard.metier.modele;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


/**
 * Cette classe répresente les clients de l'agence de voyage.
 * @author ebai
 */

@Entity
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(nullable = false)
    private String nom;
    
    @Column(nullable = false)
    private String prenom;
    
    @Column(nullable = false)
    private String civilite;
    
    @Column(nullable = false, unique = true)
    private String mail;
    
    @Column(nullable = true)
    private String adresse;
    
    private String numeroTelephone;
    
    @OneToMany(mappedBy = "client")
    private List<Devis> devis = new ArrayList();
    
    public Client() {
    } 
    
    public Client(String Nom, String Prenom, String civilite, String numero, String mail, String adresse) {
        this.nom = Nom;
        this.prenom = Prenom;
        this.civilite = civilite;
        this.numeroTelephone = numero;
        this.mail = mail;
        this.adresse = adresse; 
    }

    /**
     * Retourne l'id du client sous lequel il est stocké dans la base de données.
     * @return 
     */
    public long getId() {
        return id;
    }
    
    /**
     * Retourne le nom du client.
     * @return 
     */
    public String getNom() {
        return nom;
    }

    /**
     * Met à jour le nom du client.
     * @param Nom 
     */
    public void setNom(String Nom) {
        this.nom = Nom;
    }

    /**
     * Retourne le prenom du client.
     * @return 
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Met à jour le prénom du client.
     * @param Prenom 
     */
    public void setPrenom(String Prenom) {
        this.prenom = Prenom;
    }

    /**
     * Retourne la civilité du client.
     * @return 
     */
    public String getCivilite() {
        return civilite;
    }

    /**
     * Met à jour la civilité du client.
     * @param civilite 
     */
    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    /**
     * Retourne le numéro de téléphone du client.
     * @return 
     */
    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    /**
     * Met à jour le numéro de téléphone du client.
     * @param numeroTelephone 
     */
    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    /**
     * Met à jour l'adresse du client.
     * @param Adresse 
     */
    public void setAdresse(String Adresse) {
        this.adresse = Adresse;
    }

    /**
     * Retourne l'adresse mail du client.
     * @return 
     */
    public String getMail() {
        return mail;
    }
    
    /**
     * Retourne l'adresse du client.
     * @return 
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Retourne les caractéristiques du client.
     * @return 
     */
    @Override
    public String toString() {
        return prenom +" "+ nom +"\n"
                +adresse + "\n" 
                +mail + "\n"
                +numeroTelephone;
    }
}

