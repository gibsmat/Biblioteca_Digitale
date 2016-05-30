package business.model;

import business.implementation.*;
import business.Eccezioni;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Admin {
	String adminId;
	JPasswordField password= null;
	boolean loginStatus;
	
	public Admin(){		
	}	
	public Admin(String adminId,String psw){
		this.adminId=adminId;
		this.password=new JPasswordField(psw);
		this.loginStatus=true;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public JPasswordField getPassword() {
		return password;
	}
	public void setPassword(String psw){
		this.password=new JPasswordField(psw);
	}
	public boolean getStatus(){
		return this.loginStatus;
	}
	
	public void clearOpera(String isbn){
		if(new OperaManagement().deleteOpera(isbn)){
			JOptionPane.showMessageDialog(null, "Opera eliminata correttamente.");
		}else{
			new Eccezioni("Errore nella cancellazione dell'opera.");
		}
		
	} 
	
	public void clearUtente(String user){
		if(new UserManagement().deleteUtente(user)){
			JOptionPane.showMessageDialog(null, "Utente eliminato.");
		}else{
			new Eccezioni("Errore nella cancellazione dell'utente.");
		}
	}
	
	public void addTrascrittore(String username,String psw,String nome,String cognome){
		if(new UserManagement().nuovoTrascrittore(username, nome, cognome, psw)){
			JOptionPane.showMessageDialog(null, "Trascrittore aggiunto correttamente.");
		}else{
			new Eccezioni("Errore nell'aggiunta dell'utente trascrittore.");
		}
	}
	
	public void clearTrascrittore(String trascrittore){
		if(new UserManagement().deleteTrascrittore(trascrittore)){
			JOptionPane.showMessageDialog(null, "Trascrittore eliminato.");
		}else{
			new Eccezioni("Errore nella cancellazione del trascrittore.");
		}
	}
	
	public void addAcquisitore(String username,String nome,String cognome,String psw){
		if(new UserManagement().nuovoAcquisitore(username, nome, cognome, psw)){
			JOptionPane.showMessageDialog(null, "Acquisitore aggiunto correttamente.");
		}else{
			new Eccezioni("Errore nell'aggiunta dell'utente acquisitore.");
		}
	}
	
	public void clearAcquisitore(String acquisitore){
		if(new UserManagement().deleteAcquisitore(acquisitore)){
			JOptionPane.showMessageDialog(null, "Acquisitore eliminato.");
		}else{
			new Eccezioni("Errore nella cancellazione dell'acquisitore.");
		}
	}
	
	public void addRevisoreImm(String username,String nome,String cognome,String psw){
		if(new UserManagement().nuovoRevisoreImm(username, nome, cognome, psw)){
			JOptionPane.showMessageDialog(null, "revisore immagini aggiunto correttamente.");
		}else{
			new Eccezioni("Errore nell'aggiunta dell'utente revisore immagini.");
		}
	}
	
	public void clearRevisoreImm(String revisore){
		if(new UserManagement().deleteRevisoreI(revisore)){
			JOptionPane.showMessageDialog(null, "Revisore immagini eliminato.");
		}else{
			new Eccezioni("Errore nella cancellazione del revisore immagini.");
		}
	}
	
	public void addRevisoreTr(String username,String nome,String cognome,String psw){
		if(new UserManagement().nuovoRevisoreT(username, nome, cognome, psw)){
			JOptionPane.showMessageDialog(null, "revisore trascrizioni aggiunto correttamente.");
		}else{
			new Eccezioni("Errore nell'aggiunta dell'utente revisore trascrizioni.");
		}
	}
	
	public void clearRevisoreTr(String revisore){
		if(new UserManagement().deleteRevisoreT(revisore)){
			JOptionPane.showMessageDialog(null, "Revisore trascrizioni eliminato.");
		}else{
			new Eccezioni("Errore nella cancellazione del revisore trascrizioni.");
		}
	}
	
}
