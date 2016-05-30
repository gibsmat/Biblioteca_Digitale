package business.model;

import javax.swing.JPasswordField;

public class UtenteBase implements Utente {
	String nome,cognome,userId,dataI;
	JPasswordField password;	
	boolean loginStatus=false;
	
	public UtenteBase(String nome,String cognome,String userId,String password,String dataI,boolean status){
		this.nome=nome;
		this.cognome=cognome;
		this.userId=userId;
		this.password=new JPasswordField(password);
		this.dataI=dataI;
		this.loginStatus=status;
	}
	public UtenteBase(String nome,String cognome,String userId,String password,String dataI,char t,boolean status){
		this.nome=nome;
		this.cognome=cognome;
		this.userId=userId;
		this.password=new JPasswordField(password);
		this.dataI=dataI;
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
		return loginStatus;
	}
	@Override
	public void changeStatus() {
		this.loginStatus= !(loginStatus);
	}
	@Override
	public String getDataI(){
		return this.dataI;
	}
	
/*	public void viewTitles(){
		List<String> listaTitoli = new OperaManagement().getTitles();
		/* aprire finestra con elenco titoli */
//	} 
}
