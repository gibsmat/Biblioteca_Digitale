package business.model;

import javax.swing.JPasswordField;

public class Admin {
	String adminId;
	JPasswordField password= null;
	boolean loginStatus;
	
	protected Admin(String adminId,String psw){
		this.adminId=adminId;
		this.password=new JPasswordField(psw);
		this.loginStatus=false;
	}
	protected String getAdminId() {
		return adminId;
	}
	protected void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	protected JPasswordField getPassword() {
		return password;
	}
	protected void setPassword(String psw){
		this.password=new JPasswordField(psw);
	}
	protected boolean getStatus(){
		return this.loginStatus;
	}
	protected void clearOpera(Opera o){
		// Cancellazione opera
	}
	protected void clearUtente(UtenteBase ub){
		// Cancellazione utenteBase
	}
	protected void clearUtente(UtenteAvanzato ua){
		// Cancellazione utenteAvanzato
	}
	protected void addTrascrittore(Trascrittore t){
		// Aggiunta trascrittore
	}
	protected void addAcquisitore(Acquisitore a){
		// aggiunta acquisitore
	}
	protected void addRevisoreImm(RevisoreImmagine rI){
		// aggiunta revisoreImmagini
	}
	protected void addRevisoreTr(RevisoreTrascrizioni rT){
		// aggiunta revisoreTrascrizioni
	}

}
