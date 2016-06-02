package business.model;

import javax.swing.JPasswordField;
import javax.swing.table.TableModel;

import business.implementation.OperaManagement;

public class Trascrittore implements Utente {
	String userId;
	String nome, cognome;
	JPasswordField password= null;
	boolean loginStatus=false;
	
	public Trascrittore(String userId, String nome, String cognome, String password,boolean status) {
		this.userId = userId;
		this.nome = nome;
		this.cognome = cognome;
		this.password = new JPasswordField(password);
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
	
	public void addCommento(String text){
		Commento commento=new Commento(this.getUserId(),text);
		new OperaManagement().addCommentoT(commento);
	}
	
	public TableModel viewCommenti(){
		return new OperaManagement().getCommentiT();
	}

	public void addTrascrizione(){
		
	}
	
	public void deleteTrascrizione(String opera,int page){
		new OperaManagement().deleteTrascrizione(opera, page);
	}
}
