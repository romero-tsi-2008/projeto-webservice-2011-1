package entityBeans;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Idioma implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;	
	private String descricao;
	
	public Idioma() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
