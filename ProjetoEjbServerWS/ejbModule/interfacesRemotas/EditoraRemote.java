package interfacesRemotas;

import java.util.List;

import javax.ejb.Remote;
import javax.faces.model.SelectItem;

import entityBeans.Editora;


@Remote
public interface EditoraRemote {
	public String cadastrar(Editora editora);
}
