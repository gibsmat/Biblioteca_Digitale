package presentation;

import business.model.*;
import business.implementation.*;
import java.sql.*;

import javax.swing.JOptionPane;

public class Biblio{ 
	
	public static void avvio(Connection con){
		new Login();		
	}

	public static void main(String[] args) {
		avvio(new DbConnection().dbConnector());		
	}
}



