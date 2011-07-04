package sessionDaos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import entityBeans.Usuario;

@Stateless(mappedName="UsuarioDAOBean")
public class UsuarioDAOBean extends GenericDAOBean<Usuario> {
	
	public Usuario verificaSeUsuarioExiste(String email, String senha, EntityManager em) {
		Query q = em.createQuery("select u from Usuario u where u.email = :email and u.senha = :senha");
		
		q.setParameter("email", email);
		q.setParameter("senha", senha);
		
		return (Usuario) q.getSingleResult();
	}
}
