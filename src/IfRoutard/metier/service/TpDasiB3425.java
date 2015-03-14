package IfRoutard.metier.service;

import IfRoutard.DAO.ClientDAO;
import IfRoutard.DAO.JpaUtil;
import IfRoutard.DAO.VoyageDAO;
import IfRoutard.metier.modele.Circuit;
import IfRoutard.metier.modele.Client;
import IfRoutard.metier.modele.Sejour;
import IfRoutard.metier.modele.Voyage;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ebai
 */
public class TpDasiB3425 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*String nom = Saisie.lireChaine("Entrez un nom de client");
        String prenom = Saisie.lireChaine("Entrez un prenom de client"); */
        
       // Client cl = new Client(nom, prenom);
        /*JpaUtil.creerEntityManager();
        JpaUtil.ouvrirTransaction();
        JpaUtil.obtenirEntityManager().persist(cl);
        JpaUtil.validerTransaction();
        JpaUtil.fermerEntityManager(); */
        
        JpaUtil.creerEntityManager();
        ClientDAO cDao = new ClientDAO();     
        /*List<Client> maliste = cDao.find("BAI");
        for (Client maliste1 : maliste) {
            System.out.println(maliste1);
        } */
        VoyageDAO vDao = new VoyageDAO();
        /*Sejour sej = new Sejour("Beau goss",454,"momo","Sofitel");
        vDao.create(sej);
        
        Client cl = new Client("Haidara", "Mohamed", "M", "01010100", "mmmmmm");
        cDao.create(cl);
        
        Circuit cir = new Circuit("Very bad trip a Tomboctou", 20, "Cool", "Quad", 10);
        vDao.create(cir); */
        
        List<Voyage> maListeV = vDao.find();
        for (Voyage maListeV1 : maListeV) {
            System.out.println(maListeV1);
        }
        
        JpaUtil.fermerEntityManager();
    }
    
}
