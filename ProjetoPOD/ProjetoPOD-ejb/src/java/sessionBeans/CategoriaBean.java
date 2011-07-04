package sessionBeans;

import interfacesRemotas.CategoriaRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entityBeans.Categoria;

@Stateless(mappedName="CategoriaBean")
public class CategoriaBean implements CategoriaRemote {
	@PersistenceContext(unitName="meuPersistenceContext") EntityManager em;
	
	private Categoria categoria;
	
	public CategoriaBean() {}

	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public boolean cadastrar(Categoria categoria) {
		try {
			em.persist(categoria);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
