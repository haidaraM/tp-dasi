/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfRoutard.DAO;


import IfRoutard.metier.modele.Voyage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ebai
 */
public class VoyageDAO extends DAO<Voyage> {

    
    
    @Override
    public Voyage find(long id) {
        Voyage vo = em.find(Voyage.class, id);
        if(vo != null){
           // on coupe le lien avec la base de donnée
           em.detach(vo);
       }   
        return vo;
    }
    
    public List<Voyage> findPays(String pays){
        List<Voyage> listVoyage = new ArrayList();
        Query q = em.createQuery("Select v FROM Voyage v join v.pays p where p.nom like :pays_nom");
        q.setParameter("pays_nom", "%" + pays + "%");
        listVoyage = (List<Voyage>) q.getResultList();
        return listVoyage;
    }
    
    public List<Voyage> findSejour(){
        List<Voyage> listVoyage = new ArrayList();
        Query q = em.createQuery("Select v FROM Sejour v");
        listVoyage = (List<Voyage>) q.getResultList();
        return listVoyage;
    }
    
    public List<Voyage> findCircuit(){
        List<Voyage> listVoyage = new ArrayList();
        Query q = em.createQuery("Select v FROM Circuit v");
        listVoyage = (List<Voyage>) q.getResultList();
        return listVoyage;
    }

    @Override
    public boolean create(Voyage obj) {
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
    public List<Voyage> find() {
      List<Voyage> listeVoyage = new ArrayList();
      Query q = em.createQuery("Select v FROM Voyage v" );
      listeVoyage = (List<Voyage>) q.getResultList();
      return listeVoyage;
    }
    
    
    
}
