package entityBeans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Estoque implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToOne(mappedBy="estoque")
	private Livro livro;
	private int volumes_totais;
	private int volumes_disponiveis;
	private int volumes_emprestados;
	
	public Estoque() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public int getVolumes_totais() {
		return volumes_totais;
	}
	public void setVolumes_totais(int volumes_totais) {
		this.volumes_totais = volumes_totais;
	}
	public int getVolumes_disponiveis() {
		return volumes_disponiveis;
	}
	public void setVolumes_disponiveis(int volumes_disponiveis) {
		this.volumes_disponiveis = volumes_disponiveis;
	}
	public int getVolumes_emprestados() {
		return volumes_emprestados;
	}
	public void setVolumes_emprestados(int volumes_emprestados) {
		this.volumes_emprestados = volumes_emprestados;
	}
}
