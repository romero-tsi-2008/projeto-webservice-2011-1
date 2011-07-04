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
	public List<Livro> pesquisarLivroPorPalavraChave(String palavraChave);
	public List<SelectItem> listarCategorias();
	public List<SelectItem> listarEditoras();
	public List<SelectItem> listarEstantes();
	public List<SelectItem> listarAutores();
	public List<SelectItem> listarIdiomas();
	public List<SelectItem> listarLivros();
	public List<Livro> pegaUltimosCadastrados();
	public Livro findById(int id);
}
