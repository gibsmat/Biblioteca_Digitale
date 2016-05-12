package business.model;

public class UtenteAvanzato extends UtenteBase {

	public UtenteAvanzato(String nome, String cognome, String userId, String password) {
		super(nome,cognome,userId,password);
	}
	public UtenteAvanzato(String userId, String password) {
		super(userId,password);
	}
	
	public void viewOpera(){
		// visualizzare le opere
	}

}
