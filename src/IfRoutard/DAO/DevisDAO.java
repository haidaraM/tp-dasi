/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfRoutard.DAO;

import IfRoutard.metier.modele.Client;
import IfRoutard.metier.modele.Devis;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
/**
 *
 * @author emilien
 */
public class DevisDAO extends DAO<Devis>{

    
    private EntityManager em = JpaUtil.obtenirEntityManager();
    
    @Override
    public Devis find(long id) {
         Devis dev = em.find(Devis.class, id);
       if(dev != null){
           // on coupe le lien avec la base de donnée
           em.detach(dev);
       }      
       return dev;

    }
    
    
    public List<Devis> find(String chaine) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Devis obj) {
        JpaUtil.ouvrirTransaction();
        em.persist(obj); 
        JpaUtil.validerTransaction();
    }

    @Override
    public void update(Devis obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Devis obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Devis> find() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
