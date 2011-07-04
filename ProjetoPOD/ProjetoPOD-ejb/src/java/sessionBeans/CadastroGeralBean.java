package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import util.EntityStore;
import util.SimpleEntityFactory;

@Stateless(mappedName="cadastroGeral")
public class CadastroGeralBean {
	@PersistenceContext(unitName="meuPersistenceContext") EntityManager em;
	SimpleEntityFactory factory = new SimpleEntityFactory();
	Object objeto;
	
	public CadastroGeralBean(String name) {
		EntityStore es = new EntityStore(factory);
		objeto = es.gerarEntity(name);		
	}
	
	public boolean cadastrarObjeto() {
		try {
			em.persist(objeto);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			em.close();
		}
		return true;
	}
}
