package interfacesRemotas;

import java.util.List;

import javax.ejb.Remote;


@Remote
public interface GenericDAORemote<T> {
	
	public List<T> allEntities(String className);
	
	public boolean persist(Object o);
	
	public void salvar(Object entity);
	
	public void remover(Object entity);
	
	public void merge(Object entity);
}
