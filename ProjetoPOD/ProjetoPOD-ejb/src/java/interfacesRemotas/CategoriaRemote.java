package interfacesRemotas;

import javax.ejb.Remote;

import entityBeans.Categoria;


@Remote
public interface CategoriaRemote {
	public boolean cadastrar(Categoria categoria);
}
