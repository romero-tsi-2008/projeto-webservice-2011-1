package entityBeans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Estoque implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3129396361727433048L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@OneToOne(mappedBy="estoque")
	private Livro livro;
	private int volumes_totais;
	private int volumes_disponiveis;
	private int volumes_emprestados;
	
	public Estoque() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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

		Estoque other = (Estoque) obj;

		return ((id == null && other.id == null) || (id != null && id.equals(other.id)));
	}
}
