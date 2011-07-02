package sessionBeans;

import java.util.List;

import interfacesRemotas.EditoraRemote;

import javax.ejb.Stateless;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entityBeans.Editora;

@Stateless(mappedName="EditoraBean")
public class EditoraBean implements EditoraRemote {
	@PersistenceContext(unitName="meuPersistenceContext") EntityManager em;
	
	Editora editora;

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	
	public String cadastrar(Editora editora) {
		try {
			em.persist(editora);
		}
		catch(Exception e) {
			e.printStackTrace();
			return "false";
		}
		return "true";
	}
}
