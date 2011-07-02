package util;

import javax.naming.InitialContext;

import timer.TimerRemote;



public class SendEmailTimer {
	
	public static void enviaNovidades(String email){
		try {

	        InitialContext ctx = new InitialContext();

	        TimerRemote timer = (TimerRemote) ctx.lookup("bean/timer");

	        timer.runTimer(email);
	                    
	        System.out.println("FINISH HIM");
	    } 
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public static void main(String[] args){
		enviaNovidades("thishinoda2@gmail.com");
	}
	
}
