package util;

import javax.xml.ws.Endpoint;

public class PublicaServico {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LoginWSBean servicoLogin = new LoginWSBean();
		Endpoint ep = Endpoint.publish("http://localhost:8080/servicologin", servicoLogin);
		
	}

}
