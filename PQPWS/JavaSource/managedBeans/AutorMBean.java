package managedBeans;

import interfacesRemotas.GenericDAORemote;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import util.Message;
import entityBeans.Autor;
import entityBeans.Livro;


public class AutorMBean {
	Autor autor = new Autor();
	
	@EJB(lookup="GenericDAOBean")
	private GenericDAORemote<Autor> genericDaoBean;
	
	private boolean saving = true;
	private List<Autor> all = new ArrayList<Autor>();
	
	public AutorMBean() {
		autor.setLivros(new ArrayList<Livro>());
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public String cadastrar() {
		try  {
			if(saving){
				genericDaoBean.salvar(autor);
				Message.addMessage("listaAutores", "Autor cadastrado com sucesso!");
			}else{
				genericDaoBean.merge(autor);
				saving = true;
			}
		}
		catch (Exception e) {
			Message.addMessage("listaAutores", "Erro: "+e.getMessage());
		}
		return "listarAutores";
	}
	
	public String remover(){
		genericDaoBean.remover(autor);
		return "listarAutores";
	}
	
	public String editar(){
		saving = false;
		return "cadastroAutor";
	}
	
	public void setAll(List<Autor> all) {
		this.all = all;
	}

	public List<Autor> getAll(){
		try{
			this.all = genericDaoBean.allEntities("Autor");
			return this.all;
		}
		catch(Exception e){}
		return this.all;
	}
}
