/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfRoutard.DAO;

import IfRoutard.metier.modele.Pays;
import IfRoutard.metier.modele.Voyage;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author elmhaidara
 */
public class PaysDAO extends DAO<Pays>{
    
    private EntityManager em = JpaUtil.obtenirEntityManager();

    @Override
    public Pays find(long id) {
        Pays p = em.find(Pays.class, id);
        if(p != null)
            em.detach(p);
        return p;
    }

    @Override
    public List<Pays> find() {
        List<Pays> listePays = new ArrayList<Pays>();
        Query q = em.createQuery("Select p FROM Pays p");
        listePays = (List<Pays>) q.getResultList();
        return listePays;
    }

    @Override
    public void create(Pays obj) {
        JpaUtil.ouvrirTransaction();
        em.persist(obj);
        JpaUtil.validerTransaction();
    }

    @Override
    public void update(Pays obj) {
        if(em.find(Voyage.class, obj.getId()) == null)
        {
            throw new IllegalArgumentException("Unknown Pays");
        }
        JpaUtil.ouvrirTransaction();
        em.merge(obj);
        JpaUtil.validerTransaction();  
    }

    @Override
    public void delete(Pays obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
