package managedBeans;

import interfacesRemotas.GenericDAORemote;
import interfacesRemotas.LivroRemote;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.model.SelectItem;

import util.Message;
import entityBeans.Autor;
import entityBeans.Categoria;
import entityBeans.Comentario;
import entityBeans.Editora;
import entityBeans.Estante;
import entityBeans.Estoque;
import entityBeans.Idioma;
import entityBeans.Livro;
import entityBeans.Resenha;

public class LivroMBean {
	private Livro livro = new Livro();
	String tipoEntity;
	
	@EJB(lookup="LivroBean")
	private LivroRemote livroBean;
	@EJB(lookup="GenericDAOBean")
	private GenericDAORemote<Livro> genericDaoBean;
//	@EJB(lookup="ComboboxStoreBean")
//	private ComboboxStoreRemote comboboxBean;
	
	private List<Livro> all = new ArrayList<Livro>();
	private List<Livro> livrosResult = new ArrayList<Livro>();
	private boolean saving = true;
	private String palavrasChave;
	
	public LivroMBean() {
		livro.setAutor(new ArrayList<Autor>());
		livro.setCategoria(new Categoria());
		livro.setComentarios(new ArrayList<Comentario>());
		livro.setEditora(new Editora());
		livro.setEstante(new Estante());
		livro.setEstoque(new Estoque());
		livro.setIdioma(new Idioma());
		livro.setResenhas(new ArrayList<Resenha>());
		livro.getEstoque().setVolumes_disponiveis(livro.getEstoque().getVolumes_totais() - livro.getEstoque().getVolumes_emprestados());
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public String getTipoEntity() {
		return tipoEntity;
	}
	
	public String getPalavrasChave() {
		return palavrasChave;
	}

	public void setPalavrasChave(String palavrasChave) {
		this.palavrasChave = palavrasChave;
	}

	public void setTipoEntity(String tipoEntity) {
		this.tipoEntity = tipoEntity;
	}
	
	public List<Livro> getLivrosResult() {
		return livrosResult;
	}

	public void setLivrosResult(List<Livro> livrosResult) {
		this.livrosResult = livrosResult;
	}

	public List<SelectItem> getListaDeCategorias() {
		try {
			return livroBean.listarCategorias();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<SelectItem> getListaDeAutores() {
		try {
			return livroBean.listarAutores();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<SelectItem> getListaDeEditoras() {
		try {
			return livroBean.listarEditoras();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<SelectItem> getListaDeEstantes() {
		try {
			return livroBean.listarEstantes();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<SelectItem> getListaDeIdiomas() {
		try {
			return livroBean.listarIdiomas();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<SelectItem> getListaDeLivros() {
		try {
			return livroBean.listarLivros();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<SelectItem> getListarEntity() {
		try {
//			return comboboxBean.gerarCombobox(tipoEntity);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Livro> getAll(){
		try{
			this.all = genericDaoBean.allEntities("Livro");
			return this.all;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return this.all;
	}
	
	public void setAll(List<Livro> all) {
		this.all = all;
	}
	
	public String cadastrar() {
		try  {
			if(saving){
				genericDaoBean.salvar(livro);
				Message.addMessage("listaLivro", "Livro cadastrado com sucesso!");
			}else{
				genericDaoBean.merge(livro);
				saving = true;
			}
		}
		catch (Exception e) {
			Message.addMessage("listaLivro", "Erro: "+e.getMessage());
		}
		return "listarLivros";
	}
	
	public String remover(){
		genericDaoBean.remover(livro);
		return "listarLivros";
	}
	
	public String editar(){
		saving = false;
		return "cadastroLivro";
	}
	
	public String pesquisarPorPalavraChave(){
		livrosResult = livroBean.pesquisarLivroPorPalavraChave(this.palavrasChave);
		System.out.println("\n\n\n3333333333333333333333333333333\n"+livrosResult.toString());
		return "";
	}
	
	public List<Livro> getPegaUltimosCadastrados() {
		return livroBean.pegaUltimosCadastrados();
	}

	public Livro getFindById() {
		return livroBean.findById(livro.getId());
	}
}