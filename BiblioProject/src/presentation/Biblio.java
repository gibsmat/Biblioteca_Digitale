package presentation;

import business.model.*;
import java.io.*;
import java.awt.*;
import java.sql.DriverManager;
import java.sql.Timestamp;
import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Biblio extends JFrame { 
	
	public static Connection connect(){
		Connection c=null;		
		try {
		      Class.forName("org.sqlite.JDBC");  //caricamento driver sqlite
		      c = DriverManager.getConnection("jdbc:sqlite:biblioDb.db");  //connessione con db "test"  
		      return c;
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    } 
		return c;
	}	
	public static void avvio(Connection con){
		// Apertura finestra di avvio
		// REGISTRAZIONE  :  new UtenteBase(con,id,password);
	}

	public static void main(String[] args) {					
		// CREAZIONE||CONNESSIONE DB
		avvio(connect());		
	}
}


/* CURRENT TIME
 * String time;
CURRENT TIME :  Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
time=currentTimestamp.toString();*/