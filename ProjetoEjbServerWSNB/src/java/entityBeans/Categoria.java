package entityBeans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import util.ObjectComboboxIF;

@Entity
public class Categoria implements Serializable, ObjectComboboxIF {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5366455145024937931L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	
	public Categoria() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String desccricao) {
		this.descricao = desccricao;
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

		Categoria other = (Categoria) obj;

		return ((id == null && other.id == null) || (id != null && id.equals(other.id)));
	}
	
}
