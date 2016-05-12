package business.model;

import business.implementation.*;
import javax.swing.JPasswordField;

import business.implementation.OperaManagement;

import java.awt.*;

public class Acquisitore implements Utente {
	String userId;
	String nome, cognome;
	JPasswordField password= null;
	boolean loginStatus;
	
	public Acquisitore(String userId, String nome, String cognome,String psw) {
		this.userId = userId;
		this.nome = nome;
		this.cognome = cognome;
		this.password=new JPasswordField(psw);
		this.loginStatus=false;
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
	
	public void addOpera(int id,int anno,String titolo,String autore,String isbn){
		Opera opera = new Opera(id,anno,titolo,autore,isbn);
		new OperaManagement().insertOpera(opera);
	}
	public void addImmagine(Opera opera,String nome,Image imm){
		opera.addImmagine(nome, imm);
	}

}
