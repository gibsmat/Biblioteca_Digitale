package business.model;

import business.implementation.*;
import java.util.*;
import java.sql.*;

public class UtenteAvanzato extends UtenteBase {
	final static char type='a';

	public UtenteAvanzato(Connection c,String nome, String cognome, String userId, String password) {
		super(c,nome,cognome,userId,password,type);
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
