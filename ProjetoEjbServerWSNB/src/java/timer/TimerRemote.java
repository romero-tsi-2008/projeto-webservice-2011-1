package timer;

import javax.ejb.Remote;

import entityBeans.Usuario;

@Remote
public interface TimerRemote {
	public void runTimer(String emailUsuario);
}
