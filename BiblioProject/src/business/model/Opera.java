package business.model;

import java.awt.*;
import java.util.*;

import javax.swing.ImageIcon;

import java.sql.*;

import business.implementation.OperaManagement;

public class Opera {
	String anno,titolo,autore,isbn,Editore;
	SortedMap <String,ImageIcon> immagini;
	//file TEI
	
	public Opera(String anno,String titolo, String autore,String isbn,String editore){
		this.anno=anno;
		this.titolo=titolo;
		this.autore=autore;
		this.isbn=isbn;
		this.Editore=editore;
		this.immagini=new TreeMap<String,ImageIcon>();
	}
	public String getAnno() {
		return anno;
	}
	public void setAnno(String anno) {
		this.anno = anno;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public SortedMap<String,ImageIcon> getImmagini() {
		return immagini;
	}
	
	//aggiunta nuova immagine
	public void addImmagine(String path,String nomeI){
		this.immagini.put(nomeI, new ImageIcon(path));
	}	
	// cancellazione immagine
	public void deleteImmagine(String name) {
		for (Iterator<String> i=this.immagini.keySet().iterator(); i.hasNext();) {
			if(i.equals(name)){
				i.remove();
			}
			}
		new OperaManagement().deleteImmagine(name);
	}
	
	public void pubblica(){
		/* pubblicazione dell'opera */
	}

}
