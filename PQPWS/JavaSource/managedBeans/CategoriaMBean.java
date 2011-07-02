package managedBeans;

import interfacesRemotas.CategoriaRemote;
import interfacesRemotas.GenericDAORemote;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.naming.InitialContext;

import util.Message;
import entityBeans.Categoria;


public class CategoriaMBean  {
	private Categoria categoria = new Categoria();
	private String sugestao = "";

	@EJB(lookup="CategoriaBean")
	private CategoriaRemote categoriaBean;
	
	@EJB(lookup="GenericDAOBean")
	private GenericDAORemote<Categoria> genericDaoBean;
	
	private List<Categoria> all = new ArrayList<Categoria>();
	
	private boolean saving = true;
	
	public CategoriaMBean() {
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String getSugestao() {
		return sugestao;
	}

	public void setSugestao(String sugestao) {
		this.sugestao = sugestao;
	}

	public String cadastrar() {
		try  {
			if(saving){
				genericDaoBean.salvar(categoria);
				Message.addMessage("cadastro_categoria", "Categoria cadastrada com sucesso!");
			}else{
				genericDaoBean.merge(categoria);
				saving = true;
			}
			return "listarCategorias";
		}
		catch (Exception e) {
			Message.addMessage("cadastro_categoria", "Erro: "+e.getMessage());
			return "";
		}
	}
	
	public void setAll(List<Categoria> all) {
		this.all = all;
	}

//	@SuppressWarnings("unchecked")
	public List<Categoria> getAll(){
		try{
			this.all = genericDaoBean.allEntities("Categoria");
			return this.all;
		}
		catch(Exception e){}
		return this.all;
	}
	
	public String remover(){
		genericDaoBean.remover(categoria);
		return "listarCategorias";
	}
	
	public String editar(){
		saving = false;
		return "cadastroCategoria";
	}
	
	public List<Categoria> autocompletar() {
		return categoriaBean.autocompletar(sugestao);
	}

}
