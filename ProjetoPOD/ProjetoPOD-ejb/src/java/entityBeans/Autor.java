package entityBeans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

@Entity
public class Autor implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int nome;
	private int sobrenome;
	@Temporal(TemporalType.DATE)
	private Calendar data_nascimento;
	private String nacionalidade;
	@Lob
	private String sobre;
	@ManyToMany
	private List<Livro> livros;
	
	public Autor() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNome() {
		return nome;
	}
	public void setNome(int nome) {
		this.nome = nome;
	}
	public int getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(int sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Calendar getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(Calendar data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getSobre() {
		return sobre;
	}
	public void setSobre(String sobre) {
		this.sobre = sobre;
	}
	public List<Livro> getLivros() {
		return livros;
	}
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
}
