package IfRoutard.DAO;

import IfRoutard.metier.modele.Pays;
import java.util.List;
import javax.persistence.Query;

/**
 * <b> Classe DAO pour la gestion d'un Pays </b>
 * @author elmhaidara
 */
public class PaysDAO extends DAO<Pays>{
    
     /**
     * Recupère dans la base de donnée un Pays via son ID.
     * @param id
     * @return Renvoie null si ID ne correspond à aucun pays.
     */
    @Override
    public Pays find(long id) {
        Pays p = em.find(Pays.class, id);
        if(p != null)
            em.detach(p);
        return p;
    }

    /**
     * Retourne la liste de tous les pays présents dans la base.
     * @return 
     */
    @Override
    public List<Pays> find() {
        List<Pays> listePays;
        Query q = em.createQuery("Select p FROM Pays p");
        listePays = (List<Pays>) q.getResultList();
        return listePays;
    }

    /**
     * Persiste un pays dans la base de données.
     * @param obj
     * @return 
     */
    @Override
    public boolean create(Pays obj) {
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
     * Met à jour un pays dans la base de données. Lève une exception si le pays n'existe pas dans la base.
     * <b> Cette méthode n'est pas encore implémentée. </b>
     * @param updatedPays 
     */
    @Override
    public void update(Pays updatedPays) {
          throw new UnsupportedOperationException("Not supported yet."); 
    }
}
