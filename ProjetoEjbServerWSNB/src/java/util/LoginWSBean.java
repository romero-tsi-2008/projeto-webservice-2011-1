package util;

import interfacesRemotas.LoginWSRemote;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entityBeans.Usuario;

@Stateless
@WebService(endpointInterface="interfacesRemotas.LoginWSRemote")
public class LoginWSBean implements LoginWSRemote{
	
	public LoginWSBean(){}
	
	@PersistenceContext(unitName="meuPersistenceContext")
	EntityManager em;

	@Override
	public Usuario verificaSeUsuarioExiste(String email, String senha) {
		Query q = em.createQuery("select u from Usuario u where u.email = :email and u.senha = :senha");

		q.setParameter("email", email);
		q.setParameter("senha", senha);

		return (Usuario) q.getSingleResult();
	}

}