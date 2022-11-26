package BusinessLogic;

public class Student {
	private String RollNumber;
	private String Name;
	private String PhoneNumber;
	private String UserName;
	private String Password;
	private double walletAmount;
	
	
public Student(String rollNumber, String name, String phoneNumber, String userName, String password,double amount) {
		
		this.RollNumber = rollNumber;
		this.Name = name;
		this.PhoneNumber = phoneNumber;
		this.UserName = userName;
		this.Password = password;
		this.walletAmount=amount;
	}
	

	public String getRollNumber() {
		return RollNumber;
	}
	public void setRollNumber(String rollNumber) {
		RollNumber = rollNumber;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
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
	
	public void BookSeat(int reg)
	{
		
	}
	
	public void SearchBus()
	{
		
	}
	public double getWalletAmount() {
		return walletAmount;
	}
	public void setWalletAmount(double walletAmount) {
		this.walletAmount = walletAmount;
	}
}
