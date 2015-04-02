package IfRoutard.DAO;

import IfRoutard.metier.modele.Conseiller;
import IfRoutard.metier.modele.Devis;
import java.util.List;
import javax.persistence.Query;
/**
 *
 * @author emilien
 */
public class DevisDAO extends DAO<Devis>{

    
       
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

    @Override
    public void update(Devis obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Devis> find() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
