/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfRoutard.DAO;

import IfRoutard.metier.modele.Client;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author ebai
 */
public class ClientDAO extends DAO<Client> {

    @Override
    public Client find(long id) {
       Client cl = em.find(Client.class, id);
       if(cl != null){
           // on coupe le lien avec la base de donnee
           em.detach(cl);
       }      
       return cl;
    }
       
    public Client findByMail(String maile){
        Query q = em.createQuery("Select c from Client c where c.mail = :mail_client");
        q.setParameter("mail_client", maile);
        List<Client> cl = (List<Client>)q.getResultList();
        if(cl.size() !=1){
            return null;
        }
        else{
            return cl.get(0); 
        }
        
    }

    @Override
    public boolean create(Client obj) {
        boolean succes;
        JpaUtil.ouvrirTransaction();
        try{
        em.persist(obj);
        succes = true;
        }
        catch(Exception e){
        succes = false;
        }
        JpaUtil.validerTransaction();
        return succes;
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
    public List<Client> find() {
        List<Client> maListe = new ArrayList<Client>();
        Query q = em.createQuery("Select c FROM Client c");
        maListe = (List<Client>) q.getResultList();
        return maListe;    
    }
    
}
