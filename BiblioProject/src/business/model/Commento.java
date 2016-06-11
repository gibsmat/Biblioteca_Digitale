package business.model;

import java.util.Calendar;

// TODO: Auto-generated Javadoc
/**
 * The Class Commento.
 */
public class Commento {
	
	/** The text. */
	String autore,text;
	
	/** The data. */
	String data;
	
	/**
	 * Instantiates a new commento.
	 *
	 * @param autore the autore
	 * @param text the text
	 */
	public Commento(String autore, String text) {
		this.autore = autore;
		this.text = text;
		this.data = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()).toString().substring(0, 16); //current time
	}

	/**
	 * Gets the autore.
	 *
	 * @return the autore
	 */
	public String getAutore() {
		return autore;
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public String getData() {
		return data;
	}
	
	
}
