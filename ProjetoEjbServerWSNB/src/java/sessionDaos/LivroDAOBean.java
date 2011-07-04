package sessionDaos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import entityBeans.Livro;

@Stateless(mappedName="LivroDAOBean")
public class LivroDAOBean extends GenericDAOBean<Livro> {

	public List<Livro> pegaUltimosCadastrados() {
		Query q = em.createQuery("select l from Livro l order by l.titulo desc");
		q.setMaxResults(8);
		return q.getResultList();
	}
	
	public Livro findyById(int id) {
		Query q = em.createQuery("select l from Livro l where l.id = "+id);
		return (Livro) q.getSingleResult();
	}
}
