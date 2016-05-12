package business.model;

import java.awt.*;
import java.util.*;

public class Opera {
	int idOpera,anno;
	String titolo,autore,isbn;
	SortedMap <String,Image> immagini;
	//file TEI
	
	public Opera(int id, int anno,String titolo, String autore,String isbn){
		this.idOpera=id;
		this.anno=anno;
		this.titolo=titolo;
		this.autore=autore;
		this.isbn=isbn;
		this.immagini=new TreeMap<String,Image>();
	}
	
	public int getIdOpera() {
		return idOpera;
	}
	public void setIdOpera(int idOpera) {
		this.idOpera = idOpera;
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
	
	// cancellazione immagine
	public void deleteImmagine(String name) {
		for (Iterator<String> i=this.immagini.keySet().iterator(); i.hasNext();) {
			if(i.equals(name)){
				i.remove();
			}
			}
	}
	
	//aggiunta nuova immagine
	public void addImmagine(String name,Image imm){
		immagini.put(name, imm);
	}
	
	public void pubblica(){
		/* pubblicazione dell'opera */
	}

}
