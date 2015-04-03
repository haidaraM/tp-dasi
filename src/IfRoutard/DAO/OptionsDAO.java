package IfRoutard.DAO;

import IfRoutard.metier.modele.Options;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 * <b> Classe DAO pour la gestion des options d'un voyage </b>
 * @author elmhaidara
 */
public class OptionsDAO extends DAO<Options> {
    
    @Override
    public Options find(long id) {
        Options op = em.find(Options.class, id);
       if(op != null){
           // on coupe le lien avec la base de donnée
           em.detach(op);
       }      
       return op;
    }
    
    /**
     * Retourne la liste de toutes les options présentes dans la base.
     * <b> Cette méthode n'est pas encore implémentée </b>
     * @return 
     */
    @Override
    public List<Options> find() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    /**
     * Persiste une option dans la base de données.
     * @param obj
     * @return 
     */
    @Override
    public boolean create(Options obj) {
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
     * Met à jour une option dans la base de données.
     * <b> Cette méthode n'est pas encore implémentée. </b>
     * @param updatedOption  
     */
    @Override
    public void update(Options updatedOption) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }  
}
