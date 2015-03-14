/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfRoutard.DAO;

import IfRoutard.metier.modele.Option;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author elmhaidara
 */
public class OptioDAO extends DAO<Option> {
     private final String TABLE_NAME = "Option";
    private EntityManager em = JpaUtil.obtenirEntityManager();

    @Override
    public Option find(long id) {
        Option op = em.find(Option.class, id);
       if(op != null){
           // on coupe le lien avec la base de donnée
           em.detach(op);
       }      
       return op;
    }

    @Override
    public List<Option> find() {
        List<Option> maListe = new ArrayList<Option>();
        Query q = em.createQuery("Select o FROM "+TABLE_NAME +" o"  );
        maListe = (List<Option>) q.getResultList();
        return maListe;
    }

    @Override
    public void create(Option obj) {
        JpaUtil.ouvrirTransaction();
        em.persist(obj); 
        JpaUtil.validerTransaction();
    }

    @Override
    public void update(Option updatedOption) {
         if(em.find(Option.class, updatedOption.getId()) == null)
        {
            throw new IllegalArgumentException("Unknown option");
        }
        JpaUtil.ouvrirTransaction();
        em.merge(updatedOption);
        JpaUtil.validerTransaction(); 
    }

    @Override
    public void delete(Option obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
