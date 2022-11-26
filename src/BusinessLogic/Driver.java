package BusinessLogic;

public class Driver {
	 private String Name;
	 private int EmpID;
	 private int salary;
	 private String username;
	 private String password;

	 
	public Driver(String name, int empID, int salary, String username, String password) {
		Name = name;
		EmpID = empID;
		this.salary = salary;
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getEmpID() {
		return EmpID;
	}
	public void setEmpID(int empID) {
		EmpID = empID;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	} 
	 
	 
}
