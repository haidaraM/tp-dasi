/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfRoutard.metier.service;

import IfRoutard.DAO.ClientDAO;
import IfRoutard.DAO.DevisDAO;
import IfRoutard.DAO.JpaUtil;
import IfRoutard.DAO.VoyageDAO;
import IfRoutard.metier.modele.Client;
import IfRoutard.metier.modele.Devis;
import IfRoutard.metier.modele.Options;
import IfRoutard.metier.modele.Voyage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elmhaidara
 */
public class Service {
    
    /**
     * Permet de recupérer tous les voyages
     * @return Liste de tous les voyages de la base
     */
    public static List<Voyage> listAllVoyages(){
        JpaUtil.creerEntityManager();
                
        VoyageDAO vDao = new VoyageDAO();
        List<Voyage> liste = vDao.find();
        
        JpaUtil.fermerEntityManager();
        return liste;
    }
    
    public static List<Client> listClient(){
        JpaUtil.creerEntityManager();
        
        ClientDAO cDao = new ClientDAO();
        List<Client> list = cDao.find();
        
        JpaUtil.fermerEntityManager();
        return list;
    }
    
    /**
     * Recupere les voyages se passant dans le pays dont le nom est passé en paramètre
     * @return 
     */
    public static List<Voyage> listVoyagePays(String pays){
        JpaUtil.creerEntityManager();
        
        VoyageDAO vDao = new VoyageDAO();
        List<Voyage> liste = vDao.findPays(pays);
        
        JpaUtil.fermerEntityManager();
        return liste;
    }
    
    /**
     * Ajoute un client dans la base de donnée.
     * @param newClient 
     */
    
    public static void ajouterNouveauClient(Client newClient){
        JpaUtil.creerEntityManager();
        
        ClientDAO cDao = new ClientDAO();
        cDao.create(newClient);
        
        JpaUtil.fermerEntityManager();
    }
    /**
     * Verifie si le mail passé en paramètre correspond à un client. Par soucis de simplicité, on ne gére pas le mot de passe.
     * @param mail
     * @return le client correspondant, null sinon
     */
    public static Client clientAuthentification(String mail){
        JpaUtil.creerEntityManager();
        
        ClientDAO cDao = new ClientDAO();
        Client cl = cDao.findByMail(mail);
        
        JpaUtil.fermerEntityManager();
        return cl;
    }
    
    /**
     * Creer un devis pour un client avec son voyage qu'il a choisi et son option préferée
     * @param dev
     * 
     */
    public static void creerDevis(Devis dev){
        JpaUtil.creerEntityManager();
        
        DevisDAO dDao = new DevisDAO();
        dDao.create(dev);
        
        JpaUtil.fermerEntityManager(); 
    }
    
    
}
