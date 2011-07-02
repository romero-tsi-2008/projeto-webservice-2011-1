package managedBeans;

import interfacesRemotas.GenericDAORemote;
import interfacesRemotas.IdiomaRemote;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import util.Message;
import entityBeans.Idioma;

public class IdiomaMBean {
	private Idioma idioma = new Idioma();
	private String sugestao = "";

	@EJB(lookup="IdiomaBean")
	private IdiomaRemote idiomaBean;
	
	@EJB(lookup="GenericDAOBean")
	private GenericDAORemote<Idioma> genericDaoBean;
	
	private List<Idioma> all = new ArrayList<Idioma>();
	
	private boolean saving = true;
	
	public IdiomaMBean() {}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
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
				genericDaoBean.salvar(idioma);
				Message.addMessage("cadastro_idioma", "Idioma cadastrada com sucesso!");
			}else{
				genericDaoBean.merge(idioma);
				saving = true;
			}
			return "listarIdiomas";
		}
		catch (Exception e) {
			Message.addMessage("cadastro_idioma", "Erro: "+e.getMessage());
			return "";
		}
	}
	
	public void setAll(List<Idioma> all) {
		this.all = all;
	}

//	@SuppressWarnings("unchecked")
	public List<Idioma> getAll(){
		try{
			this.all = genericDaoBean.allEntities("Idioma");
			return this.all;
		}
		catch(Exception e){}
		return this.all;
	}
	
	public String remover(){
		genericDaoBean.remover(idioma);
		return "listarIdiomas";
	}
	
	public String editar(){
		saving = false;
		return "cadastroIdioma";
	}
	
	public List<Idioma> autocompletar() {
		return idiomaBean.autocompletar(sugestao);
	}

}
