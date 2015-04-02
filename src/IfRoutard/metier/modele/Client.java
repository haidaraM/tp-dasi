package IfRoutard.metier.modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


/**
 * <b> Cette classe Client répresente les clients de l'agence de voyage </b>.
 * @author ebai
 */

@Entity
public class Client implements Serializable{
    /**
     * L'identifiant de l'entité dans la base de donnée. Cet identifiant est totalement gérée par JPA et aucune modification n'est possible dessus.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    /**
     * Le nom du client.
     */
    @Column(nullable = false)
    private String nom;
    
    /**
     * Le prénom du client.
     */
    @Column(nullable = false)
    private String prenom;
    
    /**
     * La civilité du client ().
     */
    @Column(nullable = false)
    private String civilite;
    
    @Column(nullable = false, unique = true)
    private String mail;
    
    @Column(nullable = true)
    private String adresse;
    
    private String numeroTelephone;
    
    /**
     * Liste des devis du client.
     * @see Devis
     */
    @OneToMany(mappedBy = "client")
    private List<Devis> devis = new ArrayList();
    
    /**
     * Constructeur sans paramètre.
     */
    public Client() {
    } 
    
    /**
     * Constructeur paramétrée
     * @param Nom Nom du client 
     * @param Prenom Prénom du client
     * @param civilite Civilité du client : M. ou Mme
     * @param numero Numéro de téléphone du client
     * @param mail Adresse mail unique du client
     * @param adresse Adresse complète du client
     */
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
     * @param Nom Nouveau nom 
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
     * @param Prenom Nouveau prénom
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
     * @param civilite Nouvelle civilité
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
     * @param numeroTelephone Nouveau numéro de téléphone
     */
    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    /**
     * Met à jour l'adresse du client.
     * @param Adresse Nouvelle adresse
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

    public List<Devis> getDevis() {
        return devis;
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

