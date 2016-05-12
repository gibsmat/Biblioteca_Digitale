package business.model;

import javax.swing.JPasswordField;
import java.awt.*;

public class Acquisitore implements Utente {
	String userId;
	String nome, cognome;
	JPasswordField password= new JPasswordField(6);
	boolean loginStatus;

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
	public void newOpera(int id,int anno,String titolo,String autore){
		Opera opera = new Opera(id,anno,titolo,autore);
	}
	public void addImmagine(Opera opera,String nome,Image imm){
		opera.addImmagine(nome, imm);
	}

}
