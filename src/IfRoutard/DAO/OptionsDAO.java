/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfRoutard.DAO;

import IfRoutard.metier.modele.Options;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author elmhaidara
 */
public class OptionsDAO extends DAO<Options> {
    
    private EntityManager em = JpaUtil.obtenirEntityManager();

    @Override
    public Options find(long id) {
        Options op = em.find(Options.class, id);
       if(op != null){
           // on coupe le lien avec la base de donnée
           em.detach(op);
       }      
       return op;
    }

    @Override
    public List<Options> find() {
        List<Options> maListe = new ArrayList<Options>();
        Query q = em.createQuery("Select o FROM Options o"  );
        maListe = (List<Options>) q.getResultList();
        return maListe;
    }

    @Override
    public void create(Options obj) {
        JpaUtil.ouvrirTransaction();
        em.persist(obj); 
        JpaUtil.validerTransaction();
    }

    @Override
    public void update(Options updatedOption) {
        if(em.find(Options.class, updatedOption.getId()) == null)
        {
            throw new IllegalArgumentException("Unknown option");
        }
        JpaUtil.ouvrirTransaction();
        em.merge(updatedOption);
        JpaUtil.validerTransaction(); 
    }

    @Override
    public void delete(Options obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
