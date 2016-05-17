package business.implementation;

import java.sql.*;

import javax.swing.JOptionPane;

public class UserManagement{
	
	public UserManagement(Connection c, String id, String nome, String cognome, String psw){
		nuovoUtente(c,id,nome,cognome,psw);
	}
	public UserManagement(Connection c, String id, String nome, String cognome, String psw,char t){
		nuovoUtente(c,id,nome,cognome,psw,t);
	}
	
	public void nuovoUtente(Connection c, String id,String nome,String cognome,String psw){
		try{
			String query="INSERT INTO UTENTEBASE(username,password,nome,cognome) VALUES (?,?,?,?)";
			PreparedStatement pst=c.prepareStatement(query);
			pst.setString(1,id);
			pst.setString(2,psw);
			pst.setString(3,nome);
			pst.setString(4,cognome);

			pst.execute();
			pst.close(); 
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
				}
	}
	public void nuovoUtente(Connection c, String id,String nome,String cognome,String psw,char t){
		try{
			String query="INSERT INTO UtenteAvanzato(username,password,nome,cognome) VALUES (?,?,?,?)";
			PreparedStatement pst=c.prepareStatement(query);
			pst.setString(1,id);
			pst.setString(2,psw);
			pst.setString(3,nome);
			pst.setString(4,cognome);

			pst.execute();
			pst.close(); 
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
				}
	}
}

  
/* QUERY
 *  String query = "select NOME" + "from" + "test.db" + ".UTENTEBASE";
	 ResultSet rs = stmt.executeQuery(query);
  while (rs.next()) {
      String TestName = rs.getString("NOME");
      System.out.println(TestName);
  }	 */



