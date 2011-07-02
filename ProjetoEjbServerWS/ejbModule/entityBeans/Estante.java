package entityBeans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estante implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5900478245543974335L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private int numero;
	private String descricao;
	
	public Estante() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
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

		Estante other = (Estante) obj;

		return ((id == null && other.id == null) || (id != null && id.equals(other.id)));
	}
}
