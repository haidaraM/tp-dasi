package IfRoutard.metier.service;

import IfRoutard.DAO.ClientDAO;
import IfRoutard.DAO.DevisDAO;
import IfRoutard.DAO.JpaUtil;
import IfRoutard.DAO.PaysDAO;
import IfRoutard.DAO.VoyageDAO;
import IfRoutard.metier.modele.Circuit;
import IfRoutard.metier.modele.Client;
import IfRoutard.metier.modele.Conseiller;
import IfRoutard.metier.modele.Devis;
import IfRoutard.metier.modele.Pays;
import IfRoutard.metier.modele.Sejour;
import IfRoutard.metier.modele.Voyage;
import java.util.List;
import java.util.Date;

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
        /*for (Voyage maListeV1 : maListeV) {
            
            System.out.println(maListeV1);
        }*/
        Pays p1 = new Pays("Macedoine", 12, 15, "zob", "MAcedoineLa", "MAC", "mace");
        Pays p2 = new Pays("Macedoi", 12, 15, "zob", "MAcedoineLa", "MEC", "mace");
        pDao.create(p1);
        pDao.create(p2);
        
        Sejour v1 = new Sejour("Zejour1", 10, "Description", "MAC", "Hotel");
        Sejour v2 = new Sejour("Aejour2", 8, "Description", "FRA", "Hotel");
        Circuit v3 = new Circuit("Circuit1", 9, "Description3", "FRA2", "Hotel", 12);
        Circuit v4 = new Circuit("Circuit2", 5, "Description4", "MAC2", "Hotel", 12);
        
        v1.addPays(p1);
        v2.addPays(p2);
        v3.addPays(p2);
        v4.addPays(p1);
        
        vDao.create(v1);
        vDao.create(v2);
        vDao.create(v3);
        vDao.create(v4);
        
        maListeV.clear();
        maListeV = vDao.find();
        for (Voyage maListeV1 : maListeV) {
            
            System.out.println(maListeV1);
        }
        
      //  maListeV = vDao.orderByDuree(false, maListeV);
        for (Voyage maListeV1 : maListeV) {
            
            System.out.println(maListeV1);
        }
        
        JpaUtil.fermerEntityManager();
    }
    
}
