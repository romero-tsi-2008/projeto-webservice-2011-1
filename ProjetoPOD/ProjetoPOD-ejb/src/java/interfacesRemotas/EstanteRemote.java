package interfacesRemotas;

import javax.ejb.Remote;

import entityBeans.Estante;

@Remote
public interface EstanteRemote {
	public boolean cadastrar(Estante estante);
}
