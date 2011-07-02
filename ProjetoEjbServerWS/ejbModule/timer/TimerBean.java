package timer;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Stateless(mappedName="bean/timer")
@LocalBean
public class TimerBean implements TimerRemote{
	
//	@Resource TimerService timerService;
//
//    public void runTimer(String msg){
//        Calendar time = Calendar.getInstance();
//        Date date = time.getTime();
//        timerService.createTimer(date, 3000,msg);
//    }
//
//    @Timeout
//    public void runAutomaticTimer(Timer timer){
//        String mensagem = (String)timer.getInfo();
//
//        System.out.println(mensagem + " - ok! Deu certo!");
//    }
	
	@Resource
	TimerService timerService;
	
	Calendar time;

	@Override
	public void runTimer(String emailUsuario) {
		System.out.println("\n\n *****EXECUTA ACAO******\n\n");
		time = Calendar.getInstance();
		Date date = time.getTime();
		timerService.createTimer(date, 120000, emailUsuario);
	}

	@Timeout
	public void runAutomaticTimer(Timer timer) throws Exception{
		String emailUsuario = (String) timer.getInfo();
		System.out.println("\n\n\n RECEBI O EMAIL: "+emailUsuario+"\n\n\n");
//		SendNews sn = new SendNews();
//		SendNews.enviaEmailTeste(emailUsuario);
		SendMail sendzao = new SendMail();
		sendzao.sendMail("romero.mfm@gmail.com", "romero.mfm@gmail.com", "Teste boladão timerService", "TRÁÁÁÁÁÁÁÁÁÁ");
	}

}
