/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfRoutard.metier.modele;

import static IfRoutard.metier.modele.Voyage_.pays;
import java.util.ArrayList;
import java.util.List;
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
 *
 * @author ebai
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String nom;
    
    private int duree;
    
    private String description;
    
    private String code;
    
    @ManyToMany
    protected List<Pays> pays = new ArrayList();
    
    @OneToMany
    protected List<Options> options = new ArrayList();
    
    public Voyage(String nom, int duree, String description, String code) {
        this.nom = nom;
        this.duree = duree;
        this.description = description;
        this.code = code;       
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Pays> getPays() {
        return pays;
    }

    public List<Options> getOptions() {
        return options;
    }
    
    public void addOptions(Options opt){
        options.add(opt);
        
    }
    
    public void addPays(Pays p){
        pays.add(p);
    }
    
    public Voyage() {
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        Pays temp = pays.get(0);
        
        return "-----------------------------------------------------\n"+
                temp.getNom() + "\n"+ temp.getCapitale() + ", "+
                temp.getPopulation() + "hab, "+ temp.getSuperficie() + 
                "km2, langue officielle : "+temp.getLangue() + "\n" +
                "____________________________________________________\n *** [" + this.getId() +
                "] " + this.getNom() + "\n Séjour, " + this.getDuree() + " jour(s) \n" +
                this.getDescription() + "\n\n*Fiche voyage\n";
    }
    
    public String getType(){
        return "";
    }
    
    
    
       
}
