package IfRoutard.DAO;


import IfRoutard.metier.modele.Voyage;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 * <b> Classe DAO pour la gestion d'un voyage </b>
 * @author ebai
 */
public class VoyageDAO extends DAO<Voyage> {

    
     /**
     * Recupère dans la base de donnée un voyage via son ID.
     * @param id
     * @return Renvoie null si ID ne correspond à aucun voyage.
     */
    @Override
    public Voyage find(long id) {
        Voyage vo = em.find(Voyage.class, id);
        if(vo != null){
           // on coupe le lien avec la base de donnée
           em.detach(vo);
       }   
        return vo;
    }
    
    /**
     * Renvoie la liste des voyages se passant dans le pays dont le nom est passée en paramètre.
     * @param pays
     * @return 
     */
    public List<Voyage> findPays(String pays){
        List<Voyage> listVoyage;
        Query q = em.createQuery("Select v FROM Voyage v join v.pays p where p.nom like :pays_nom");
        q.setParameter("pays_nom", "%" + pays + "%");
        listVoyage = (List<Voyage>) q.getResultList();
        return listVoyage;
    }
    
    /**
     * Renvoie la liste des séjours.
     * @return 
     */
    public List<Voyage> findSejour(){
        List<Voyage> listVoyage = new ArrayList();
        Query q = em.createQuery("Select v FROM Sejour v");
        listVoyage = (List<Voyage>) q.getResultList();
        return listVoyage;
    }
    
    /**
     * Renvoie la liste des séjours.
     * @return 
     */
    public List<Voyage> findCircuit(){
        List<Voyage> listVoyage = new ArrayList();
        Query q = em.createQuery("Select v FROM Circuit v");
        listVoyage = (List<Voyage>) q.getResultList();
        return listVoyage;
    }
    
    /**
     * Persiste un voyage dans la base de données.
     * @param obj
     * @return 
     */
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

     /**
     * Met à jour un voyage dans la base de données. Lève une exception si le voyage n'existe pas dans la base.
     * <b> Cette méthode n'est pas encore implémentée. </b>
     * @param updatedVoyage 
     */
    @Override
    public void update(Voyage updatedVoyage) {
        throw new UnsupportedOperationException("Not supported yet.");   
   
    }

    /**
     * Retourne la liste de tous les voyages.
     * @return 
     */
    @Override
    public List<Voyage> find() {
      List<Voyage> listeVoyage = new ArrayList();
      Query q = em.createQuery("Select v FROM Voyage v" );
      listeVoyage = (List<Voyage>) q.getResultList();
      return listeVoyage;
    }
    
    
    
}
