package interfacesRemotas;

import javax.ejb.Remote;

import entityBeans.Usuario;

@Remote
public interface UsuarioRemote {
	public boolean cadastrarUsuario(Usuario u);
	public boolean removerUsuario(int id);
	public Usuario pesquisarUsuario(int id);
	public String fazerLogin(Usuario u);
	public boolean fazerLogout(Usuario u);
}
