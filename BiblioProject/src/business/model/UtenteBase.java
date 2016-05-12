package business.model;

import javax.swing.JPasswordField;

public class UtenteBase implements Utente {
	String nome,cognome,userId;
	JPasswordField password;
	boolean loginStatus;
	
	public UtenteBase(String nome, String cognome, String userId, String password) {
		this.nome = nome;
		this.cognome = cognome;
		this.userId = userId;
		this.password = new JPasswordField(password);
		this.loginStatus=false;
	}

	public UtenteBase(String userId, String password) {
		this.userId = userId;
		this.password = new JPasswordField(password);
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
		/* aprire finestra con elenco titoli */
	}

}
