/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfRoutard.DAO;

import IfRoutard.metier.modele.Client;
import IfRoutard.metier.modele.Conseiller;
import IfRoutard.metier.modele.Devis;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
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
    public void create(Devis devis) {
        
        // recherche du conseiller avec le nombre min de client
        Query q = em.createQuery("Select con From Conseiller con");
        List<Conseiller> liste_conseiller = new ArrayList();
        liste_conseiller = q.getResultList();
        Conseiller con_min = liste_conseiller.get(0);
        for (Conseiller conseiller : liste_conseiller) {
            if(conseiller.getNumClient() < con_min.getNumClient())
            {
                con_min = conseiller;
            }
        }
        
        devis.setConseiller(con_min);
        
        JpaUtil.ouvrirTransaction();
        em.persist(devis); 
        JpaUtil.validerTransaction();
    }

    @Override
    public void update(Devis obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Devis> find() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void ArrayList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
