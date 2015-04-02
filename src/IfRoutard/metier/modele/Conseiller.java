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
 * Représente un conseiller de l'agence de voyage
 * @author ebai
 */
@Entity
public class Conseiller implements Serializable {
    /**
     * L'identifiant de l'entité dans la base de donnée. Cet identifiant est totalement gérée par JPA et aucune modification n'est possible dessus.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private String prenom;
    private String mail;
    
    @OneToMany(mappedBy = "conseiller")
    private List<Devis> devis = new ArrayList();
    
    /**
     * Constructeur sans paramètre. 
     */
    public Conseiller() {

    }

    /**
     * Constructeur parametrée.
     * @param nom
     * @param prenom
     * @param mail
     */
    public Conseiller(String nom, String prenom, String mail) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
    }

    /**
     * Retourne l'identifiant du conseiller.
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return
     */
    public List<Devis> getDevis() {
        return devis;
    }
    
    /**
     *
     * @return
     */
    public int getNumClient()
    {
        return devis.size();
    }
    
    /**
     *
     * @return
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     *
     * @return
     */
    public String getMail() {
        return mail;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return nom +" "+prenom +"(" + mail+")";
    }

    

}
