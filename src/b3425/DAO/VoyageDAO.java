/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b3425.DAO;


import b3425.Voyage;
import javax.persistence.EntityManager;

/**
 *
 * @author ebai
 */
public class VoyageDAO extends DAO<Voyage> {

    private EntityManager em = JpaUtil.obtenirEntityManager();
    
    @Override
    public Voyage find(int id) {
        Voyage vo = em.find(Voyage.class, id);
        return vo;
    }

    @Override
    public void create(Voyage obj) {
        em.persist(obj);
    }

    @Override
    public boolean update(Voyage obj) {
        JpaUtil.ouvrirTransaction();
        
       JpaUtil.validerTransaction();
       
       return true;
    }

    @Override
    public void delete(Voyage obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
