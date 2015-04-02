package IfRoutard.metier.service;

import IfRoutard.DAO.ClientDAO;
import IfRoutard.DAO.DevisDAO;
import IfRoutard.DAO.JpaUtil;
import IfRoutard.DAO.VoyageDAO;
import IfRoutard.metier.modele.Client;
import IfRoutard.metier.modele.Devis;
import IfRoutard.metier.modele.Voyage;
import java.util.List;

/**
 * Cette classe fournit un ensemble de services pour les futurs utilisateurs.
 * Les services indispensables à l'application web ont été implémentées conformément au sujet.
 * Les futurs utilisateurs devront veiller à l'utilisation correcte de ces services notamment les exceptions.
 * @author elmhaidara
 */
public class Service {
    
    /**
     * Recupere tous les voyages.
     * @return Liste de tous les voyages de la base
     */
    public static List<Voyage> listAllVoyages(){
        JpaUtil.creerEntityManager();
                
        VoyageDAO vDao = new VoyageDAO();
        List<Voyage> liste = vDao.find();
        
        JpaUtil.fermerEntityManager();
        return liste;
    }
    
    /**
     * Liste de tous les clients de la base.
     * @return 
     */
    public static List<Client> listClient(){
        JpaUtil.creerEntityManager();
        
        ClientDAO cDao = new ClientDAO();
        List<Client> list = cDao.find();
        
        JpaUtil.fermerEntityManager();
        return list;
    }
    
    /**
     * Recupere les voyages se passant dans le pays dont le nom est passé en paramètre
     * @param pays, le pays que l'on souhaite rechercher parmis les voyages.
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
     * Récupère les voyages de type séjour
     * @return les séjours sous la forme d'une liste
     */
    public static List<Voyage> listSejour(){
        JpaUtil.creerEntityManager();
        
        VoyageDAO vDao = new VoyageDAO();
        List<Voyage> liste = vDao.findSejour();
        
        JpaUtil.fermerEntityManager();
        return liste;
    }
    
    /**
     * Récupère tous les voyages de type Circuit
     * @return les circuits sous la forme d'une liste
     */
    public static List<Voyage> listCircuit(){
        JpaUtil.creerEntityManager();
        
        VoyageDAO vDao = new VoyageDAO();
        List<Voyage> liste = vDao.findCircuit();
        
        JpaUtil.fermerEntityManager();
        return liste;
    }
    
    /**
     * Ajoute un client dans la base de donnée.
     * @param newClient 
     * @return Renvoie false si l'ajout s'est mal déroulée, true sinon
     */
    public static boolean ajouterNouveauClient(Client newClient){
        boolean succes;
        JpaUtil.creerEntityManager();
        
        ClientDAO cDao = new ClientDAO();
        succes = cDao.create(newClient);
        
        JpaUtil.fermerEntityManager();
        return succes;
        
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
     * Creer un devis pour un client.
     * @param dev
     */
    public static void creerDevis(Devis dev){
        JpaUtil.creerEntityManager();
        
        DevisDAO dDao = new DevisDAO();
        dDao.create(dev);
        
        JpaUtil.fermerEntityManager(); 
    }
    
    /**
     * Retourne l'id du voyage dont le nom est passée en paramètre.
     * @param id
     * @return 
     */
    public static Voyage voyageParId(int id){
        JpaUtil.creerEntityManager();
        
        Voyage v;
        VoyageDAO vDao = new VoyageDAO();
        v=vDao.find(id);
        
        JpaUtil.fermerEntityManager(); 
        return v;
    }
    
    
}
