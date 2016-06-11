package business.model;

import javax.swing.table.TableModel;

import business.implementation.OperaManagement;

// TODO: Auto-generated Javadoc
/**
 * The Class RevisoreTrascrizioni.
 */
public class RevisoreTrascrizioni extends RevisoreImmagine {

	/**
	 * Instantiates a new revisore trascrizioni.
	 *
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param userId the user id
	 * @param psw the psw
	 * @param status the status
	 */
	public RevisoreTrascrizioni(String nome, String cognome,String userId, String psw,boolean status) {
		super(nome,cognome,userId,psw,status);
	}
	
	/**
	 * Accept t.
	 *
	 * @param path the path
	 */
	public void acceptT(String path){
		new OperaManagement().changeStatoT(path, 1);
	}
	
	/* (non-Javadoc)
	 * @see business.model.RevisoreImmagine#commenta(java.lang.String)
	 */
	public void commenta(String testo){
		Commento commento=new Commento(this.userId,testo);
		new OperaManagement().addCommentoT(commento);
	}

	/* (non-Javadoc)
	 * @see business.model.RevisoreImmagine#viewCommenti()
	 */
	public TableModel viewCommenti(){
		return new OperaManagement().getCommentiT();
	}
}
