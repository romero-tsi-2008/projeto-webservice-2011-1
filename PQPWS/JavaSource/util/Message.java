package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;



public class Message {
	
	
	public static void addMessage(String idForm, String mensagem){
		FacesContext.getCurrentInstance().addMessage(idForm, 
				new FacesMessage(mensagem));
	}
	
}
