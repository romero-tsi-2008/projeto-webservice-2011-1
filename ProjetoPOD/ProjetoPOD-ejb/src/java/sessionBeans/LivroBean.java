package sessionBeans;

import interfacesRemotas.LivroRemote;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entityBeans.Categoria;
import entityBeans.Editora;
import entityBeans.Estante;
import entityBeans.Livro;

@Stateless(mappedName="LivroBean")
public class LivroBean implements LivroRemote {
	@PersistenceContext(unitName="meuPersistenceContext") 
	EntityManager em;
	
	Livro livro;
	
	public List<SelectItem> listarCategorias() {
		List<Categoria> categorias = new ArrayList<Categoria>();
		List<SelectItem> itens = new ArrayList<SelectItem>();
		
		Query q = em.createQuery("select c from Categoria c");
		categorias = q.getResultList();
		
		for (Categoria c : categorias) {			
			itens.add(new SelectItem(c.getId(), c.getDescricao()));			
		}
		return itens;
	}

	@Override
	public List<SelectItem> listarEditoras() {
		List<Editora> editoras = new ArrayList<Editora>();
		List<SelectItem> itens = new ArrayList<SelectItem>();
		
		Query q = em.createQuery("select e from Editora e");
		editoras =  q.getResultList();
		
		for (Editora a : editoras) {			
			itens.add(new SelectItem(a.getId(), a.getDescricao()));			
		}
		return itens;
	}
	
	@Override
	public List<SelectItem> listarEstantes() {
		List<Estante> estantes = new ArrayList<Estante>();
		List<SelectItem> itens = new ArrayList<SelectItem>();
		
		Query q = em.createQuery("select e from Estante e");
		estantes =  q.getResultList();
		
		for (Estante e : estantes) {			
			itens.add(new SelectItem(e.getId(), e.getDescricao()));			
		}
		return itens;
	}

	@Override
	public boolean cadastrarLivro(Livro livro) {
		try {
			em.persist(livro);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removerLivro(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Livro pesquisarLivro(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
