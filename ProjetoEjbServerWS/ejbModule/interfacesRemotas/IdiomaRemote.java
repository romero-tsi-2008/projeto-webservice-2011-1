package interfacesRemotas;

import java.util.List;

import javax.ejb.Remote;

import entityBeans.Idioma;

@Remote
public interface IdiomaRemote {
	public boolean cadastrar(Idioma idioma);
	public List<Idioma> autocompletar(Object sugestao);	
}
