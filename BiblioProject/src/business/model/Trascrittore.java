package business.model;

import javax.swing.JPasswordField;
import javax.swing.table.TableModel;

import business.implementation.OperaManagement;

// TODO: Auto-generated Javadoc
/**
 * The Class Trascrittore.
 */
public class Trascrittore implements Utente {
	
	/** The user id. */
	String userId;
	
	/** The cognome. */
	String nome, cognome;
	
	/** The password. */
	JPasswordField password= null;
	
	/** The login status. */
	boolean loginStatus=false;
	
	/**
	 * Instantiates a new trascrittore.
	 *
	 * @param userId the user id
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param password the password
	 * @param status the status
	 */
	public Trascrittore(String userId, String nome, String cognome, String password,boolean status) {
		this.userId = userId;
		this.nome = nome;
		this.cognome = cognome;
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
	 * Adds the commento.
	 *
	 * @param text the text
	 */
	public void addCommento(String text){
		Commento commento=new Commento(this.getUserId(),text);
		new OperaManagement().addCommentoT(commento);
	}
	
	/**
	 * View commenti.
	 *
	 * @return the table model
	 */
	public TableModel viewCommenti(){
		return new OperaManagement().getCommentiT();
	}

	/**
	 * Adds the trascrizione.
	 *
	 * @param titolo the titolo
	 * @param anno the anno
	 * @param page the page
	 */
	public void addTrascrizione(String titolo,String anno,int page){
		new OperaManagement().addTrascrizione(this,titolo,anno,page);
	}
	
	/**
	 * Delete trascrizione.
	 *
	 * @param opera the opera
	 * @param page the page
	 */
	public void deleteTrascrizione(String opera,int page){
		new OperaManagement().deleteTrascrizione(opera, page);
	}
}
