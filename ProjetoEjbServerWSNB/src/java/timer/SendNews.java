package timer;



public class SendNews {
	
//	@PersistenceContext(unitName="meuPersistenceContext")
//	EntityManager em;
	
//	Calendar time;
//	String nome_arquivo;
//	
//	@SuppressWarnings("unchecked")
//	public void carregarNovidades(String email) throws Exception{
//		System.out.println("******Opa! 1111111111111111******");
//		List<Livro> livros = new ArrayList<Livro>();
//		
//		if(em==null)
//			System.out.println("ENTITYMANAGER ESTÁ NULO #################################");
//		
//		Query q = em.createQuery("SELECT liv FROM Livro liv order by liv.id desc limit 10");
//		livros = (ArrayList<Livro>) q.getResultList();
//
//		nome_arquivo = "C:/projetoejb_"+time.getTimeInMillis()+".csv";
//
//		Formatter escrita = new Formatter(new File(nome_arquivo));
//		escrita.format("Titulo; Ed.; Pag; Sinopse; Categoria; Editora;\r\n");
//
//		for(Livro liv: livros){	
//			escrita.format("%s; %s; %s; %s; %s; %s;\r\n", 
//					liv.getTitulo(), liv.getEdicao(), String.valueOf(liv.getPaginas()), 
//					liv.getSinopse(), liv.getCategoria().getDescricao(), liv.getEditora().getDescricao());
//		}
//		escrita.close();
//		
//		System.out.println("******Opa!******");
//		
//		enviaEmail(email);
//	}

//	public void enviaEmail(String emailUsuario){
//		File f = new File(nome_arquivo);
//
//		EmailAttachment attachment = new EmailAttachment();  
//		attachment.setPath(f.getPath()); // Obtem o caminho do arquivo  
//		attachment.setDisposition(EmailAttachment.ATTACHMENT);  
//		attachment.setDescription("Anexo");  
//		attachment.setName(f.getName()); // Obtem o nome do arquivo  
//
//		try {  
//			MultiPartEmail email = new MultiPartEmail();  
//			email.setDebug(true);  
//			email.setHostName("smtp.gmail.com");  
//			email.setAuthentication("thiagopaulino2","xxxxxxx");  
//			email.setSSL(true);  
//			email.addTo(emailUsuario);
//			email.setFrom("thiagopaulino2@gmail.com");
//			email.setSubject("Girombs Library - Chegaram nosvos livros para você!");  
//			email.setMsg("bla bla bla");  
//
//			email.attach(attachment);  
//
//			email.send();
//			System.out.println("****** E-MAIL ENVIADO COM SUCESSO! ******");
//			f.delete();
//		} catch (EmailException e) { 
//			System.out.println("\n\n\n\n\n\n\n########## deu pau! ##########");
//			e.printStackTrace();  
//		} 
//	}
	
	public static void enviaEmailTeste(String emailUsuario){
		System.out.println("\n\n*****ENVIANDO EMAIL PARA "+emailUsuario);
//		SimpleEmail email = new SimpleEmail();  
//
//		try {  
//			email.setDebug(true);  
//			email.setHostName("smtp.gmail.com");  
//			email.setAuthentication("thiagopaulino2","herica0301");  
//			email.setSSL(true);  
//			email.addTo(emailUsuario);
//			email.setFrom("thiagopaulino2@gmail.com");
//			email.setSubject("Enviando email");
//			email.setMsg("Teste de envio de email");
//			email.send();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
//	public static void main(String[] args){
//		enviaEmailTeste("thishinoda2@gmail.com");
//	}
	
}	
