package IfRoutard.metier.service;

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
           
        //JpaUtil.creerEntityManager();
        
        Demo.lancerDemo();
        
        /*DevisDAO dDAO = new DevisDAO();
        ClientDAO cDAO = new ClientDAO();
        VoyageDAO vDAO = new VoyageDAO();
        Voyage v = vDAO.find(173); // je prends un voyage au piff avec au moins une option
        Client c = cDAO.findByMail("mgoyat@yahoo.com"); // un client au piff
        Options o = v.getOptions().get(0); // la premiere option
        Devis dev = new Devis(new Date(), 2); // la date courante avec deux personnes
        
        OptionsDAO oDao = new OptionsDAO();
        Options op = new Options("Bamako", new Date(), 454, "Bateau");
        
        dev.setOptions(op);
        dev.setClient(c);
        dev.setVoyage(v);
        
  
        dDAO.create(dev); */
       

        
        //JpaUtil.fermerEntityManager();
    }
    
}
