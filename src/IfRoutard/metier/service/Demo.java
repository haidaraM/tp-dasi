/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfRoutard.metier.service;

import IfRoutard.DAO.ClientDAO;
import IfRoutard.metier.modele.Client;
import IfRoutard.metier.modele.Saisie;
import java.util.List;


/**
 *
 * @author emilien
 */
public class Demo {
    
    public static void lancerDemo(){
        
        String consignes = "\n*********************Commandes disponibles*************************\n"
                         + "CreerClient -- ListerClients -- CreerDevis -- AfficherDevis -- Quit\n"
                         + "*******************************************************************\n";
        
        String commande = Saisie.lireChaine(consignes);
        while(!"Quit".equals(commande))
        {
            if(null != commande)switch (commande) {
                case "CreerClient":
                    CreerClient();
                    break;
                case "ListerClients":
                    ListerClients();
                    break;
                case "CreerDevis":
                    CreerDevis();
                    break;
                case "AfficherDevis":
                    break;
            }
            commande = Saisie.lireChaine(consignes);
        }
        
    }
    
    public static void CreerClient(){
        String civilite = Saisie.lireChaine("Civilité?\n");
        String nom = Saisie.lireChaine("Nom?\n");
        String prenom = Saisie.lireChaine("Prénom?\n");
        String mail = Saisie.lireChaine("Mail?\n");
        String adresse = Saisie.lireChaine("Adresse?\n");
        String tel = Saisie.lireChaine("Numéro de téléphone?\n");
        Client c = new Client(nom, prenom, civilite, tel, mail, adresse);
        ClientDAO cd = new ClientDAO();
        cd.create(c);
        System.out.println("Client crée !\n"); 
    }
    
    public static void ListerClients(){
        ClientDAO cd = new ClientDAO();
        List<Client> liste = cd.find();
        for (Client liste1 : liste) {
            System.out.println(liste1.toString()+"\n");
        }   
    }
    
    public static void CreerDevis(){
        ClientDAO cd = new ClientDAO();
        String mail = Saisie.lireChaine("Veuillez vous identifier grâce à votre adresse e-mail:\n");
        Client c;
        if ((c=cd.findByMail(mail)) != null){
            String choixrecherche = Saisie.lireChaine("Bienvenue" + c.getPrenom() + "\n"
                    + "Choix du voyage : 1-Par pays\n"
                    + "                  2-Par type - Séjour\n"
                    + "                  3-Par type - Circuit\n"
            );
        }
        else{
            System.out.println("Il n'y a pas de compte associé à cette adresse");
        }
    }
    
    
}
