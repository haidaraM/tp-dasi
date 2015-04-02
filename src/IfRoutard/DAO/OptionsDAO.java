package IfRoutard.DAO;

import IfRoutard.metier.modele.Options;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 *
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

    @Override
    public List<Options> find() {
        List<Options> maListe = new ArrayList<Options>();
        Query q = em.createQuery("Select o FROM Options o"  );
        maListe = (List<Options>) q.getResultList();
        return maListe;
    }

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

  
}
