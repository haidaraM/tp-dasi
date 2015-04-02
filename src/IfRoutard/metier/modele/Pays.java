package IfRoutard.metier.modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Classe représentant les differents pays dans lesquels les voyages sont possibles
 * @author elmhaidara
 */
@Entity
public class Pays implements Serializable {
    /**
     * L'identifiant de l'entité dans la base de donnée. Cet identifiant est totalement gérée par JPA et aucune modification n'est possible dessus.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    /**
     * Nom du pays.
     */
    private String nom;
    
    /**
     * Population du pays. Pas forcément à jour
     */
    private double population;
    
    /**
     * Superficie du pays.
     */
    private double superficie;
    
    /**
     * Continent dans lequel se trouve le pays.
     */
    private String region;
    
    /**
     * La capitale du pays.
     */
    private String capitale;
    
    /**
     * Un code unique pour chaque pays.
     */
    @Column(unique = true)
    private String code;
    
    /**
     * La langue officielle du pays.
     */
    private String langue;
    
    @ManyToMany(mappedBy = "pays")
    private List<Voyage> voyages = new ArrayList();

    /**
     * Constructeur paramétrée
     * @param nom
     * @param population
     * @param superficie
     * @param region
     * @param capitale
     * @param code
     * @param langue
     */
    public Pays(String nom, double population, double superficie, String region, String capitale, String code, String langue) {
        this.nom = nom;
        this.population = population;
        this.superficie = superficie;
        this.region = region;
        this.capitale = capitale;
        this.code = code;
        this.langue = langue;
    }

    /**
     * Constructeur sans paramètre.
     */
    public Pays() {
    }
    
    /**
     * Retourne l'identifiant du pays
     * @return
     */
    public long getId() {
        return id;
    }   
    
    /**
     * Retourne le nom du pays.
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * Met à jour le nom du pays.
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne la population du pays.
     * @return
     */
    public double getPopulation() {
        return population;
    }

    /**
     * Met à jour la population du pays.
     * @param population
     */
    public void setPopulation(double population) {
        this.population = population;
    }

    /**
     * Retourne la superficie du pays.
     * @return
     */
    public double getSuperficie() {
        return superficie;
    }

    /**
     * Met à jour la superficie du pays.
     * @param superficie
     */
    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    /**
     * Renvoie le continent dans lequel se trouve le pays.
     * @return
     */
    public String getRegion() {
        return region;
    }

    /**
     * Met à jour le continent du pays.
     * @param region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Retourne la capitable.
     * @return
     */
    public String getCapitale() {
        return capitale;
    }

    /**
     * Met à jour la capitale.
     * @param capitale
     */
    public void setCapitale(String capitale) {
        this.capitale = capitale;
    }

    /**
     * Renvoie le code associé au pays.
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * Met à jour le code associé au pays.
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Retourne la langue du pays.
     * @return
     */
    public String getLangue() {
        return langue;
    }

    /**
     * Met à jour la langue du pays
     * @param langue
     */
    public void setLangue(String langue) {
        this.langue = langue;
    }  

    /**
     * Retourne une description du pays.
     * @return
     */
    @Override
    public String toString() {
        return "Pays : " + nom +" -- "+
                "Code : " + code + " -- " +
                "Langue " + langue +" -- "+
                "Superficie " + superficie;
    }
    
    
    
}
