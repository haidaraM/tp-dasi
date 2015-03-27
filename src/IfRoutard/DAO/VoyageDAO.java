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
        listVoyage = orderByNom(true, listVoyage);
        return listVoyage;
    }
    
    public List<Voyage> findSejour(){
        List<Voyage> listVoyage = new ArrayList();
        Query q = em.createQuery("Select v FROM Sejour v");
        listVoyage = (List<Voyage>) q.getResultList();
        listVoyage = orderByNom(true, listVoyage);
        return listVoyage;
    }
    
    public List<Voyage> findCircuit(){
        List<Voyage> listVoyage = new ArrayList();
        Query q = em.createQuery("Select v FROM Circuit v");
        listVoyage = (List<Voyage>) q.getResultList();
        listVoyage = orderByNom(true, listVoyage);
        return listVoyage;
    }
    /**
     * 
     * @param ascDesc Si 0, la liste sera triée par ordre alphabétique, si 1, l'ordre inverse
     * @param tochange La liste que l'on souhaite inverser
     * @return La liste ordonée par nom dans l'ordre alphabétique/inverse
     */
    private List<Voyage> orderByNom(final boolean ascDesc, List<Voyage> tochange){
        Collections.sort(tochange, new Comparator<Voyage>(){
            @Override
            public int compare(Voyage o1, Voyage o2) {
                if(ascDesc){
                    return o1.getNom().compareToIgnoreCase(o2.getNom());
                }
                else{
                    return -(o1.getNom().compareToIgnoreCase(o2.getNom()));
                }      
            }
        }
        );
        return tochange;
    }
    
    
    
    public List<Voyage> orderByType(final boolean ascDesc, List<Voyage> tochange){
    Collections.sort(tochange, new Comparator<Voyage>(){
            @Override
            public int compare(Voyage o1, Voyage o2) {
                if(ascDesc){
                    return o1.getNom().compareToIgnoreCase(o2.getNom());
                }
                else{
                    return -(o1.getNom().compareToIgnoreCase(o2.getNom()));
                }      
            }
        }
        );
        return tochange;
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
    public List<Voyage> find() {
      List<Voyage> listeVoyage = new ArrayList();
      Query q = em.createQuery("Select v FROM Voyage v" );
      listeVoyage = (List<Voyage>) q.getResultList();
      listeVoyage = orderByNom(true, listeVoyage);
      return listeVoyage;
    }
    
    
    
}
