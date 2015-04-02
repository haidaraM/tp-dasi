package IfRoutard.metier.service;

import IfRoutard.DAO.ClientDAO;
import IfRoutard.DAO.DevisDAO;
import IfRoutard.DAO.JpaUtil;
import IfRoutard.DAO.OptionsDAO;
import IfRoutard.DAO.VoyageDAO;
import IfRoutard.metier.modele.Client;
import IfRoutard.metier.modele.Devis;
import IfRoutard.metier.modele.Options;
import IfRoutard.metier.modele.Voyage;
import java.util.Date;
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
           
        
        
        Demo.lancerDemo();
        
/*      JpaUtil.creerEntityManager();
        DevisDAO dDAO = new DevisDAO();
        ClientDAO cDAO = new ClientDAO();
        Client c = cDAO.findByMail("ali.villen@hotmail.com"); // un client au piff
        List<Devis> dev = c.getDevis();
        for (Devis dev1 : dev) {
            System.out.println(dev);
        }

        
        JpaUtil.fermerEntityManager();*/
    }
    
}
