package IfRoutard.DAO;

import IfRoutard.metier.modele.Client;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 * <b> Classe DAO pour la gestion d'un client </b>
 * @author ebai
 */
public class ClientDAO extends DAO<Client> {

    /**
     * Recupère dans la base de donnée un client via son ID.
     * @param id
     * @return Renvoie null si ID ne correspond à aucun client.
     */
    @Override
    public Client find(long id) {
       Client cl = em.find(Client.class, id);
       if(cl != null){
           // on coupe le lien avec la base de donnee
           em.detach(cl);
       }      
       return cl;
    }
       
    /**
     * Recupère un client dans la base de donnée via son email.
     * @param mail
     * @return Renvoie null si le mail ne correspond à aucun client.
     */
    public Client findByMail(String mail){
        Query q = em.createQuery("Select c from Client c where c.mail = :mail_client");
        q.setParameter("mail_client", mail);
        List<Client> cl = (List<Client>)q.getResultList();
        if(cl.size() !=1){
            return null;
        }
        else{
            return cl.get(0); 
        }
        
    }
    /**
     * Persiste un client dans la base de données.
     * @param client
     * @return 
     */
    @Override
    public boolean create(Client client) {
        boolean succes;
        JpaUtil.ouvrirTransaction();
        try{
            em.persist(client);
            succes = true;
        }
        catch(Exception e){
            succes = false;
        }
        JpaUtil.validerTransaction();
        return succes;
    }
    
    /**
     * Met à jour un client dans la base de données. Lève une exception si le client n'existe pas dans la base.
     * @param updatedClient 
     */
    @Override
    public void update(Client updatedClient) {
             
        if(em.find(Client.class, updatedClient.getId()) == null)
        {
            throw new IllegalArgumentException("Unknown Client");
        }
        JpaUtil.ouvrirTransaction();
        em.merge(updatedClient);
        JpaUtil.validerTransaction(); 
    }
    
    /**
     * Recupère la liste de tous les clients présents dans la base de données.
     * @return 
     */
    @Override
    public List<Client> find() {
        List<Client> maListe = new ArrayList<Client>();
        Query q = em.createQuery("Select c FROM Client c");
        maListe = (List<Client>) q.getResultList();
        return maListe;    
    }
    
}
