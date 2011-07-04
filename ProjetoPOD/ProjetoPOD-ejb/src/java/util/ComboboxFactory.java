package util;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class ComboboxFactory {
	SimpleEntityFactory entityFactory = new SimpleEntityFactory();
	EntityStore entityStore = new EntityStore(entityFactory);
	
	List<SelectItem> comboboxFinal;
	
	@PersistenceContext(unitName="meuPersistenceContext") EntityManager em;
	
	public ComboboxFactory(String tipo) {
		List<ObjectComboboxIF> objetos = new ArrayList<ObjectComboboxIF>();
		List<SelectItem> itens = new ArrayList<SelectItem>();
		
		Query q = em.createQuery("select c from :tipo c");
		q.setParameter("tipo", tipo);
		objetos = (ArrayList<ObjectComboboxIF>) q.getResultList();
		
		for (ObjectComboboxIF o : objetos) {			
			itens.add(new SelectItem(o.getId(), o.getDescricao()));			
		}
		
		comboboxFinal = itens;
	}
}
