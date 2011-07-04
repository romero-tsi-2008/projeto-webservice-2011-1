package interfacesRemotas;

import java.util.List;

import javax.ejb.Remote;

import entityBeans.Categoria;


@Remote
public interface CategoriaRemote {
	public boolean cadastrar(Categoria categoria);
	public List<Categoria> autocompletar(Object sugestao);
}
