package sessionBeans;

import interfacesRemotas.IdiomaRemote;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sessionDaos.GenericDAOBean;
import entityBeans.Idioma;

@Stateless(mappedName="IdiomaBean")
public class IdiomaBean implements IdiomaRemote {
	@PersistenceContext(unitName="meuPersistenceContext") EntityManager em;

	GenericDAOBean<Idioma> dao;

	List<Idioma> idiomas = dao.allEntities("Idioma");
	
	private Idioma idioma;

	public IdiomaBean() {}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	@Override
	public boolean cadastrar(Idioma idioma) {
		try {
			em.persist(idioma);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Idioma> autocompletar(Object sugestao) {
		String pref = (String) sugestao;
		System.out.println(pref);
		List<Idioma> resultado = new ArrayList<Idioma>();
		System.out.println(idiomas.size());
		Iterator<Idioma> it = idiomas.iterator();
		while(it.hasNext()) {
			Idioma elem = it.next();
			if ((elem.getDescricao() != null && elem.getDescricao().toLowerCase().indexOf(pref.toLowerCase()) == 0) || "".equals(pref)) {
				resultado.add(elem);
			}
		}
		return resultado;
	}
}
