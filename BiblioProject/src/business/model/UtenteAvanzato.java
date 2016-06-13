package business.model;


// TODO: Auto-generated Javadoc
/**
 * The Class UtenteAvanzato.
 */
public class UtenteAvanzato extends UtenteBase {
	
	/** The Constant type. */
	final static char type='a';

	/**
	 * Instantiates a new utente avanzato.
	 *
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param userId the user id
	 * @param password the password
	 * @param dataI the data i
	 * @param status the status
	 */
	public UtenteAvanzato(String nome, String cognome, String userId, String password,String dataI,boolean status) {
		super(nome,cognome,userId,password,dataI,type,status);
	}
	
	
/*	public void viewOpera(String stringa){
		List<Opera>listaOpere = new OperaManagement().getOpera(stringa);
	}
	public void viewOpera(int anno){
		List<Opera>listaOpere = new OperaManagement().getOpera(anno);
	} */
}
