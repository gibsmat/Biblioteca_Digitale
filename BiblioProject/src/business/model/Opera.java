package business.model;

import java.awt.*;
import java.util.*;
import java.sql.*;

import business.implementation.OperaManagement;

public class Opera {
	int anno;
	String titolo,autore,isbn,Editore;
	SortedMap <String,Image> immagini;
	//file TEI
	
	public Opera(int anno,String titolo, String autore,String isbn,String editore){
		this.anno=anno;
		this.titolo=titolo;
		this.autore=autore;
		this.isbn=isbn;
		this.Editore=editore;
		this.immagini=new TreeMap<String,Image>();
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
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

	public SortedMap<String,Image> getImmagini() {
		return immagini;
	}
	
	//aggiunta nuova immagine
	public void addImmagine(Connection c,String path,String titolo,Image imm){
		this.immagini.put(titolo, imm);
		new OperaManagement(c).addImmagine(this,path);
	}	
	// cancellazione immagine
	public void deleteImmagine(String name) {
		for (Iterator<String> i=this.immagini.keySet().iterator(); i.hasNext();) {
			if(i.equals(name)){
				i.remove();
			}
			}
	}
	
	public void pubblica(){
		/* pubblicazione dell'opera */
	}

}
