package business.model;

import javax.swing.JPasswordField;
import javax.swing.table.TableModel;

import business.implementation.OperaManagement;

// TODO: Auto-generated Javadoc
/**
 * The Class Acquisitore.
 */
public class Acquisitore implements Utente {
	
	/** The user id. */
	String userId;
	
	/** The cognome. */
	String nome, cognome;
	
	/** The password. */
	JPasswordField password= null;
	
	/** The login status. */
	boolean loginStatus=false;
	
	/**
	 * Instantiates a new acquisitore.
	 *
	 * @param userId the user id
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param psw the psw
	 * @param status the status
	 */
	public Acquisitore(String userId, String nome, String cognome,String psw,boolean status) {
		this.userId = userId;
		this.nome = nome;
		this.cognome = cognome;
		this.password=new JPasswordField(psw);
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
	 * Adds the opera.
	 *
	 * @param anno the anno
	 * @param titolo the titolo
	 * @param autore the autore
	 * @param isbn the isbn
	 * @param editore the editore
	 */
	public void addOpera(String anno,String titolo,String autore,String isbn,String editore){
		new OperaManagement().insertOpera(anno,titolo,autore,isbn,editore);
	}
	
	/**
	 * Delete immagine.
	 *
	 * @param nome the nome
	 * @param page the page
	 */
	public void deleteImmagine(String nome,int page){
		new OperaManagement().deleteImmagine(nome,page);
	}
	
	/**
	 * Adds the immagine.
	 *
	 * @param path the path
	 * @param opera the opera
	 * @param page the page
	 */
	public void addImmagine(String path,String opera,Integer page){
		new OperaManagement().addImmagine(opera,path,page);		
	}
	
	/**
	 * Adds the commento.
	 *
	 * @param text the text
	 */
	public void addCommento(String text){
		Commento commento=new Commento(this.getUserId(),text);
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
