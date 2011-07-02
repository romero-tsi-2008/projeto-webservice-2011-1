package entityBeans;

import java.io.Serializable;

import javax.persistence.*;

public class Mensagem implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String assunto;
	@Lob
	private String conteudo;
	private String nome_remetente;
	private String email_remetente;
	
	public Mensagem() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public String getNome_remetente() {
		return nome_remetente;
	}
	public void setNome_remetente(String nome_remetente) {
		this.nome_remetente = nome_remetente;
	}
	public String getEmail_remetente() {
		return email_remetente;
	}
	public void setEmail_remetente(String email_remetente) {
		this.email_remetente = email_remetente;
	}
	
}
