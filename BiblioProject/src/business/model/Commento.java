package business.model;

import java.util.Calendar;

public class Commento {
	String autore,text;
	String data;
	
	public Commento(String autore, String text) {
		this.autore = autore;
		this.text = text;
		this.data = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()).toString().substring(0, 16); //current time
	}

	public String getAutore() {
		return autore;
	}

	public String getText() {
		return text;
	}

	public String getData() {
		return data;
	}
	
	
}
