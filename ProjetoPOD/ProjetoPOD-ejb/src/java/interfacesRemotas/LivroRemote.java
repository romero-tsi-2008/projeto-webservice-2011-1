package interfacesRemotas;

import java.util.List;

import javax.ejb.Remote;
import javax.faces.model.SelectItem;

import entityBeans.Livro;

@Remote
public interface LivroRemote {
	public boolean cadastrarLivro(Livro livro);
	public boolean removerLivro(int id);
	public Livro pesquisarLivro(int id);
	public List<SelectItem> listarCategorias();
	public List<SelectItem> listarEditoras();
	public List<SelectItem> listarEstantes();
}
