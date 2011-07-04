package sessionBeans;

import interfacesRemotas.LivroRemote;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sessionDaos.LivroDAOBean;
import entityBeans.Autor;
import entityBeans.Categoria;
import entityBeans.Editora;
import entityBeans.Estante;
import entityBeans.Idioma;
import entityBeans.Livro;

@Stateless(mappedName="LivroBean")
public class LivroBean implements LivroRemote {
	@PersistenceContext(unitName="meuPersistenceContext") 
	EntityManager em;
	
	LivroDAOBean dao = new LivroDAOBean();
	
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
		
		for (Editora e : editoras) {
			itens.add(new SelectItem(e.getId(), e.getDescricao()));			
		}
		return itens;
	}
	
	public List<SelectItem> listarAutores() {
		List<Autor> autores = new ArrayList<Autor>();
		List<SelectItem> itens = new ArrayList<SelectItem>();
		
		Query q = em.createQuery("select a from Autor a");
		autores = q.getResultList();
		
		for (Autor a : autores) {
			itens.add(new SelectItem(a.getId(), a.getNome() + " " + a.getSobrenome()));			
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
	public List<SelectItem> listarIdiomas() {
		List<Idioma> idiomas = new ArrayList<Idioma>();
		List<SelectItem> itens = new ArrayList<SelectItem>();
		
		Query q = em.createQuery("select e from Idioma e");
		idiomas = q.getResultList();
		
		for (Idioma i : idiomas) {			
			itens.add(new SelectItem(i.getId(), i.getDescricao()));
		}
		return itens;
	}
	
	@Override
	public List<SelectItem> listarLivros() {
		List<Livro> livros = new ArrayList<Livro>();
		List<SelectItem> itens = new ArrayList<SelectItem>();
		
		Query q = em.createQuery("select l from Livro l");
		livros = q.getResultList();
		
		for (Livro l : livros) {			
			itens.add(new SelectItem(l.getId(), l.getTitulo()));
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Livro> pesquisarLivroPorPalavraChave(String palavraChave) {
		
		List<Livro> livros = new ArrayList<Livro>();
		
		Query q = em.createQuery("select liv from Livro liv where " +
						"liv.titulo like ?1 or liv.sinopse like ?2");
		q.setParameter(1,"%"+palavraChave.toLowerCase()+"%");
		q.setParameter(2,"%"+palavraChave.toLowerCase()+"%");
		q.toString();
		livros = q.getResultList();
		
		return livros;
	}

	@Override
	public List<Livro> pegaUltimosCadastrados() {
		List<Livro> livros = new ArrayList<Livro>();
		Query q = em.createQuery("select l from Livro l order by l.titulo desc");
		q.setMaxResults(8);
		livros = q.getResultList();
		return livros;
//		livros = dao.pegaUltimosCadastrados();
//		return livros;
	}
	
	@Override
	public Livro findById(int id) {
		return dao.findyById(id);
	}
}
