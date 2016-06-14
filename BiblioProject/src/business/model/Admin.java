package business.model;

import javax.swing.JPasswordField;

// TODO: Auto-generated Javadoc
/**
 * The Class Admin.
 */
public class Admin {
	
	/** The admin id. */
	String adminId;
	
	/** The password. */
	JPasswordField password= null;
	
	/** The login status. */
	boolean loginStatus;
	
	/**
	 * Instantiates a new admin.
	 */
	public Admin(){		
	}	
	
	/**
	 * Instantiates a new admin.
	 *
	 * @param adminId the admin id
	 * @param psw the psw
	 */
	public Admin(String adminId,String psw){
		this.adminId=adminId;
		this.password=new JPasswordField(psw);
		this.loginStatus=true;
	}
	
	/**
	 * Gets the admin id.
	 *
	 * @return the admin id
	 */
	public String getAdminId() {
		return adminId;
	}
	
	/**
	 * Sets the admin id.
	 *
	 * @param adminId the new admin id
	 */
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public JPasswordField getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param psw the new password
	 */
	public void setPassword(String psw){
		this.password=new JPasswordField(psw);
	}
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public boolean getStatus(){
		return this.loginStatus;
	}
			
}
