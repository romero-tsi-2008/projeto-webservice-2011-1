package sessionBeans;

import interfacesRemotas.CategoriaRemote;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sessionDaos.GenericDAOBean;
import entityBeans.Categoria;

@Stateless(mappedName="CategoriaBean")
public class CategoriaBean implements CategoriaRemote {
	@PersistenceContext(unitName="meuPersistenceContext") EntityManager em;

	GenericDAOBean<Categoria> dao;

	List<Categoria> categorias = dao.allEntities("Categoria");
	
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

	@Override
	public List<Categoria> autocompletar(Object sugestao) {
		String pref = (String) sugestao;
		System.out.println(pref);
		List<Categoria> resultado = new ArrayList<Categoria>();
		System.out.println(categorias.size());
		Iterator<Categoria> it = categorias.iterator();
		while(it.hasNext()) {
			Categoria elem = it.next();
			if ((elem.getDescricao() != null && elem.getDescricao().toLowerCase().indexOf(pref.toLowerCase()) == 0) || "".equals(pref)) {
				resultado.add(elem);
			}
		}
		return resultado;
	}


}
