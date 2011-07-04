package util;

public class EntityStore {
	SimpleEntityFactory factory;
	
	public EntityStore(SimpleEntityFactory factory) {
		this.factory = factory;
	}
	
	public ObjectComboboxIF gerarEntity(String tipo) {
		ObjectComboboxIF obj;
		
		obj = factory.createEntity(tipo);
		
		return obj;
	}
}
