package BusinessLogic;
import java.util.ArrayList;

public class BookBus {
 
	private int BusNumber;
	private int totalseats; 
	private String route;
	private String fare;
	private String time;
	private ArrayList<Student> BookedStudentsList=new ArrayList<Student>();
	
	public BookBus() {
	}
	
	public BookBus(int busNumber, int totalseats, String route, String fare, String time) {
		BusNumber = busNumber;
		this.totalseats = totalseats;
		this.route = route;
		this.fare = fare;
		this.time = time;
	}



	public int getBusNumber() {
		return BusNumber;
	}
	public void setBusNumber(int BusNumber) {
		this.BusNumber = BusNumber;
	}
	public int gettotalseats() {
		return totalseats;
	}
	public void settotalseats(int totalseats) {
		this.totalseats = totalseats;
	}
	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}
  
	public ArrayList<Student> getBookedStudentsList() {
		return BookedStudentsList;
	}
	public void setBookedStudentsList(ArrayList<Student> bookedStudentsList) {
		BookedStudentsList = bookedStudentsList;
	}
	public void bookStudent(Student s)
	{
		BookedStudentsList.add(s);
	}

	public String getFare() {
		return fare;
	}

	public void setFare(String fare) {
		this.fare = fare;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
