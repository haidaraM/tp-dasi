/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b3425.DAO;

import b3425.Client;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ebai
 */
public class ClientDAO extends DAO<Client> {

    //JpaUtil.creerEntityManager();
    private EntityManager em = JpaUtil.obtenirEntityManager();
    
    @Override
    public Client find(int id) {
       /*Query q = em.createQuery("Select c FROM Client c where c.id = :mon_id");
       q.setParameter("mon_id", id);
       Client cl = (Client) q.getSingleResult();
       return cl; */
       Client cl = em.find(Client.class, id);
       return cl;
    }
    
    public List<Client> find(String chaine){
        List<Client> maListe = new ArrayList<Client>();
        Query q = em.createQuery("Select c FROM Client c where c.nom like :ma_chaine or c.prenom like :ma_chaine2 " );
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
    public boolean update(Client obj) {
        Client client = em.find(Client.class, obj.getId());
        return true;
    }

    @Override
    public void delete(Client obj) {
        
    }
    
}
