package IfRoutard.metier.service;

import IfRoutard.DAO.ClientDAO;
import IfRoutard.DAO.JpaUtil;
import IfRoutard.DAO.PaysDAO;
import IfRoutard.DAO.VoyageDAO;
import IfRoutard.metier.modele.Circuit;
import IfRoutard.metier.modele.Client;
import IfRoutard.metier.modele.Pays;
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
        /*String nom = Saisie.lireChaine("Entrez un nom de client :");
        String prenom = Saisie.lireChaine("Entrez un prenom de client : "); */
    
        
        JpaUtil.creerEntityManager();
        ClientDAO cDao = new ClientDAO();     
        /*List<Client> maliste = cDao.find("BAI");
        for (Client maliste1 : maliste) {
            System.out.println(maliste1);
        } */
        VoyageDAO vDao = new VoyageDAO();
        PaysDAO pDao = new PaysDAO();
        
        
        List<Voyage> maListeV = vDao.find();
        for (Voyage maListeV1 : maListeV) {
            
            System.out.println(maListeV1);
        }
        
        JpaUtil.fermerEntityManager();
    }
    
}
