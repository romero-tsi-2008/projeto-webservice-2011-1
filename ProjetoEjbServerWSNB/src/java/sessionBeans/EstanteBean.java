package sessionBeans;

import interfacesRemotas.EstanteRemote;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entityBeans.Editora;
import entityBeans.Estante;

@Stateless(mappedName="EstanteBean")
public class EstanteBean implements EstanteRemote {
	@PersistenceContext(unitName="meuPersistenceContext") EntityManager em;

	private Estante estante;
	
	public EstanteBean() {}

	public Estante getEstante() {
		return estante;
	}

	public void setEstante(Estante estante) {
		this.estante = estante;
	}
	
	@Override
	public boolean cadastrar(Estante estante) {
		try {
			em.persist(estante);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
