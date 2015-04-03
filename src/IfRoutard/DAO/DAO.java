package IfRoutard.DAO;

import java.util.List;
import javax.persistence.EntityManager;

/**
 * Classe abstraite servant de base pour les differents DAO
 * @author ebai
 * @param <T>
 */
public abstract class DAO<T> {
   
        /**
         * Instance courante de l'Entity Manager
         */
        protected EntityManager em = JpaUtil.obtenirEntityManager();
    
    	/**
	 * Permet de récupérer un objet via son ID
	 * @param id
	 * @return l'objet retrouvé à travers son id
	 */
	public abstract T find(long id);
        
        /**
         * Permet de récuperer tous les objets
         * @return Liste des objets présents dans la base de données
         */
        public abstract List<T> find();
	
	/**
	 * Permet de créer une entrée dans la base de données
	 * par rapport à un objet
	 * @param obj
         * @return 
	 */
	public abstract boolean create(T obj);
	
	/**
	 * Permet de mettre à jour les données d'une entrée dans la base 
	 * @param obj
	 */
	public abstract void update(T obj);
        

}
