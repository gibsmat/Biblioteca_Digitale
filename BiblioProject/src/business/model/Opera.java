package business.model;

import java.util.*;

import javax.swing.ImageIcon;

// TODO: Auto-generated Javadoc
/**
 * The Class Opera.
 */
public class Opera {
	
	/** anno,titolo,autore,isbn and Editore *. */
	String anno,titolo,autore,isbn,Editore;
	
	/** The immagini. */
	TreeMap <Integer,String> immagini;
	
	/**
	 * Instantiates a new opera.
	 *
	 * @param anno the anno
	 * @param titolo the titolo
	 * @param autore the autore
	 * @param isbn the isbn
	 * @param editore the editore
	 */
	public Opera(String anno,String titolo, String autore,String isbn,String editore){
		this.anno=anno;
		this.titolo=titolo;
		this.autore=autore;
		this.isbn=isbn;
		this.Editore=editore;
		this.immagini=new TreeMap <Integer,String>();
	}
	
	/**
	 * Instantiates a new opera.
	 *
	 * @param anno
	 *            the anno
	 * @param titolo
	 *            the titolo
	 * @param autore
	 *            the autore
	 * @param isbn
	 *            the isbn
	 * @param editore
	 *            the editore
	 * @param imm
	 *            the imm
	 */
	public Opera(String anno,String titolo, String autore,String isbn,String editore, TreeMap <Integer,String> imm){
		this.anno=anno;
		this.titolo=titolo;
		this.autore=autore;
		this.isbn=isbn;
		this.Editore=editore;
		this.immagini=imm;
	}
	
	/**
	 * Gets the anno.
	 *
	 * @return the anno
	 */
	public String getAnno() {
		return anno;
	}
	
	/**
	 * Sets the anno.
	 *
	 * @param anno the new anno
	 */
	public void setAnno(String anno) {
		this.anno = anno;
	}
	
	/**
	 * Gets the titolo.
	 *
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}
	
	/**
	 * Sets the titolo.
	 *
	 * @param titolo the new titolo
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
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
	 * Sets the autore.
	 *
	 * @param autore the new autore
	 */
	public void setAutore(String autore) {
		this.autore = autore;
	}
	
	/**
	 * Gets the isbn.
	 *
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	
	/**
	 * Sets the isbn.
	 *
	 * @param isbn the new isbn
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * Gets the immagini.
	 *
	 * @return the immagini
	 */
	public TreeMap <Integer,String> getImmagini(){
		return immagini;
	}
}
