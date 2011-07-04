package entityBeans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Estado implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3633354631511343168L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	@OneToMany(mappedBy="estado")
	private List<Cidade> cidades;
	
	public Estado() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Cidade> getCidades() {
		return cidades;
	}
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
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

		Estado other = (Estado) obj;

		return ((id == null && other.id == null) || (id != null && id.equals(other.id)));
	}
}
