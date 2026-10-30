package bean;

public class Users implements java.io.Serializable {
	
	private int userNumber;
	private String userName;
	private String password;
	private String accountStatus;
	private Groups groups;
	
	public int getUserNumber() {
		return userNumber;
	}

	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getAccountStatus() {
		return accountStatus;
	}
	
	public Groups getGroups() {
		return groups;
	}
	
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	public void setGroups(Groups groups) {
		this.groups = groups;
	}

}