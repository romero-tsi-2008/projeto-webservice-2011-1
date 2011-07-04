package entityBeans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


@Entity
public class Livro implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3228800925440579616L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private int isbn;
	private String titulo;
	@ManyToMany(mappedBy="livros", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Autor> autor;
	private Categoria categoria;
	private Editora editora;
	private int ano;
	@Lob
	private String sinopse;
	private int paginas;
	private Idioma idioma;
	private String edicao;
	private Estante estante;
	@OneToMany(mappedBy="livro",cascade=CascadeType.ALL)
	private List<Comentario> comentarios;
	@OneToMany(mappedBy="livro",cascade=CascadeType.ALL)
	private List<Resenha> resenhas;
	@OneToOne(cascade=CascadeType.ALL)
	private Estoque estoque;
	
	public Livro() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public List<Autor> getAutor() {
		return autor;
	}
	public void setAutor(List<Autor> autor) {
		this.autor = autor;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public Idioma getIdioma() {
		return idioma;
	}
	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	public Estante getEstante() {
		return estante;
	}
	public void setEstante(Estante estante) {
		this.estante = estante;
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public List<Resenha> getResenhas() {
		return resenhas;
	}
	public void setResenhas(List<Resenha> resenhas) {
		this.resenhas = resenhas;
	}
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	
	public int hashCode() {
		int result = 1;
		result = 31 * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Livro other = (Livro) obj;

		return ((id == null && other.id == null) || (id != null && id.equals(other.id)));
	}
}
