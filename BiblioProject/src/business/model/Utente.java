package business.model;

import javax.swing.JPasswordField;

// TODO: Auto-generated Javadoc
/**
 * The Interface Utente.
 */
public interface Utente {

/**
 * Gets the user id.
 *
 * @return the user id
 */
public String getUserId();

/**
 * Sets the user id.
 *
 * @param id the new user id
 */
public void setUserId(String id);

/**
 * Gets the nome.
 *
 * @return the nome
 */
public String getNome();

/**
 * Sets the nome.
 *
 * @param nome the new nome
 */
public void setNome(String nome);

/**
 * Gets the cognome.
 *
 * @return the cognome
 */
public String getCognome();

/**
 * Sets the cognome.
 *
 * @param cognome the new cognome
 */
public void setCognome(String cognome);

/**
 * Gets the password.
 *
 * @return the password
 */
public JPasswordField getPassword();

/**
 * Sets the password.
 *
 * @param psw the new password
 */
public void setPassword(String psw);

/**
 * Gets the status.
 *
 * @return the status
 */
public boolean getStatus();

/**
 * Change status.
 */
public void changeStatus();

/**
 * Gets the data i.
 *
 * @return the data i
 */
public String getDataI();

}
