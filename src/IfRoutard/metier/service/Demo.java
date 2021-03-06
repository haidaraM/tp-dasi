package IfRoutard.metier.service;

import IfRoutard.DAO.ClientDAO;
import IfRoutard.DAO.VoyageDAO;
import IfRoutard.metier.modele.Client;
import IfRoutard.metier.modele.Devis;
import IfRoutard.metier.modele.Options;
import IfRoutard.metier.modele.Saisie;
import IfRoutard.metier.modele.Voyage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author emilien
 */
public class Demo {
    
    public static void lancerDemo(){
        
        String consignes = "\n*********************Commandes disponibles*********\n"
                         +   "CreerClient -- ListerClients -- CreerDevis --  Quit\n"
                         +   "***************************************************\n";
        
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
        boolean succes = Service.ajouterNouveauClient(c);
        String aAfficher = ("Expediteur : ifroutard@monde.fr\n"
                        +  "Pour : " + mail + "\nCorps : \nBonjour " + prenom +", \n" );
        if (succes){
           aAfficher += "Nous vous confirmons votre inscription à l'agence IF'Routard. Votre numero de client est :" + c.getId();
        }
        else{
           aAfficher += "Votre inscription à l'agence IF'Routard a échouée. Merci de recommencer ultérieurement";
        }
        System.out.println(aAfficher);
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
        Devis d;
        Options opt;
        String choixrecherche;
        List <Voyage> listeVoyage = new ArrayList();
        int voyageId, optionId, nbPersonnes;
        Voyage vDevis;
        String mail = Saisie.lireChaine("Veuillez vous identifier grâce à votre adresse e-mail:\n");
        Client c;
        if ((c=Service.clientAuthentification(mail)) != null){
            do{
            choixrecherche = Saisie.lireChaine("Bienvenue " + c.getPrenom() + "\n"
                    + "Choix du voyage : 1-Par pays\n"
                    + "                  2-Par type - Séjour\n"
                    + "                  3-Par type - Circuit\n");
            }
            while(!choixrecherche.equals("1")&&!choixrecherche.equals("2")&&!choixrecherche.equals("3"));       
            switch (choixrecherche){
                case "1":
                    listeVoyage = Service.listVoyagePays(Saisie.lireChaine("Nom de Pays?\n"));
                    break;
                case "2":
                    listeVoyage = Service.listSejour();
                    break;
                case "3":
                    listeVoyage = Service.listCircuit();
            }
            for(Voyage lVoyage : listeVoyage){
                System.out.println("**" + lVoyage.getId() + "** -- " + lVoyage.shortDescription() + "\n");
            }
            
            voyageId = Integer.parseInt(Saisie.lireChaine("Indiquer l'identifiant du voyage choisi\n"));
            vDevis = Service.voyageParId(voyageId);
            System.out.println(vDevis.toString());
            optionId = Integer.parseInt(Saisie.lireChaine("\nIndiquer le numéro de l'option choisie\n"));
            System.out.println("Option " + optionId + " choisie!\n");
            opt = vDevis.getOptions().get(optionId);
            nbPersonnes = Integer.parseInt(Saisie.lireChaine("Nombre de personnes au départ ? \n"));
            d = new Devis(new Date(), nbPersonnes);
            d.setClient(c);
            d.setVoyage(vDevis);
            d.setOptions(opt);
            Service.creerDevis(d);
            System.out.println(d);
            
        }
        else {
            System.out.println("Il n'y a pas de compte associé à cette adresse");
        }
    }
    
    
}
