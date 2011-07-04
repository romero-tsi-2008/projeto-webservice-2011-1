package sessionDaos;

import javax.persistence.Query;

import entityBeans.Usuario;

public class UsuarioDAOBean extends GenericDAOBean {
	
	public Usuario verificaSeUsuarioExiste(Usuario u) {
		System.out.println(u.getEmail());
		System.out.println("select u from Usuario u where u.email like '"+u.getEmail()+"' and u.senha like '"+u.getSenha()+"'");
		Query q = em.createQuery("select u from Usuario u where u.email like '"+u.getEmail()+"' and u.senha like '"+u.getSenha()+"'");
		Usuario resultado = (Usuario) q.getSingleResult(); 
//		q.setParameter("email", u.getEmail());
//		q.setParameter("senha", u.getSenha());
		return resultado;
	}
}
