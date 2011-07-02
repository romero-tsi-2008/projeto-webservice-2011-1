package sessionDaos;

import interfacesRemotas.GenericDAORemote;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless(mappedName="GenericDAOBean")
public class GenericDAOBean<T> implements GenericDAORemote {

	@PersistenceContext(unitName="meuPersistenceContext") 
	protected EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> allEntities(String className) {
		List<T> all = new ArrayList<T>();
		Query q = em.createQuery("select x from "+className+" x");
		all = q.getResultList();
		
		return all;
	}
	
	public EntityManager getManager() {
		return em;
	}

	@Override
	public boolean persist(Object o) {
		try {
			em.persist(o);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public void salvar(Object entity) {
		em.persist(entity);
	}

	@Override
	public void remover(Object entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}
	
	@Override
	public void merge(Object entity) {
		em.merge(entity);
	}
}
