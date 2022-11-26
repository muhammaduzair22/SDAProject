package BusinessLogic;

public class FeedbackForm extends Form {

	private String StudentName;
	private String RollNumber;
	private String feedback;
	FeedbackFormList formList= FeedbackFormList.getInstance();
	
	
	
	
	public FeedbackForm(){}

	public FeedbackForm(String studentName,String rollNumber, String phoneNumber, String routeName, int busRegNo,String driverName, String date, String time, 
			 String feedback) {
		super(phoneNumber, routeName, busRegNo, date, time, driverName);
		StudentName = studentName;
		RollNumber = rollNumber;
		this.feedback = feedback;
	}


	public String getStudentName() {
		return StudentName;
	}


	public void setStudentName(String studentName) {
		StudentName = studentName;
	}


	public String getRollNumber() {
		return RollNumber;
	}


	public void setRollNumber(String rollNumber) {
		RollNumber = rollNumber;
	}


	public String getFeedback() {
		return feedback;
	}


	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}


	public void saveFeedback(FeedbackForm f)
	{
		formList.save(f);
	}
	
	 
	 
}
