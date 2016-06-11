package business.model;

import business.implementation.*;
import business.Eccezioni;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

// TODO: Auto-generated Javadoc
/**
 * The Class Admin.
 */
public class Admin {
	
	/** The admin id. */
	String adminId;
	
	/** The password. */
	JPasswordField password= null;
	
	/** The login status. */
	boolean loginStatus;
	
	/**
	 * Instantiates a new admin.
	 */
	public Admin(){		
	}	
	
	/**
	 * Instantiates a new admin.
	 *
	 * @param adminId the admin id
	 * @param psw the psw
	 */
	public Admin(String adminId,String psw){
		this.adminId=adminId;
		this.password=new JPasswordField(psw);
		this.loginStatus=true;
	}
	
	/**
	 * Gets the admin id.
	 *
	 * @return the admin id
	 */
	public String getAdminId() {
		return adminId;
	}
	
	/**
	 * Sets the admin id.
	 *
	 * @param adminId the new admin id
	 */
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public JPasswordField getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param psw the new password
	 */
	public void setPassword(String psw){
		this.password=new JPasswordField(psw);
	}
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public boolean getStatus(){
		return this.loginStatus;
	}
	
	/**
	 * Clear opera.
	 *
	 * @param isbn the isbn
	 */
	public void clearOpera(String isbn){
		if(new OperaManagement().deleteOpera(isbn)){
			JOptionPane.showMessageDialog(null, "Opera eliminata correttamente.");
		}else{
			new Eccezioni("Errore nella cancellazione dell'opera. \nOpera non presente.");
		}
		
	} 
	
	/**
	 * Clear utente.
	 *
	 * @param user the user
	 */
	public void clearUtente(String user){
		if(new UserManagement().deleteUtente(user)){
			JOptionPane.showMessageDialog(null, "Utente eliminato.");
		}else{
			new Eccezioni("Errore nella cancellazione dell'utente.");
		}
	}
	
	/**
	 * Adds the trascrittore.
	 *
	 * @param username the username
	 * @param psw the psw
	 * @param nome the nome
	 * @param cognome the cognome
	 */
	public void addTrascrittore(String username,String psw,String nome,String cognome){
		if(new UserManagement().nuovoTrascrittore(username, nome, cognome, psw)){
			JOptionPane.showMessageDialog(null, "Trascrittore aggiunto correttamente.");
		}else{
			new Eccezioni("Errore nell'aggiunta dell'utente trascrittore.");
		}
	}
	
	/**
	 * Clear trascrittore.
	 *
	 * @param trascrittore the trascrittore
	 */
	public void clearTrascrittore(String trascrittore){
		if(new UserManagement().deleteTrascrittore(trascrittore)){
			JOptionPane.showMessageDialog(null, "Trascrittore eliminato.");
		}else{
			new Eccezioni("Errore nella cancellazione del trascrittore.");
		}
	}
	
	/**
	 * Adds the acquisitore.
	 *
	 * @param username the username
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param psw the psw
	 */
	public void addAcquisitore(String username,String nome,String cognome,String psw){
		if(new UserManagement().nuovoAcquisitore(username, nome, cognome, psw)){
			JOptionPane.showMessageDialog(null, "Acquisitore aggiunto correttamente.");
		}else{
			new Eccezioni("Errore nell'aggiunta dell'utente acquisitore.");
		}
	}
	
	/**
	 * Clear acquisitore.
	 *
	 * @param acquisitore the acquisitore
	 */
	public void clearAcquisitore(String acquisitore){
		if(new UserManagement().deleteAcquisitore(acquisitore)){
			JOptionPane.showMessageDialog(null, "Acquisitore eliminato.");
		}else{
			new Eccezioni("Errore nella cancellazione dell'acquisitore.");
		}
	}
	
	/**
	 * Adds the revisore imm.
	 *
	 * @param username the username
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param psw the psw
	 */
	public void addRevisoreImm(String username,String nome,String cognome,String psw){
		if(new UserManagement().nuovoRevisoreImm(username, nome, cognome, psw)){
			JOptionPane.showMessageDialog(null, "revisore immagini aggiunto correttamente.");
		}else{
			new Eccezioni("Errore nell'aggiunta dell'utente revisore immagini.");
		}
	}
	
	/**
	 * Clear revisore imm.
	 *
	 * @param revisore the revisore
	 */
	public void clearRevisoreImm(String revisore){
		if(new UserManagement().deleteRevisoreI(revisore)){
			JOptionPane.showMessageDialog(null, "Revisore immagini eliminato.");
		}else{
			new Eccezioni("Errore nella cancellazione del revisore immagini.");
		}
	}
	
	/**
	 * Adds the revisore tr.
	 *
	 * @param username the username
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param psw the psw
	 */
	public void addRevisoreTr(String username,String nome,String cognome,String psw){
		if(new UserManagement().nuovoRevisoreT(username, nome, cognome, psw)){
			JOptionPane.showMessageDialog(null, "revisore trascrizioni aggiunto correttamente.");
		}else{
			new Eccezioni("Errore nell'aggiunta dell'utente revisore trascrizioni.");
		}
	}
	
	/**
	 * Clear revisore tr.
	 *
	 * @param revisore the revisore
	 */
	public void clearRevisoreTr(String revisore){
		if(new UserManagement().deleteRevisoreT(revisore)){
			JOptionPane.showMessageDialog(null, "Revisore trascrizioni eliminato.");
		}else{
			new Eccezioni("Errore nella cancellazione del revisore trascrizioni.");
		}
	}
	
}
