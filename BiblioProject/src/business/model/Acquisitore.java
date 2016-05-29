package business.model;

import javax.swing.JPasswordField;
import java.sql.*;
import business.implementation.OperaManagement;

public class Acquisitore implements Utente {
	String userId;
	String nome, cognome;
	JPasswordField password= null;
	boolean loginStatus=false;
	
	public Acquisitore(String userId, String nome, String cognome,String psw,boolean status) {
		this.userId = userId;
		this.nome = nome;
		this.cognome = cognome;
		this.password=new JPasswordField(psw);
		this.loginStatus=status;
	}
	

	@Override
	public String getUserId() {
		return userId;
	}

	@Override
	public void setUserId(String id) {
		this.userId=id;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public void setNome(String nome) {
		this.nome=nome;
	}

	@Override
	public String getCognome() {
		return cognome;
	}

	@Override
	public void setCognome(String cognome) {
		this.cognome=cognome;
	}

	@Override
	public JPasswordField getPassword() {
		return password;
	}

	@Override
	public void setPassword(String psw) {
		this.password=new JPasswordField(psw);
	}

	@Override
	public boolean getStatus() {
		return this.loginStatus;
	}

	@Override
	public void changeStatus() {
		loginStatus=!loginStatus;
	}

	@Override	
	public String getDataI(){
		return null;
	}
	
	public Opera addOpera(int anno,String titolo,String autore,String isbn,String editore){
		return new OperaManagement().insertOpera(anno,titolo,autore,isbn,editore);
	}
	public void deleteImmagine(String nome){
		new OperaManagement().deleteImmagine(nome);
	}

}
