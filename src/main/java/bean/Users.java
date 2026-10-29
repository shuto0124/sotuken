package bean;

public class Users implements java.io.Serializable {
	
	private int user_number;
	private String user_name;
	private String password;
	private String account_status;
	private Groups groups;
	
	public int getUserNumber() {
		return user_number;
	}

	public String getUserName() {
		return user_name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getAccountStatus() {
		return account_status;
	}
	
	public Groups getGroups() {
		return groups;
	}
	
	public void setUserNumber(int user_number) {
		this.user_number = user_number;
	}
	
	public void setUserName(String user_name) {
		this.user_name = user_name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setAccountStatus(String account_status) {
		this.account_status = account_status;
	}
	
	public void setGroups(Groups groups) {
		this.groups = groups;
	}

}