package business.model;

import business.implementation.*;
import javax.swing.JPasswordField;
import java.sql.*;

import business.implementation.OperaManagement;

import java.util.*;

public class UtenteBase implements Utente {
	String nome,cognome,userId;
	JPasswordField password;
	boolean loginStatus;
	
	public UtenteBase(Connection c,String nome, String cognome, String userId, String password) {
		this.nome = nome;
		this.cognome = cognome;
		this.userId = userId;
		this.password = new JPasswordField(password);
		this.loginStatus=false;
		new UserManagement(c, userId, nome, cognome, password);
	}
	public UtenteBase(Connection c,String nome, String cognome, String userId, String password,char t) {
		this.nome = nome;
		this.cognome = cognome;
		this.userId = userId;
		this.password = new JPasswordField(password);
		this.loginStatus=false;
		new UserManagement(c, userId, nome, cognome, password,t);
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
		return loginStatus;
	}
	@Override
	public void changeStatus() {
		this.loginStatus= !(loginStatus);
	}

	public void login(){
		/* aprire finestra di login */
	}
	public void registrazione(){
		/* aprire finestra di registrazione */
	}
	
	public void viewTitles(){
		List<String> listaTitoli = new OperaManagement().getTitles();
		/* aprire finestra con elenco titoli */
	}

}
