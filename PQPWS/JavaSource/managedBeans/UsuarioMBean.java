package managedBeans;


import interfacesRemotas.GenericDAORemote;
import interfacesRemotas.UsuarioRemote;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.jms.JMSException;

import util.ClienteLogUsuarioMDB;
import util.Message;
import util.SendEmailTimer;
import entityBeans.Usuario;

public class UsuarioMBean {
	Usuario usuario = new Usuario();
	String senha1, senha2 = "";
	private boolean saving = true;
	
	private String senhaLogin;
	private String emailLogin;
	
	@EJB(lookup="UsuarioBean")
	private UsuarioRemote usuarioBean;
	
	@EJB(lookup="GenericDAOBean")
	private GenericDAORemote<Usuario> genericDaoBean;
	
	List<Usuario> all = new ArrayList<Usuario>();

	public Usuario getUsuario() {
		return usuario;
	}
	
	public String getSenha1() {
		return senha1;
	}

	public void setSenha1(String senha1) {
		this.senha1 = senha1;
	}

	public String getSenha2() {
		return senha2;
	}

	public void setSenha2(String senha2) {
		this.senha2 = senha2;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void setAll(List<Usuario> all) {
		this.all = all;
	}

	public String getSenhaLogin() {
		return senhaLogin;
	}

	public void setSenhaLogin(String senhaLogin) {
		this.senhaLogin = senhaLogin;
	}
	
	public String getEmailLogin() {
		return emailLogin;
	}

	public void setEmailLogin(String emailLogin) {
		this.emailLogin = emailLogin;
	}

	public UsuarioRemote getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioRemote usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public List<Usuario> getAll(){
		try{
			this.all = genericDaoBean.allEntities("Usuario");
			return this.all;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return this.all;
	}
	
	public String fazerLogin() throws JMSException {
		this.usuario = usuarioBean.fazerLogin(emailLogin, senhaLogin);
		System.out.println(usuario.getTipo());
		
//		usando MDB 
//		usuarioBean.enviarEmail();
		
//		implementação do TimerService
		SendEmailTimer.enviaNovidades(usuario.getEmail());
		
		
		if(usuario!=null){
			
			try{
//				ClienteLogUsuarioMDB logMdb = new ClienteLogUsuarioMDB();
//				logMdb.gravarLog(usuario);
				if(usuario.getTipo().equals("normal")){
					return "normal";
				}
				else if(usuario.getTipo().equals("admin")){
					return "admin";
				}
				
			}catch(Exception e){}
			
		}
		
		return "erro";
	}
	
	public String fazerLogout() {
		System.out.println("\n\n\n\nDESLOGANDO\n\n\n\n");
		this.usuario = null;
		return "normal";
	}
	
	public String cadastrar() {
		try  {
			if (senha1.equals(senha2)) {
				usuario.setTipo("normal");
				usuario.setSenha(senha1);
			}
			else {
				Message.addMessage("form_cadastro_usuario", "Senhas não conferem!");
				return "cadastroUsuario";
			}
			
			if(saving){
				genericDaoBean.salvar(usuario);
				Message.addMessage("listaUsuarios", "Usuário cadastrado com sucesso!");
				
				//implementação do TimerService
				SendEmailTimer.enviaNovidades(usuario.getEmail());
			}else{
				genericDaoBean.merge(usuario);
				saving = true;
			}
		}
		catch (Exception e) {
			Message.addMessage("listaUsuarios", "Erro: "+e.getMessage());
		}
		return "listarUsuarios";
	}
	
	public String remover(){
		genericDaoBean.remover(usuario);
		return "listarUsuarios";
	}
	
	public String editar(){
		saving = false;
		return "cadastroUsuario";
	}
	
}
