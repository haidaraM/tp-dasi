package IfRoutard.DAO;

import IfRoutard.metier.modele.Conseiller;
import IfRoutard.metier.modele.Devis;
import java.util.List;
import javax.persistence.Query;
/**
 * <b> Classe DAO pour la gestion des devis. </b>
 * @author emilien
 */
public class DevisDAO extends DAO<Devis>{

    /**
     * Recupère dans la base de donnée un devis via son ID.
     * @param id
     * @return Renvoie null si ID ne correspond à aucun devis.
     */
    @Override
    public Devis find(long id) {
         Devis dev = em.find(Devis.class, id);
       if(dev != null){
           // on coupe le lien avec la base de donnée
           em.detach(dev);
       }      
       return dev;

    }
    
    /**
     * Persiste un devis dans la base de données. Cette méthode se charge d'attribuer le Conseiller avec le moins de client au devis.
     * @param devis
     * @return 
     * @see Conseiller
     */
    @Override
    public boolean create(Devis devis) {
        boolean succes;
        // recherche du conseiller avec le nombre min de client
        Query q = em.createQuery("Select con From Conseiller con");
        List<Conseiller> liste_conseiller = q.getResultList();
        Conseiller con_min = liste_conseiller.get(0);
        for(Conseiller conseiller : liste_conseiller) {
            if(conseiller.getNumClient() < con_min.getNumClient())
            {
                con_min = conseiller;
            }
        }
        
        devis.setConseiller(con_min);
        
        JpaUtil.ouvrirTransaction();
        try{
            em.persist(devis);
            succes = true;
        }
        catch(Exception e){
            succes = false;
        }
        JpaUtil.validerTransaction();
        return succes;
    }
    /**
     * Met à jour un devis dans la base de données. Lève une exception si le devis n'existe pas dans la base.
     * <b> Cette méthode n'est pas encore implémentée. </b>
     * @param updatedDevis 
     */
    @Override
    public void update(Devis updatedDevis) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    /**
     * Retourne la liste de tous les devis présents dans la base.
     * <b> Cette méthode n'est pas encore implémentée. </b>
     * @return 
     */
    @Override
    public List<Devis> find() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
