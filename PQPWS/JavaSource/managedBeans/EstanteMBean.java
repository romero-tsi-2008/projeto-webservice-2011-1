package managedBeans;

import interfacesRemotas.EstanteRemote;
import interfacesRemotas.GenericDAORemote;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import util.Message;

import entityBeans.Estante;

public class EstanteMBean {
	Estante estante = new Estante();
	
	@EJB(lookup="EstanteBean")
	private EstanteRemote estanteBean;
	
	@EJB(lookup="GenericDAOBean")
	private GenericDAORemote<Estante> genericDaoBean;
	private boolean saving = true;
	
	List<Estante> all = new ArrayList<Estante>();
	
	public EstanteMBean() {}

	public Estante getEstante() {
		return estante;
	}

	public void setEstante(Estante estante) {
		this.estante = estante;
	}
	
	public void setAll(List<Estante> all) {
		this.all = all;
	}

	public List<Estante> getAll(){
		try{
			this.all = genericDaoBean.allEntities("Estante");
			return this.all;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return this.all;
	}

	public String cadastrar() {
		try  {
			if(saving){
				genericDaoBean.salvar(estante);
				Message.addMessage("listaEstante", "Estante cadastrada com sucesso!");
			}else{
				genericDaoBean.merge(estante);
				saving = true;
			}
		}
		catch (Exception e) {
			Message.addMessage("listaEstante", "Erro: "+e.getMessage());
		}
		return "listarEstantes";
	}
	
	public String remover(){
		genericDaoBean.remover(estante);
		return "listarEstantes";
	}
	
	public String editar(){
		saving = false;
		return "cadastroEstante";
	}
	
	
}
