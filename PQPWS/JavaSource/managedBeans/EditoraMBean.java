package managedBeans;

import interfacesRemotas.EditoraRemote;
import interfacesRemotas.GenericDAORemote;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import util.Message;
import entityBeans.Autor;
import entityBeans.Categoria;
import entityBeans.Editora;

public class EditoraMBean {
	private Editora editora = new Editora();

	@EJB(lookup="EditoraBean")
	private EditoraRemote bean;
	
	@EJB(lookup="GenericDAOBean")
	private GenericDAORemote<Editora> genericDaoBean;
	private List<Editora> all = new ArrayList<Editora>();
	private boolean saving = true;

	public EditoraMBean() {}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora categoria) {
		this.editora = categoria;
	}

	public String cadastrar() {
		try  {
			if(saving){
				genericDaoBean.salvar(editora);
				Message.addMessage("listaEditoras", "Editora cadastrada com sucesso!");
			}else{
				genericDaoBean.merge(editora);
				saving = true;
			}
		}
		catch (Exception e) {
			Message.addMessage("listaEditoras", "Erro: "+e.getMessage());
		}
		return "listarEditoras";
	}
	
	public String remover(){
		genericDaoBean.remover(editora);
		return "listarEditoras";
	}
	
	public String editar(){
		saving = false;
		return "cadastroEditora";
	}
	
	public void setAll(List<Editora> all) {
		this.all = all;
	}
	
	public List<Editora> getAll(){
		try{
			this.all = genericDaoBean.allEntities("Editora");
			return this.all;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return this.all;
	}
}
