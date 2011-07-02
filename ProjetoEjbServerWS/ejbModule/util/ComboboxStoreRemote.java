package util;

import java.util.List;

import javax.ejb.Remote;
import javax.faces.model.SelectItem;

@Remote
public interface ComboboxStoreRemote {
	public List<SelectItem> gerarCombobox(String tipo);
}
