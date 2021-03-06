package business.implementation;

import java.sql.*;
import java.util.Calendar;
import java.util.TreeSet;
import javax.swing.JPasswordField;
import javax.swing.table.TableModel;

import business.model.*;
import net.proteanit.sql.DbUtils;
import business.Eccezioni;

// TODO: Auto-generated Javadoc
/**
 * The Class UserManagement.
 */
public class UserManagement{
	
	/** The c. */
	Connection c=DbConnection.dbConnector();
	
	/**
	 * Instantiates a new user management.
	 */
	public UserManagement(){	
	}
	
	/**
	 * Nuovo utente.
	 *
	 * @param id the id
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param psw the psw
	 * @return true, if successful
	 */
	public boolean nuovoUtente(String id,String nome,String cognome,String psw){
		if(check(id)){
			try{
				String query="INSERT INTO UTENTEBASE(username,password,nome,cognome,dataI) VALUES (?,?,?,?,?)";
				PreparedStatement pst=c.prepareStatement(query);
				pst.setString(1,id);
				pst.setString(2,psw);
				pst.setString(3,nome);
				pst.setString(4,cognome);
				pst.setString(5, new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()).toString().substring(0, 16));
	
				pst.execute();
				pst.close();
				c.close();
				return true;
			}
			catch(Exception e)
			{
				new Eccezioni("Errore. Registrazione non effettuata.",e);
				return false;
					}
		}
		else{
			new Eccezioni("Username gi� presente.");
			return false;
		}
		}
	
	/**
	 * Nuovo utente.
	 *
	 * @param id the id
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param psw the psw
	 * @param t the t
	 * @return true, if successful
	 */
	public boolean nuovoUtente(String id,String nome,String cognome,String psw,char t){
		if(check(id)){
			try{
				String query="INSERT INTO UtenteAvanzato(usernameA,passwordA,nomeA,cognomeA,dataIA) VALUES (?,?,?,?,?)";
				PreparedStatement pst=c.prepareStatement(query);
				pst.setString(1,id);
				pst.setString(2,psw);
				pst.setString(3,nome);
				pst.setString(4,cognome);
				pst.setString(5, new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()).toString().substring(0, 16));
	
				pst.execute();
				pst.close();
				c.close();
				return true;
			}
			catch(Exception e)
			{
				new Eccezioni("Errore. Registrazione non effettuata.",e);
				return false;
					}
		}else{
			new Eccezioni("Username gi� presente.");
			return false;
		}
	}
	
	/**
	 * Nuovo trascrittore.
	 *
	 * @param id the id
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param psw the psw
	 * @return true, if successful
	 */
	public boolean nuovoTrascrittore(String id,String nome,String cognome,String psw){
		if(check(id)){
			try{
				String query="INSERT INTO Trascrittore(usernameT,passwordT,nomeT,cognomeT) VALUES (?,?,?,?)";
				PreparedStatement pst=c.prepareStatement(query);
				pst.setString(1,id);
				pst.setString(2,psw);
				pst.setString(3,nome);
				pst.setString(4,cognome);
	
				pst.execute();
				pst.close(); 
				c.close();
				return true;
			}
			catch(Exception e)
			{
				new Eccezioni("Errore. Registrazione non effettuata.",e);
				return false;
					}
		}else{
			new Eccezioni("Username gi� presente.");
			return false;
		}
	}
	
	/**
	 * Nuovo acquisitore.
	 *
	 * @param id the id
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param psw the psw
	 * @return true, if successful
	 */
	public boolean nuovoAcquisitore(String id,String nome,String cognome,String psw){
		if(check(id)){
			try{
				String queryAc="INSERT INTO Acquisitore(usernameAc,passwordAc,nomeAc,cognomeAc) VALUES (?,?,?,?)";
				PreparedStatement pst=c.prepareStatement(queryAc);
				pst.setString(1,id);
				pst.setString(2,psw);
				pst.setString(3,nome);
				pst.setString(4,cognome);
	
				pst.execute();
				pst.close(); 
				c.close();
				return true;
			}
			catch(Exception e){
				new Eccezioni("username gi� presente",e);
				return false;
			}
		}else{
			return false;
		}
	}
	
	/**
	 * Nuovo revisore imm.
	 *
	 * @param id the id
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param psw the psw
	 * @return true, if successful
	 */
	public boolean nuovoRevisoreImm(String id,String nome,String cognome,String psw){
		if(check(id)){
			try{
				String query="INSERT INTO RevisoreI(usernameI,passwordI,nomeI,cognomeI) VALUES (?,?,?,?)";
				PreparedStatement pst=c.prepareStatement(query);
				pst.setString(1,id);
				pst.setString(2,psw);
				pst.setString(3,nome);
				pst.setString(4,cognome);
	
				pst.execute();
				pst.close(); 
				c.close();
				return true;
			}
			catch(Exception e){
				new Eccezioni("username gi� presente",e);
				return false;
			}
		}else{
			return false;
		}
	}
	
	/**
	 * Nuovo revisore t.
	 *
	 * @param id
	 *            the id
	 * @param psw
	 *            the psw
	 * @param nome
	 *            the nome
	 * @param cognome
	 *            the cognome
	 * @return true, if successful
	 */
	public boolean nuovoRevisoreT(String id,String psw,String nome,String cognome){
		if(check(id)){
			try{
				String query="INSERT INTO RevisoreT(usernameTr,passwordTr,nomeTr,cognomeTr) VALUES (?,?,?,?)";
				PreparedStatement pst=c.prepareStatement(query);
				pst.setString(1,id);
				pst.setString(2,psw);
				pst.setString(3,nome);
				pst.setString(4,cognome);
	
				pst.execute();
				pst.close(); 
				c.close();
				return true;
			}
			catch(Exception e)
			{
				new Eccezioni("Errore. Registrazione non effettuata.",e);
				return false;
					}
		}else{
			new Eccezioni("Username gi� presente.");
			return false;
		}
	}
	
	/**
	 * Gets the utente.
	 *
	 * @param username the username
	 * @param psw the psw
	 * @return the utente
	 */
	public Utente getUtente(String username,JPasswordField psw){
		String nome, cognome,dataI;
		PreparedStatement pst;
		ResultSet rs;
		try{
			String query="select * from UTENTEBASE where username=? and password=?";
			pst= c.prepareStatement(query);
			pst.setString(1,username);	
			pst.setString(2, psw.getText());
			rs=pst.executeQuery();
			
			if(rs.next()){
				nome=rs.getString("nome");
				cognome=rs.getString("cognome");
				dataI=rs.getString("dataI");
				c.close();
				return new UtenteBase(nome,cognome,username,psw.getText(),dataI,true);
			}
			else{ 
				try{
				String queryA="select * from UtenteAvanzato where usernameA=? and passwordA=?";
				pst= c.prepareStatement(queryA);
				pst.setString(1,username);	
				pst.setString(2, psw.getText());
				rs=pst.executeQuery();
				
				if(rs.next()){
					nome=rs.getString("nomeA");
					cognome=rs.getString("cognomeA");
					dataI=rs.getString("dataIA");
					c.close();
					return new UtenteAvanzato(nome,cognome,username,psw.getText(),dataI,true);
				}
				else{
					try{
						String queryT="select * from Trascrittore where usernameT=? and passwordT=?";
						pst= c.prepareStatement(queryT);
						pst.setString(1,username);	
						pst.setString(2, psw.getText());
						rs=pst.executeQuery();
						
						if(rs.next()){
							nome=rs.getString("nomeT");
							cognome=rs.getString("cognomeT");
							c.close();
							return new Trascrittore(username,nome,cognome,psw.getText(),true);
						}
						else{
							try{
								String queryAc="select * from Acquisitore where usernameAc=? and passwordAc=?";
								pst= c.prepareStatement(queryAc);
								pst.setString(1,username);	
								pst.setString(2, psw.getText());
								rs=pst.executeQuery();
								
								if(rs.next()){
									nome=rs.getString("nomeAc");
									cognome=rs.getString("cognomeAc");
									c.close();
									return new Acquisitore(username,nome,cognome,psw.getText(),true);
								}
								else{
									try{
										String queryRi="select * from RevisoreI where usernameI=? and passwordI=?";
										pst= c.prepareStatement(queryRi);
										pst.setString(1,username);	
										pst.setString(2, psw.getText());
										rs=pst.executeQuery();
										
										if(rs.next()){
											nome=rs.getString("nomeI");
											cognome=rs.getString("cognomeI");
											c.close();
											return new RevisoreImmagine(nome,cognome,username,psw.getText(),true);
										}
										else{
											try{
												String queryTr="select * from RevisoreT where usernameTr=? and passwordTr=?";
												pst= c.prepareStatement(queryTr);
												pst.setString(1,username);	
												pst.setString(2, psw.getText());
												rs=pst.executeQuery();
												
												if(rs.next()){
													nome=rs.getString("nomeTr");
													cognome=rs.getString("cognomeTr");
													c.close();
													return new RevisoreTrascrizioni(nome,cognome,username,psw.getText(),true);
												}
												else{
													return null;													
													}				
												}catch(Exception e1){
													new Eccezioni("Revisore trascrizioni inesistente",e1);
												return null;
												}
											
											}				
										}catch(Exception e1){
											new Eccezioni("Revisore immagini inesistente",e1);
										return null;
										}

									
									}				
								}catch(Exception e1){
									new Eccezioni("acquisitore inesistente",e1);
								return null;
								}

							
							}				
						}catch(Exception e1){
							new Eccezioni("trascrittore inesistente",e1);
						return null;
						}

					}				
				}catch(Exception e1){
					new Eccezioni("utente avanzato inesistente",e1);
				return null;
				}
			}
		}catch(Exception e){
			new Eccezioni("utente base inesistente.",e);
				return null;
			}

	}
	
	/**
	 * Gets the utente.
	 *
	 * @param username the username
	 * @return the utente
	 */
	public UtenteBase getUtente(String username){
		String nome,password;
		String cognome,dataI;
		try{
			String query="select * from UTENTEBASE where username=?";
			PreparedStatement pst= c.prepareStatement(query);
			pst.setString(1,username);	
			ResultSet rs=pst.executeQuery();
			
			if(rs.next()){
				password=rs.getString("password");
				nome=rs.getString("nome");
				cognome=rs.getString("cognome");
				dataI=rs.getString("dataI");
				//c.close();
				return new UtenteBase(nome,cognome,username,password,dataI,true);
			}
			else{ 
				try{
				String queryA="select * from UtenteAvanzato where usernameA=?";
				PreparedStatement pstA= c.prepareStatement(queryA);
				pstA.setString(1,username);	
				ResultSet rsA=pstA.executeQuery();
				
				if(rsA.next()){
					password=rsA.getString("passwordA");
					nome=rsA.getString("nomeA");
					cognome=rsA.getString("cognomeA");
					dataI=rsA.getString("dataIA");
					//c.close();
					return new UtenteAvanzato(nome,cognome,username,password,dataI,true);
				}
				else{
					new Eccezioni("Username o password non validi.");
					return null;
				}				
			}catch(Exception e){
				new Eccezioni("utente avanzato inesistente",e);
				return null;
			}
			}
		}catch(Exception e){
			new Eccezioni("utente base inesistente.",e);
				return null;
			}

	}
	
	/**
	 * Gets the utenti.
	 *
	 * @param type the type
	 * @return the utenti
	 */
	public TableModel getUtenti(String type){
		Statement st;
		ResultSet rs;
		TableModel tm;
		String query="";
		try{
			switch(type){
				case "Utente Base" :
					query= "SELECT username,nome,cognome FROM UTENTEBASE";
					break;
				case "Utente Avanzato":
					query= "SELECT usernameA,nomeA,cognomeA,dataIA FROM UtenteAvanzato";
					break;
				case "Trascrittore":
					query= "SELECT usernameT,nomeT,cognomeT FROM Trascrittore";
					break;
				case "Acquisitore":
					query= "SELECT usernameAc,nomeAc,cognomeAc FROM Acquisitore";
					break;
				case "Revisore Immagini":
					query= "SELECT usernameI,nomeI,cognomeI FROM RevisoreI";
					break;
				case "Revisore Trascrizioni":
					query= "SELECT usernameTr,nomeTr,cognomeTr FROM RevisoreT";	
					break;
				default:
					break;
			}			
			st=c.createStatement();
			rs= st.executeQuery(query);
			tm= DbUtils.resultSetToTableModel(rs);
			c.close();
			return tm;	
			
		}catch(SQLException e){
			new Eccezioni("Db error \n"+e);
			return null;
		}
	}
	
	/**
	 * Sets the utente.
	 *
	 * @param utente the utente
	 * @param username the username
	 * @param nome the nome
	 * @param cognome the cognome
	 * @param password the password
	 * @return true, if successful
	 */
	public boolean setUtente(UtenteBase utente,String username,String nome,String cognome,String password){
		if(utente instanceof UtenteAvanzato){
			try{
				String query="UPDATE UtenteAvanzato SET usernameA=?, nomeA=?, cognomeA=?, passwordA=? WHERE usernameA=?";
				PreparedStatement pst = c.prepareStatement(query);
				pst.setString(1, username);
				pst.setString(2, nome);
				pst.setString(3, cognome);
				pst.setString(4, password);
				pst.setString(5,utente.getUserId());
				
				pst.execute();
				c.close();
				return true;			
			}	
			catch(Exception e){
				new Eccezioni("Db error \n"+e);
				return false;
			}
		}
		else{
			try{
				String query="UPDATE UTENTEBASE SET username=?, nome=?, cognome=?, password=? WHERE username=?";
				PreparedStatement pst = c.prepareStatement(query);
				pst.setString(1, username);
				pst.setString(2, nome);
				pst.setString(3, cognome);
				pst.setString(4, password);
				pst.setString(5,utente.getUserId());
				
				pst.execute();
				c.close();
				return true;			
			}	
			catch(Exception e){
				new Eccezioni("Db error \n"+e);
				return false;
			}
		}
	}
	
	/**
	 * Check.
	 *
	 * @param username the username
	 * @return true, if successful
	 */
	public boolean check(String username){
		int i;
		try{
			String queryC="SELECT * FROM UTENTEBASE,UtenteAvanzato,Acquisitore,Trascrittore,RevisoreI,RevisoreT WHERE username=? OR usernameA=? OR usernameAc=? OR usernameT=? OR usernameI=? OR usernameTr=? ";
			PreparedStatement pstC=c.prepareStatement(queryC);
			for(i=1;i<7;i++){
				pstC.setString(i,username);
			}	
			ResultSet rs=pstC.executeQuery();
			if(rs.next()){			
				pstC.close();
				rs.close();
				c.close();
				return false;
			}
			pstC.close();
			rs.close();	
			return true; 
		}catch(Exception e){
			new Eccezioni(e);
			return false;
		}
		
	}
	
	/**
	 * Find users.
	 *
	 * @return the tree set
	 */
	public TreeSet<String> findUsers(){
		TreeSet <String>utentiBase=new TreeSet<String>();
		Statement st=null; Statement stA=null;
		try{
			String query="SELECT username FROM UTENTEBASE";
			st=c.createStatement();			
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next()){
				utentiBase.add(rs.getString("username"));
			}
			rs.close();
			c.close();
		}catch(Exception e){
			new Eccezioni(e);
			return null;
		} 
		try{
			stA=c.createStatement();
			ResultSet rsA=stA.executeQuery("SELECT usernameA FROM UtenteAvanzato");
			while(rsA.next()){
				utentiBase.add(rsA.getString("usernameA"));
			}
			rsA.close();
			c.close();
			return utentiBase;
		}catch(Exception e){
			new Eccezioni(e);
			return null;
		} 
	}
	
	/**
	 * Find tr.
	 *
	 * @return the tree set
	 */
	public TreeSet<String> findTr(){
		TreeSet <String>trascrittori=new TreeSet<String>();
		Statement st=null;
		try{
			String query="SELECT usernameT FROM Trascrittore";
			st=c.createStatement();			
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next()){
				trascrittori.add(rs.getString("usernameT"));
			}
			rs.close();
			c.close();
			return trascrittori;
		}catch(Exception e){
			new Eccezioni(e);
			return null;
		} 
		
	}
	
	/**
	 * Find ac.
	 *
	 * @return the tree set
	 */
	public TreeSet<String> findAc(){
		TreeSet <String>acquisitori=new TreeSet<String>();
		Statement st=null;
		try{
			String query="SELECT usernameAc FROM Acquisitore";
			st=c.createStatement();			
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next()){
				acquisitori.add(rs.getString("usernameAc"));
			}
			rs.close();
			c.close();
			return acquisitori;
		}catch(Exception e){
			new Eccezioni(e);
			return null;
		} 
		
	}
	
	/**
	 * Find rev imm.
	 *
	 * @return the tree set
	 */
	public TreeSet<String> findRevImm(){
		TreeSet <String>revisori=new TreeSet<String>();
		Statement st=null;
		try{
			String query="SELECT usernameI FROM RevisoreI";
			st=c.createStatement();			
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next()){
				revisori.add(rs.getString("usernameI"));
			}
			rs.close();
			c.close();
			return revisori;
		}catch(Exception e){
			new Eccezioni(e);
			return null;
		} 
	}
	
	/**
	 * Find rev tr.
	 *
	 * @return the tree set
	 */
	public TreeSet<String> findRevTr(){
		TreeSet <String>revisori=new TreeSet<String>();
		Statement st=null;
		try{
			String query="SELECT usernameTr FROM RevisoreT";
			st=c.createStatement();			
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next()){
				revisori.add(rs.getString("usernameTr"));
			}
			rs.close();
			c.close();
			return revisori;
		}catch(Exception e){
			new Eccezioni(e);
			return null;
		} 
	}
	
	/**
	 * Delete utente.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	public boolean deleteUtente(String user){
		UtenteBase ut=getUtente(user);	
		
		if(ut instanceof UtenteAvanzato){
			try{
				String queryA="DELETE FROM UtenteAvanzato where usernameA=?";
				PreparedStatement pstA=c.prepareStatement(queryA);
				pstA.setString(1,user);
				pstA.execute();
				pstA.close();
				c.close();
				return true;			
			}
			catch(Exception e){
				new Eccezioni(e);
				return false;
			}
		}
		else{
			try{
				PreparedStatement pst=c.prepareStatement("DELETE FROM UTENTEBASE where username=?");
				pst.setString(1,user);				
				pst.execute();
				pst.close();
				c.close();
				return true;
			}
			catch(Exception e){
					new Eccezioni(e);
					return false;
				}
		}
	}
	
	/**
	 * Delete trascrittore.
	 *
	 * @param tr the tr
	 * @return true, if successful
	 */
	public boolean deleteTrascrittore(String tr){
		try{
			PreparedStatement pst=c.prepareStatement("DELETE FROM Trascrittore where usernameT=?");
			pst.setString(1,tr);
			pst.execute();
			pst.close();
			c.close();
			return true;			
			}catch(Exception e){
				new Eccezioni(e);
				return false;
			}
	}
	
	/**
	 * Delete acquisitore.
	 *
	 * @param ac the ac
	 * @return true, if successful
	 */
	public boolean deleteAcquisitore(String ac){
		try{
			PreparedStatement pstA=c.prepareStatement("DELETE FROM Acquisitore where usernameAc=?");
			pstA.setString(1,ac);
			pstA.execute();
			pstA.close();
			c.close();
			return true;			
			}catch(Exception e){
				new Eccezioni(e);
				return false;
			}
	}
	
	/**
	 * Delete revisore i.
	 *
	 * @param rev the rev
	 * @return true, if successful
	 */
	public boolean deleteRevisoreI(String rev){
		try{
			PreparedStatement pst=c.prepareStatement("DELETE FROM RevisoreI where usernameI=?");
			pst.setString(1,rev);
			pst.execute();
			pst.close();
			c.close();
			return true;			
			}catch(Exception e){
				new Eccezioni(e);
				return false;
			}
	}
	
	/**
	 * Delete revisore t.
	 *
	 * @param rev the rev
	 * @return true, if successful
	 */
	public boolean deleteRevisoreT(String rev){
		try{
			PreparedStatement pst=c.prepareStatement("DELETE FROM RevisoreT where usernameTr=?");
			pst.setString(1,rev);
			pst.execute();
			pst.close();
			c.close();
			return true;			
			}catch(Exception e){
				new Eccezioni(e);
				return false;
			}
	}

}


