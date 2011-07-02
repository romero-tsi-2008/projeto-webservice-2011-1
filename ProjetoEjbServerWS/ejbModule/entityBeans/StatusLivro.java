package entityBeans;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class StatusLivro implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6818498708002680965L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	
	public StatusLivro() {}
	
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

		StatusLivro other = (StatusLivro) obj;

		return ((id == null && other.id == null) || (id != null && id.equals(other.id)));
	}
}
