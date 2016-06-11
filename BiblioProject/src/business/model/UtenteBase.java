package business.model;

import javax.swing.JPasswordField;

// TODO: Auto-generated Javadoc
/**
 * The Class UtenteBase.
 */
public class UtenteBase implements Utente {
	
	/** The data i. */
	String nome,cognome,userId,dataI;
	
	/** The password. */
	JPasswordField password;	
	
	/** The login status. */
	boolean loginStatus=false;
	
	/**
	 * Instantiates a new utente base.
	 *
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param userId the user id
	 * @param password the password
	 * @param dataI the data i
	 * @param status the status
	 */
	public UtenteBase(String nome,String cognome,String userId,String password,String dataI,boolean status){
		this.nome=nome;
		this.cognome=cognome;
		this.userId=userId;
		this.password=new JPasswordField(password);
		this.dataI=dataI;
		this.loginStatus=status;
	}
	
	/**
	 * Instantiates a new utente base.
	 *
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param userId the user id
	 * @param password the password
	 * @param dataI the data i
	 * @param t the t
	 * @param status the status
	 */
	public UtenteBase(String nome,String cognome,String userId,String password,String dataI,char t,boolean status){
		this.nome=nome;
		this.cognome=cognome;
		this.userId=userId;
		this.password=new JPasswordField(password);
		this.dataI=dataI;
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
		return loginStatus;
	}
	
	/* (non-Javadoc)
	 * @see business.model.Utente#changeStatus()
	 */
	@Override	
	public void changeStatus() {
		this.loginStatus= !(loginStatus);
	}
	
	/* (non-Javadoc)
	 * @see business.model.Utente#getDataI()
	 */
	@Override
	public String getDataI(){
		return this.dataI;
	}
	
/*	public void viewTitles(){
		List<String> listaTitoli = new OperaManagement().getTitles();
		/* aprire finestra con elenco titoli */
//	} 
}
