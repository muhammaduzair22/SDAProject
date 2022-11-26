package BusinessLogic;

public class Form {

	protected String PhoneNumber;
	protected String RouteName;
	protected int BusRegNo;
	protected String Date;
	protected String Time;
	protected String DriverName;
	
	public Form() {}
	
	public Form(String phoneNumber, String routeName, int busRegNo, String date, String time, String driverName) {
		PhoneNumber = phoneNumber;
		RouteName = routeName;
		BusRegNo = busRegNo;
		Date = date;
		Time = time;
		DriverName = driverName;
	}
	
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getRouteName() {
		return RouteName;
	}
	public void setRouteName(String routeName) {
		RouteName = routeName;
	}
	public int getBusRegNo() {
		return BusRegNo;
	}
	public void setBusRegNo(int busRegNo) {
		BusRegNo = busRegNo;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getDriverName() {
		return DriverName;
	}
	public void setDriverName(String driverName) {
		DriverName = driverName;
	}
	
	
	
}
