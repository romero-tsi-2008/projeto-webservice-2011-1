package util;


import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import entityBeans.Usuario;


public class ClienteLogUsuarioMDB {
	
//	@Resource(mappedName="jms/QueueFactory")
//	ConnectionFactory connectionFactory;
//	
//	@Resource(mappedName="jmsLogUsuario")
//	Queue queue;
//	
//	public void gravarLog(Usuario usuario) throws Exception{
//		Connection connection = connectionFactory.createConnection();
//		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//		MessageProducer mp = session.createProducer(queue);
//		
//		ObjectMessage message = session.createObjectMessage();
//		
//		message.setObject(usuario);
//		
////		TextMessage texto = session.createTextMessage();
////		texto.setText("Opa!");
//		
//		mp.send(message);
//		
//		mp.close();
//		session.close();
//		connection.close();
//	}
	
}
