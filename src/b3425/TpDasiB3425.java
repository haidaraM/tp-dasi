package b3425;

import b3425.DAO.ClientDAO;
import b3425.DAO.JpaUtil;
import javax.persistence.EntityManager;

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
        
      /*  Client cl = new Client();
        cl.setID(1);
        cl.setNom("Emilien");
        cl.setPrenom("Bai");
        JpaUtil.creerEntityManager();
        EntityManager entity = JpaUtil.obtenirEntityManager();
        entity.getTransaction().begin();
        entity.persist(cl);
        entity.getTransaction().commit();
        JpaUtil.fermerEntityManager(); */
        
        
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
        Client cl = new Client("Messi", "Ronaldo");
        cDao.create(cl);
        JpaUtil.fermerEntityManager();
    }
    
}
