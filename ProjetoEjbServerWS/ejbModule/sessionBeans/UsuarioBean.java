package sessionBeans;

import interfacesRemotas.UsuarioRemote;

import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
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
	
	@Resource(mappedName="jms/Queue")
    private Queue queue;
    @Resource(mappedName="jms/email")
    private ConnectionFactory cf;

	
	public Usuario fazerLogin(String email, String senha) {
		try {
			usuario = dao.verificaSeUsuarioExiste(email, senha, em);
			System.out.println("ESTA LOGADO: "+usuario.isLogado());
			if (usuario != null) {
				usuario.setLogado(true);
			}
			return usuario;		
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
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

	@Override
  public void enviarEmail() throws JMSException {

        Connection con = cf.createConnection();

        Session session = con.createSession(true, 0);

        MessageProducer mp = session.createProducer(queue);

        TextMessage msg = session.createTextMessage();

        msg.setText("MENSAGENZONA BOLADA MDB!!!");
        System.out.println("MENSAGENZONA BOLADA MDB!!!");
        mp.send(msg);

        mp.close();
        session.close();
        con.close();
    }
}
