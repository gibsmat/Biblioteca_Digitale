package business.model;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import business.implementation.*;

public class RevisoreImmagine implements Utente {
	String userId;
	String nome, cognome;
	JPasswordField password= null;
	boolean loginStatus=false;

	public RevisoreImmagine(String nome, String cognome, String userId, String password,boolean status) {
		this.nome = nome;
		this.cognome = cognome;
		this.userId = userId;
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
		
	public void revisionaIm(ImageIcon image){
		//aprire immagine		
	}

	public void acceptIm(String nameI){
		new OperaManagement().changeStatoImm(nameI,1);
	}
	
	public void commenta(String testo,String imageName){
		Commento commento=new Commento(imageName,this.userId,testo);
		new OperaManagement().addCommentoI(commento);
	}
}
