package interfacesRemotas;

import javax.ejb.Remote;
import javax.jms.JMSException;

import entityBeans.Usuario;

@Remote
public interface UsuarioRemote {
	public boolean cadastrarUsuario(Usuario u);
	public boolean removerUsuario(int id);
	public Usuario pesquisarUsuario(int id);
	public Usuario fazerLogin(String email, String senha);
	public boolean fazerLogout(Usuario u);
	public void enviarEmail() throws JMSException;
}
