/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfRoutard.metier.modele;

/**
 *
 * @author ebai
 */
public class Adresse {
    private int codePostal;
    private String rue;
    private String ville;

    public Adresse(int codePostal, String rue, String ville) {
        this.codePostal = codePostal;
        this.rue = rue;
        this.ville = ville;
    }

    public Adresse() {
        
    }
    
    

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    
    
}
