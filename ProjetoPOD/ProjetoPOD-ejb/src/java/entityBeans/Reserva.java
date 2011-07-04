/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entityBeans;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserva implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	public Reserva() {}
	
	private Livro livro;
	@ManyToOne
	private Usuario usuario;
	private StatusLivro status;
	@Temporal(TemporalType.DATE)
	private Calendar data_solicitacao;
	@Temporal(TemporalType.DATE)
	private Calendar expiracao_solicitacao;
	@Temporal(TemporalType.DATE)
	private Calendar data_locacao;
	@Temporal(TemporalType.DATE)
	private Calendar data_devolucao;
	
	
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public StatusLivro getStatus() {
		return status;
	}
	public void setStatus(StatusLivro status) {
		this.status = status;
	}
	public Calendar getData_solicitacao() {
		return data_solicitacao;
	}
	public void setData_solicitacao(Calendar data_solicitacao) {
		this.data_solicitacao = data_solicitacao;
	}
	public Calendar getExpiracao_solicitacao() {
		return expiracao_solicitacao;
	}
	public void setExpiracao_solicitacao(Calendar expiracao_solicitacao) {
		this.expiracao_solicitacao = expiracao_solicitacao;
	}
	public Calendar getData_locacao() {
		return data_locacao;
	}
	public void setData_locacao(Calendar data_locacao) {
		this.data_locacao = data_locacao;
	}
	public Calendar getData_devolucao() {
		return data_devolucao;
	}
	public void setData_devolucao(Calendar data_devolucao) {
		this.data_devolucao = data_devolucao;
	}
}