package IfRoutard.metier.modele;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
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
    private String Adresse;
    
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
        this.Adresse = adresse; 
    }

    public long getId() {
        return id;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String Nom) {
        this.nom = Nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String Prenom) {
        this.prenom = Prenom;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getMail() {
        return mail;
    }

    public String getAdresse() {
        return Adresse;
    }

    @Override
    public String toString() {
        return prenom +" "+ nom +"\n"
                +Adresse + "\n" 
                +mail + "\n"
                +numeroTelephone;
    }
}
