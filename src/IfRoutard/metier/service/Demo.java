/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfRoutard.metier.service;

import IfRoutard.DAO.ClientDAO;
import IfRoutard.DAO.VoyageDAO;
import IfRoutard.metier.modele.Client;
import IfRoutard.metier.modele.Saisie;
import IfRoutard.metier.modele.Voyage;
import java.util.ArrayList;
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
        Service.ajouterNouveauClient(c);
        System.out.println("Client crée !\n"); 
    }
    
    public static void ListerClients(){
        
        List<Client> liste = Service.listClient();
        for (Client liste1 : liste) {
            System.out.println(liste1.toString()+"\n");
        }   
    }
    
    public static void CreerDevis(){
        ClientDAO cd = new ClientDAO();
        VoyageDAO vd = new VoyageDAO();
        String choixrecherche;
        List <Voyage> listeVoyage = new ArrayList();
        String mail = Saisie.lireChaine("Veuillez vous identifier grâce à votre adresse e-mail:\n");
        Client c;
        if ((c=cd.findByMail(mail)) != null){
            do{
            choixrecherche = Saisie.lireChaine("Bienvenue" + c.getPrenom() + "\n"
                    + "Choix du voyage : 1-Par pays\n"
                    + "                  2-Par type - Séjour\n"
                    + "                  3-Par type - Circuit\n");
            }
            while(!choixrecherche.equals("1")||!choixrecherche.equals("2")||!choixrecherche.equals("3"));       
            switch (choixrecherche){
                case "1":
                    listeVoyage = vd.findPays(Saisie.lireChaine("Nom de Pays?\n"));
                    break;
                case "2":
                    listeVoyage = vd.findSejour();
                    break;
                case "3":
                    listeVoyage = vd.findCircuit();
            }
            for(Voyage lVoyage : listeVoyage){
                System.out.println(lVoyage.getId() + " " + lVoyage.toString());
            }
            
        }
        else {
            System.out.println("Il n'y a pas de compte associé à cette adresse");
        }
    }
    
    
}
