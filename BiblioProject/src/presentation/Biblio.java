package presentation;

import business.model.*;
import business.implementation.*;
import java.sql.*;

public class Biblio{ 
	
	public static void avvio(Connection con){
		new Login(con);
		
	}

	public static void main(String[] args) {
		avvio(new DbConnection().dbConnector());		
	}
}



