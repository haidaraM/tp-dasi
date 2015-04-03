package IfRoutard.metier.modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * <b>Voyage est la classe abstraite représentant un voyage proposé par l'agence de voyage. </b>
 * @author ebai
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class Voyage implements Serializable {
    /**
     * L'identifiant de l'entité dans la base de donnée. Cet identifiant est totalement gérée par JPA et aucune modification n'est possible dessus.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    /**
     * Le nom du voyage.
     */
    private String nom;
    
    /**
     * Le durée en jour du voyage.
     */
    private int duree;
    
    /**
     * Une description détaillée du voyage.
     */
    private String description;
    
    /**
     * Un code unique pour le voyage.
     */
    @Column(unique = true)
    private String code;
    
    /**
     * Liste des pays dans lequel le voyage se passe.
     * @see Pays
     */
    @ManyToMany
    protected List<Pays> pays = new ArrayList();
    
    /**
     * Liste des options disponibles pour ce voyage.
     * @see Options
     */
    @OneToMany
    protected List<Options> options = new ArrayList();
    
    /**
     * Constructeur paramétrée
     * @param nom
     * @param duree
     * @param description
     * @param code
     */
    public Voyage(String nom, int duree, String description, String code) {
        this.nom = nom;
        this.duree = duree;
        this.description = description;
        this.code = code;       
    }
    
    /**
     * Constructeur sans paramètre.
     */
    public Voyage() {
    }
    /**
     * Retourne un code unique du voyage pour un voyage.
     * @return 
     */
    public String getCode() {
        return code;
    }

    /**
     * Met à jour le code du voyage qui doit être unique.
     * @param code 
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Retourne la liste des pays dans lequel le voyage se déroule.
     * @return 
     */
    public List<Pays> getPays() {
        return pays;
    }

    /**
     * Retourne la liste des options disponibles pour ce voyage.
     * @return 
     */
    public List<Options> getOptions() {
        return options;
    }
    
    /**
     * Ajoute une option au voyage.
     * @param opt 
     */
    public void addOptions(Options opt){
        options.add(opt);
        
    }
    
    /**
     * Ajoute un pays au voyage.
     * @param p 
     */
    public void addPays(Pays p){
        pays.add(p);
    }
    
    /**
     * Retourne l'identifiant du voyage.
     * @return 
     */
    public long getId() {
        return id;
    }
    
    /**
     * Renvoie le nom du voyage.
     * @return 
     */

    public String getNom() {
        return nom;
    }

    /**
     * Met à jour le nom du voyage.
     * @param nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne la durée du voyage.
     * @return 
     */
    public int getDuree() {
        return duree;
    }

    /**
     * Met à jour la durée du voyage.
     * @param duree 
     */
    public void setDuree(int duree) {
        this.duree = duree;
    }

    /**
     * Retourne la description du voyage.
     * @return 
     */
    public String getDescription() {
        return description;
    }

    /**
     * Met à jour la description du voyage.
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retourne description succincte du voyage.
     * @return 
     */
    public String shortDescription(){
        return (nom +" "+ pays.get(0).getNom() + " " + this.getType());
    }
    
    /**
     * Retourne une description détaillée du voyage.
     * @return 
     */
    @Override
    public String toString() {
        Pays temp = pays.get(0);
        
        return "-----------------------------------------------------\n"+
                temp.getNom() + "\n"+ temp.getCapitale() + ", "+
                temp.getPopulation() + "hab, "+ temp.getSuperficie() + 
                "km2, langue officielle : "+temp.getLangue() + "\n" +
                "____________________________________________________\n *** [" + this.getId() +
                "] " + this.getNom() +"\n" + this.getType() + "\n" +
                this.getDescription() + "\n\n*Fiche voyage\n";
    }
    
    /**
     * Retourne une description succincte du voyage
     * @return 
     */
    public abstract String getType(); 
       
}
