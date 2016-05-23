package business.model;

import business.implementation.*;
import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Admin {
	String adminId;
	JPasswordField password= null;
	boolean loginStatus;
	Connection c=null;
	
	public Admin(Connection c){		
		this.c=c;
	}	
	public Admin(Connection c,String adminId,String psw){
		this.adminId=adminId;
		this.password=new JPasswordField(psw);
		this.loginStatus=false;
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
	
	/*public void clearOpera(Opera o){
		Opera o1=findOpera(o.getIdOpera());
		new OperaManagement().deleteOpera(o1);
	} */
	/*	public Opera findOpera(int id){
		//ricerca e restituzione opera per id
	} */
	
	public void clearUtente(String user){
		if(new UserManagement(c).deleteUtente(user)){
			JOptionPane.showMessageDialog(null, "Utente eliminato.");
		}else{
			JOptionPane.showMessageDialog(null, "Errore nella cancellazione dell'utente.");
		}
	}
	
	public void addTrascrittore(String username,String psw,String nome,String cognome){
		if(new UserManagement(c).nuovoTrascrittore(username, nome, cognome, psw)){
			JOptionPane.showMessageDialog(null, "Trascrittore aggiunto correttamente.");
		}else{
			JOptionPane.showMessageDialog(null, "Errore nell'aggiunta dell'utente trascrittore.");
		}
	}
	
	public void clearTrascrittore(String trascrittore){
		if(new UserManagement(c).deleteTrascrittore(trascrittore)){
			JOptionPane.showMessageDialog(null, "Trascrittore eliminato.");
		}else{
			JOptionPane.showMessageDialog(null, "Errore nella cancellazione del trascrittore.");
		}
	}
	
	public void addAcquisitore(String username,String nome,String cognome,String psw){
		if(new UserManagement(c).nuovoAcquisitore(username, nome, cognome, psw)){
			JOptionPane.showMessageDialog(null, "acquisitore aggiunto correttamente.");
		}else{
			JOptionPane.showMessageDialog(null, "Errore nell'aggiunta dell'utente acquisitore.");
		}
	}
	
	public void clearAcquisitore(String acquisitore){
		if(new UserManagement(c).deleteAcquisitore(acquisitore)){
			JOptionPane.showMessageDialog(null, "Acquisitore eliminato.");
		}else{
			JOptionPane.showMessageDialog(null, "Errore nella cancellazione dell'acquisitore.");
		}
	}
	
	public void addRevisoreImm(String username,String nome,String cognome,String psw){
		if(new UserManagement(c).nuovoRevisoreImm(username, nome, cognome, psw)){
			JOptionPane.showMessageDialog(null, "revisore immagini aggiunto correttamente.");
		}else{
			JOptionPane.showMessageDialog(null, "Errore nell'aggiunta dell'utente revisore immagini.");
		}
	}
	
	public void clearRevisoreImm(String revisore){
		if(new UserManagement(c).deleteRevisoreI(revisore)){
			JOptionPane.showMessageDialog(null, "Revisore immagini eliminato.");
		}else{
			JOptionPane.showMessageDialog(null, "Errore nella cancellazione del revisore immagini.");
		}
	}
	
	public void addRevisoreTr(String username,String nome,String cognome,String psw){
		if(new UserManagement(c).nuovoRevisoreT(username, nome, cognome, psw)){
			JOptionPane.showMessageDialog(null, "revisore trascrizioni aggiunto correttamente.");
		}else{
			JOptionPane.showMessageDialog(null, "Errore nell'aggiunta dell'utente revisore trascrizioni.");
		}
	}
	
	public void clearRevisoreTr(String revisore){
		if(new UserManagement(c).deleteRevisoreT(revisore)){
			JOptionPane.showMessageDialog(null, "Revisore trascrizioni eliminato.");
		}else{
			JOptionPane.showMessageDialog(null, "Errore nella cancellazione del revisore trascrizioni.");
		}
	}
	
}
