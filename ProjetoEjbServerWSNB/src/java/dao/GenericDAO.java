/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author romero
 */
public class GenericDAO<X> {
    private static EntityManager manager;
    
    protected GenericDAO() {
        manager = getManager();
    }
    
    protected static EntityManager getManager(){
        if(manager == null){
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetobdnc");
            manager = factory.createEntityManager();
        }
        return manager;
    }
    
    public void begin(){            
        if (!estaAtivo()) {
            getManager().getTransaction().begin();
        }
    }       
    
    public void close(){
        if (estaAtivo()) {
            getManager().close();
            manager = null;
        }
    }
    public void clear(){
        getManager().clear();
    }
    
    public void commit(){
        if (estaAtivo()) {
            getManager().getTransaction().commit();
        }
    }
    
    public void rollback(){
        if (estaAtivo()) {
            getManager().getTransaction().rollback();
        }
    }       
    
    public void persist(X obj) {
        getManager().persist(obj);
    }
    
    public void remove(X obj){
        getManager().remove(obj);               
    }
    
    public void merge(X obj){
        getManager().merge(obj);
    }       
    
    public void refresh(X obj) {
        getManager().refresh(obj);
    }
    
    public void flush() {
        getManager().flush();           
    }
    
    public boolean estaAtivo(){
        if(getManager().getTransaction().isActive())
            return true;
        else
            return false;           
    }

    public void reopen(){
	    if(getManager().isOpen() == false)
	        getManager().getTransaction().begin();
    }
    
//    public synchronized X findByQuery(String query) {               
//        Query q = (Query) getManager().createQuery(query);
//        return (X) q.getSingleResult();                         
//    }
//    
//    public synchronized List<X> findAllByQueryLimited(String query, int max) {      
//        Query q = (Query) getManager().createQuery(query);
//        q.setFirstResult(0);
//        q.setMaxResults(max);
//        return q.getResultList();
//    }

}
