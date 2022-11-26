package BusinessLogic;

public class MaintenanceRequestForm extends Form {
	
	private int EmployeeId;
	private String MaintenceReuest;
	MaintenanceRequestFormList formList= MaintenanceRequestFormList.getInstance();
	
	public MaintenanceRequestForm(){}
	public MaintenanceRequestForm(String driverName,int employeeId,String phoneNumber, String routeName, int busRegNo, String date, String time,
			  String maintenceReuest) {
		super(phoneNumber, routeName, busRegNo, date, time, driverName);
		EmployeeId = employeeId;
		MaintenceReuest = maintenceReuest;
	}

	public int getEmployeeId() {
		return EmployeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}
	public String getMaintenceReuest() {
		return MaintenceReuest;
	}
	public void setMaintenceReuest(String maintenceReuest) {
		MaintenceReuest = maintenceReuest;
	}
	public void save(MaintenanceRequestForm f)
	{
		formList.save(f);
	}

	@Override
	public String toString() {
		return "MaintenanceRequestForm [EmployeeId=" + EmployeeId + ", MaintenceReuest=" + MaintenceReuest
				+ ", formList=" + formList + "]";
	}
	
	 
}
