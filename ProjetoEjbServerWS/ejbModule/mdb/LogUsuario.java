package mdb;

public class LogUsuario{
	
}

//import java.util.Calendar;
//import java.util.Date;
//
//import javax.annotation.Resource;
//import javax.ejb.ActivationConfigProperty;
//import javax.ejb.MessageDriven;
//import javax.ejb.MessageDrivenContext;
//import javax.ejb.TransactionManagement;
//import javax.ejb.TransactionManagementType;
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.MessageListener;
//import javax.jms.ObjectMessage;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//
//import entityBeans.Usuario;
//
///**
// * Message-Driven Bean implementation class for: LogUsuario
// *
// */
//@MessageDriven(mappedName = "jms/LogUsuarioQueue", activationConfig =  {
//        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
//        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
//    })
//@TransactionManagement(TransactionManagementType.CONTAINER)
//public class LogUsuario implements MessageListener {
//	
//	@Resource
//    private MessageDrivenContext mdc;
//	
//    @PersistenceContext(unitName="meuPersistenceContext")
//    private EntityManager em;
//	
//    /**
//     * Default constructor. 
//     */
//    public LogUsuario() {
//    }
//	
//	/**
//     * @see MessageListener#onMessage(Message)
//     */
//    public void onMessage(Message message) {
//        
//    	System.out.println("\n\n\n\n8888888888888888888888888888888888888888888888\n\n\n\n\n");
//    	
//    	ObjectMessage msg = null;
//    	
//    	try{
//    		if(message instanceof ObjectMessage){
//    			msg = (ObjectMessage) message;
//    			Usuario u = (Usuario) msg.getObject();
//    			registrarLog(u);
//    		}
//        }
//        catch(JMSException e){
//        	mdc.setRollbackOnly();
//        	e.printStackTrace();
//        }
//        catch(Exception e){
//        	e.printStackTrace();
//        }
//        
//    }
//    
//    public void registrarLog(Usuario u){
//    	Calendar c = Calendar.getInstance();
//		Date data = c.getTime();
//    	
//		if(em == null)
//			System.out.println("\n\n\n########## ENTITYMANAGER ESTÁ NULO ###############");
//		
//    	Query q = em.createQuery("insert into log_usuario (data, usuario_id) values (:data, :usuario)");
//    	q.setParameter("data", data);
//    	q.setParameter("usuario", u.getId());
//    	int result = q.executeUpdate();
//    	if(result == 1)
//    		System.out.println("\n\n\n *** LOG GRAVADO COM SUCESSO PARA O USUÁRIO_ID = "+ u.getId() +"*** \n\n\n");
//    }
//
//}
