package sessionBeans;

import interfacesRemotas.UsuarioRemote;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sessionDaos.UsuarioDAOBean;
import entityBeans.Usuario;

@Stateful(mappedName="UsuarioBean")
public class UsuarioBean implements UsuarioRemote {
	@PersistenceContext(unitName="meuPersistenceContext") 
	EntityManager em;
	
	UsuarioDAOBean dao = new UsuarioDAOBean();
	
	Usuario usuario;
	
	public String fazerLogin(Usuario usuario) {
		System.out.println("antes: "+usuario.toString());
		try {
			usuario = (Usuario) dao.verificaSeUsuarioExiste(usuario);
			if (usuario != null) {
				usuario.setLogado(true);
			}
			System.out.println("depois: "+usuario.toString());
			return usuario.getTipo();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return "erro";
		}
	}
	
	public boolean fazerLogout(Usuario usuario) {
			if (usuario != null) {
				this.usuario = null;
			}
			return true;
	}

	@Override
	public boolean cadastrarUsuario(Usuario u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removerUsuario(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario pesquisarUsuario(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
