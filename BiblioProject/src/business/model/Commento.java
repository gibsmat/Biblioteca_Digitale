package business.model;

import java.util.Calendar;
import java.util.Date;

public class Commento {
	String titolo,autore,text;
	Date data;
	
	public Commento(String titolo, String autore, String text) {
		this.titolo = titolo;
		this.autore = autore;
		this.text = text;
		this.data = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()); //current time
	}

	public String getTitolo() {
		return titolo;
	}

	public String getAutore() {
		return autore;
	}

	public String getText() {
		return text;
	}

	public String getData() {
		return data.toString();
	}
	
	
}
