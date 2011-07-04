package interfacesRemotas;

import javax.jws.WebService;

import entityBeans.Usuario;

@WebService
public interface LoginWSRemote {
	
	public Usuario verificaSeUsuarioExiste(String email, String senha);
}
