/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfRoutard.DAO;

import IfRoutard.metier.modele.Client;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ebai
 */
public class ClientDAO extends DAO<Client> {

    
    private final String TABLE_NAME = "Client";
    private EntityManager em = JpaUtil.obtenirEntityManager();
    
    @Override
    public Client find(long id) {
       /*Query q = em.createQuery("Select c FROM Client c where c.id = :mon_id");
       q.setParameter("mon_id", id);
       Client cl = (Client) q.getSingleResult();
       return cl; */
       Client cl = em.find(Client.class, id);
       if(cl != null){
           // on coupe le lien avec la base de donnée
           em.detach(cl);
       }      
       return cl;
    }
    
    public List<Client> find(String chaine){
        // TODO : améliorer la recherche des clients
        List<Client> maListe = new ArrayList<Client>();
        
        Query q = em.createQuery("Select c FROM "+TABLE_NAME+ " c where c.nom like :ma_chaine or c.prenom like :ma_chaine2 " );
        
        q.setParameter("ma_chaine", "%" + chaine +"%");
        q.setParameter("ma_chaine2", "%" + chaine + "%");
        maListe = (List<Client>) q.getResultList();
        return maListe;
    }

    @Override
    public void create(Client obj) {
        JpaUtil.ouvrirTransaction();
        em.persist(obj); 
        JpaUtil.validerTransaction();
    }
    
    @Override
    public void update(Client updatedClient) {
             
        if(em.find(Client.class, updatedClient.getId()) == null)
        {
            throw new IllegalArgumentException("Unknown Client");
        }
        JpaUtil.ouvrirTransaction();
        em.merge(updatedClient);
        JpaUtil.validerTransaction(); 
    }

    @Override
    public void delete(Client clientToDelete) {
        //TODO : faire la suppression d'un client
         
    }

    @Override
    public List<Client> find() {
        List<Client> maListe = new ArrayList<Client>();
        Query q = em.createQuery("Select c FROM "+TABLE_NAME +" c"  );
        maListe = (List<Client>) q.getResultList();
        return maListe;
        
    }
    
}
