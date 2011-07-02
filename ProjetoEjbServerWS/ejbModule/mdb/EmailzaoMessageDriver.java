//package mdb;
//
//import javax.ejb.MessageDriven;
//import javax.jms.Message;
//import javax.jms.TextMessage;
//
//import timer.SendMail;
//
//
//@MessageDriven(mappedName="jms/Queue")
//public class EmailzaoMessageDriver {
//	
//	public EmailzaoMessageDriver() {
//		super();
//	}
//
//	public void onMessage(Message message) {
//		try {
//			SendMail mail = new SendMail();
//			mail.sendMail("romero.mfm@gmail.com", "romero.mfm@gmail.com", "assunto traaaa", "conteudo traaaaa");
//			System.out.println(((TextMessage) message).getText());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//}
