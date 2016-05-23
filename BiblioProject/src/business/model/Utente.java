package business.model;

import javax.swing.JPasswordField;

public interface Utente {

public String getUserId();

public void setUserId(String id);

public String getNome();

public void setNome(String nome);

public String getCognome();

public void setCognome(String cognome);

public JPasswordField getPassword();

public void setPassword(String psw);

public boolean getStatus();

public void changeStatus();

public String getDataI();

}
