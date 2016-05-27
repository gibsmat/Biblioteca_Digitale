package business.implementation;

import java.sql.*;
import java.util.Calendar;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.JPasswordField;
import business.model.*;
import javax.swing.JOptionPane;

public class UserManagement{
	Connection c=new DbConnection().dbConnector();;
	
	public UserManagement(){	
	}
	
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
				return true;
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Errore. Registrazione non effettuata.");
				return false;
					}
		}
		else{
			JOptionPane.showMessageDialog(null, "Username già presente.");
			return false;
		}
		}
	
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
				return true;
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Errore. Registrazione non effettuata.");
				return false;
					}
		}else{
			JOptionPane.showMessageDialog(null, "Username già presente.");
			return false;
		}
	}
	
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
				return true;
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Errore. Registrazione non effettuata.");
				return false;
					}
		}else{
			JOptionPane.showMessageDialog(null, "Username già presente.");
			return false;
		}
	}
	
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
				return true;
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,e);
				return false;
			}
		}else{
			return false;
		}
	}
	
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
				return true;
			}
			catch(Exception e){
				return false;
			}
		}else{
			return false;
		}
	}
	
	public boolean nuovoRevisoreT(String id,String nome,String cognome,String psw){
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
				return true;
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Errore. Registrazione non effettuata.");
				return false;
					}
		}else{
			JOptionPane.showMessageDialog(null, "Username già presente.");
			return false;
		}
	}
	
	public Utente getUtente(String username,JPasswordField psw){
		String nome, cognome,dataI;
		PreparedStatement pst=null;
		ResultSet rs=null;
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
							return new Trascrittore(nome,cognome,username,psw.getText(),true);
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
									return new Acquisitore(nome,cognome,username,psw.getText(),true);
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
													return new RevisoreTrascrizioni(nome,cognome,username,psw.getText(),true);
												}
												else{
													return null;													
													}				
												}catch(Exception e1){
												JOptionPane.showMessageDialog(null, "Revisore trascrizioni inesistente");
												return null;
												}
											
											}				
										}catch(Exception e1){
										JOptionPane.showMessageDialog(null, "Revisore immagini inesistente");
										return null;
										}

									
									}				
								}catch(Exception e1){
								JOptionPane.showMessageDialog(null, "acquisitore inesistente");
								return null;
								}

							
							}				
						}catch(Exception e1){
						JOptionPane.showMessageDialog(null, "trascrittore inesistente");
						return null;
						}

					}				
				}catch(Exception e1){
				JOptionPane.showMessageDialog(null, "utente avanzato inesistente");
				return null;
				}
			}
		}catch(Exception e){
				JOptionPane.showMessageDialog(null, "utente base inesistente.");
				return null;
			}

	}
	
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
					return new UtenteAvanzato(nome,cognome,username,password,dataI,true);
				}
				else{
					JOptionPane.showMessageDialog(null, "Username o password non validi.");
					return null;
				}				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "utente avanzato inesistente");
				return null;
			}
			}
		}catch(Exception e){
				JOptionPane.showMessageDialog(null, "utente base inesistente.");
				return null;
			}

	}
	
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
				return false;
			}
			pstC.close();
			rs.close();	
			return true; 
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
		
	}
	
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
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		} 
		try{
			stA=c.createStatement();
			ResultSet rsA=stA.executeQuery("SELECT usernameA FROM UtenteAvanzato");
			while(rsA.next()){
				utentiBase.add(rsA.getString("usernameA"));
			}
			rsA.close();
			return utentiBase;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		} 
	}
	
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
			return trascrittori;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		} 
		
	}
	
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
			return acquisitori;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		} 
		
	}
	
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
			return revisori;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		} 
	}
	
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
			return revisori;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		} 
	}
	
	public boolean deleteUtente(String user){
		UtenteBase ut=getUtente(user);		
		if(ut instanceof UtenteAvanzato){
			try{
			String queryA="DELETE FROM UtenteAvanzato where usernameA=?";
			PreparedStatement pstA=c.prepareStatement(queryA);
			pstA.setString(1,user);
			pstA.execute();
			return true;			
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, e);
				return false;
			}
		}else{
			try{
				PreparedStatement pst=c.prepareStatement("DELETE FROM UTENTEBASE where username=?");
				pst.setString(1,user);				
				pst.execute();
				return true;
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,"Accipicchia");
					return false;
				}
		}
	}
	
	public boolean deleteTrascrittore(String tr){
		try{
			PreparedStatement pst=c.prepareStatement("DELETE FROM Trascrittore where usernameT=?");
			pst.setString(1,tr);
			pst.execute();
			return true;			
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, e);
				return false;
			}
	}
	
	public boolean deleteAcquisitore(String ac){
		try{
			PreparedStatement pstA=c.prepareStatement("DELETE FROM Acquisitore where usernameAc=?");
			pstA.setString(1,ac);
			pstA.execute();
			return true;			
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, e);
				return false;
			}
	}
	
	public boolean deleteRevisoreI(String rev){
		try{
			PreparedStatement pst=c.prepareStatement("DELETE FROM RevisoreI where usernameI=?");
			pst.setString(1,rev);
			pst.execute();
			return true;			
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, e);
				return false;
			}
	}
	
	public boolean deleteRevisoreT(String rev){
		try{
			PreparedStatement pst=c.prepareStatement("DELETE FROM RevisoreT where usernameTr=?");
			pst.setString(1,rev);
			pst.execute();
			return true;			
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, e);
				return false;
			}
	}

}


