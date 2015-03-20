/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfRoutard.DAO;


import IfRoutard.metier.modele.Client;
import IfRoutard.metier.modele.Voyage;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ebai
 */
public class VoyageDAO extends DAO<Voyage> {

    private final String TABLE_NAME = "Voyage";
    private EntityManager em = JpaUtil.obtenirEntityManager();
    
    @Override
    public Voyage find(long id) {
        Voyage vo = em.find(Voyage.class, id);
        if(vo != null){
           // on coupe le lien avec la base de donnée
           em.detach(vo);
       }   
        return vo;
    }
    
    /*public List<Voyage> find(String name){
        List<Voyage> listVoyage = new ArrayList();
        Query q = em.createQuery("Select v FROM "+TABLE_NAME +" v where nom like :nom_voyage" );
        q.setParameter("nom_voyage", "%"+name+"%");
        listVoyage = (List<Voyage>) q.getResultList();
        return listVoyage;
    }*/
    
    public List<Voyage> findPays(String pays){
        List<Voyage> listVoyage = new ArrayList();
        Query q = em.createQuery("Select v FROM Voyage v join v.pays p where p.nom like :pays_nom");
        q.setParameter("pays_nom", "%" + pays + "%");
        listVoyage = (List<Voyage>) q.getResultList();
        return listVoyage;
    }

    @Override
    public void create(Voyage obj) {
        JpaUtil.ouvrirTransaction();
        em.persist(obj);
        JpaUtil.validerTransaction();
    }

    @Override
    public void update(Voyage updatedVoyage) {
        if(em.find(Voyage.class, updatedVoyage.getId()) == null)
        {
            throw new IllegalArgumentException("Unknown Voyage");
        }
        JpaUtil.ouvrirTransaction();
        em.merge(updatedVoyage);
        JpaUtil.validerTransaction();    
   
    }

    @Override
    public void delete(Voyage obj) {
        //TODO : faire la suppression d'un voyage
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Voyage> find() {
      List<Voyage> listeVoyage = new ArrayList();
      Query q = em.createQuery("Select v FROM "+TABLE_NAME +" v" );
      listeVoyage = (List<Voyage>) q.getResultList();
      return listeVoyage;
    }
    
}
