package business.model;

import business.implementation.*;
import java.util.*;
import java.sql.*;

public class UtenteAvanzato extends UtenteBase {
	final static char type='a';

	public UtenteAvanzato(String nome, String cognome, String userId, String password,String dataI,boolean status) {
		super(nome,cognome,userId,password,dataI,type,status);
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
