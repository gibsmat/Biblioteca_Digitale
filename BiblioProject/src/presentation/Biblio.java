package presentation;

import business.implementation.*;
import java.sql.*;

public class Biblio{ 
	
	public static void avvio(Connection con){
		new Login();		
	}

	public static void main(String[] args) {
		avvio(DbConnection.dbConnector());		
	}
}



