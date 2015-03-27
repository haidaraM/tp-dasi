/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IfRoutard.DAO;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author ebai
 * @param <T>
 */
public abstract class DAO<T> {
   
        // TODO : enlever les méthodes inutiles
        
        protected EntityManager em = JpaUtil.obtenirEntityManager();
    
    	/**
	 * Permet de récupérer un objet via son ID
	 * @param id
	 * @return
	 */
	public abstract T find(long id);
        
        /**
         * Permet de récuperer tous les objets
         * @return
         */
        public abstract List<T> find();
	
	/**
	 * Permet de créer une entrée dans la base de données
	 * par rapport à un objet
	 * @param obj
	 */
	public abstract void create(T obj);
	
	/**
	 * Permet de mettre à jour les données d'une entrée dans la base 
	 * @param obj
         * @return 
	 */
	public abstract void update(T obj);
        
	
	/**
	 * Permet la suppression d'une entrée de la base
	 * @param obj
	 */
	public abstract void delete(T obj);

}
