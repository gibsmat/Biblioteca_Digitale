package business.model;
import business.implementation.*;
import java.util.*;

public class UtenteAvanzato extends UtenteBase {

	public UtenteAvanzato(String nome, String cognome, String userId, String password) {
		super(nome,cognome,userId,password);
	}
	public UtenteAvanzato(String userId, String password) {
		super(userId,password);
	}
	
	public void viewOpera(String stringa){
		List<Opera>listaOpere = new OperaManagement().getOpera(stringa);
		// visualizzare le opere
	}
	public void viewOpera(int anno){
		List<Opera>listaOpere = new OperaManagement().getOpera(anno);
		// visualizzare le opere
	}
}
