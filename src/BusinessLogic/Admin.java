package BusinessLogic;

public class Admin {
	 private String UserName;
	 private String Password;
	 
	 
	 
	public Admin(String userName, String password) {
		UserName = userName;
		Password = password;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	 
	 
}
