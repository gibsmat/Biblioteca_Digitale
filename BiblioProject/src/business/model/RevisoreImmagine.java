package business.model;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.table.TableModel;

import business.implementation.*;

// TODO: Auto-generated Javadoc
/**
 * The Class RevisoreImmagine.
 */
public class RevisoreImmagine implements Utente {
	
	/** The user id. */
	String userId;
	
	/** The cognome. */
	String nome, cognome;
	
	/** The password. */
	JPasswordField password= null;
	
	/** The login status. */
	boolean loginStatus=false;

	/**
	 * Instantiates a new revisore immagine.
	 *
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param userId the user id
	 * @param password the password
	 * @param status the status
	 */
	public RevisoreImmagine(String nome, String cognome, String userId, String password,boolean status) {
		this.nome = nome;
		this.cognome = cognome;
		this.userId = userId;
		this.password = new JPasswordField(password);
		this.loginStatus=status;
	}
	
	/* (non-Javadoc)
	 * @see business.model.Utente#getUserId()
	 */
	@Override
	public String getUserId() {
		return userId;
	}

	/* (non-Javadoc)
	 * @see business.model.Utente#setUserId(java.lang.String)
	 */
	@Override
	public void setUserId(String id) {
		this.userId=id;
	}

	/* (non-Javadoc)
	 * @see business.model.Utente#getNome()
	 */
	@Override
	public String getNome() {
		return nome;
	}

	/* (non-Javadoc)
	 * @see business.model.Utente#setNome(java.lang.String)
	 */
	@Override
	public void setNome(String nome) {
		this.nome=nome;
	}

	/* (non-Javadoc)
	 * @see business.model.Utente#getCognome()
	 */
	@Override
	public String getCognome() {
		return cognome;
	}

	/* (non-Javadoc)
	 * @see business.model.Utente#setCognome(java.lang.String)
	 */
	@Override
	public void setCognome(String cognome) {
		this.cognome=cognome;
	}

	/* (non-Javadoc)
	 * @see business.model.Utente#getPassword()
	 */
	@Override
	public JPasswordField getPassword() {
		return password;
	}

	/* (non-Javadoc)
	 * @see business.model.Utente#setPassword(java.lang.String)
	 */
	@Override
	public void setPassword(String psw) {
		this.password=new JPasswordField(psw);
	}

	/* (non-Javadoc)
	 * @see business.model.Utente#getStatus()
	 */
	@Override
	public boolean getStatus() {
		return this.loginStatus;
	}

	/* (non-Javadoc)
	 * @see business.model.Utente#changeStatus()
	 */
	@Override
	public void changeStatus() {
		loginStatus=!loginStatus;
	}
	
	/* (non-Javadoc)
	 * @see business.model.Utente#getDataI()
	 */
	@Override
	public String getDataI(){
		return null;
	}

	/**
	 * Accept im.
	 *
	 * @param path the path
	 */
	public void acceptIm(String path){
		new OperaManagement().changeStatoImm(path,1);
	}
	
	/**
	 * Commenta.
	 *
	 * @param testo the testo
	 */
	public void commenta(String testo){
		Commento commento=new Commento(this.userId,testo);
		new OperaManagement().addCommentoI(commento);
	}
	
	/**
	 * View commenti.
	 *
	 * @return the table model
	 */
	public TableModel viewCommenti(){
		return new OperaManagement().getCommentiI();
	}
}
