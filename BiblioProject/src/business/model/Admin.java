package business.model;

import business.implementation.*;
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
		Opera o1=findOpera(o.getIdOpera());
		new OperaManagement().deleteOpera(o1);
	}
	protected Opera findOpera(int id){
		//ricerca e restituzione opera per id
		//La query con variabili java si fa usando PreparedStatement
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
