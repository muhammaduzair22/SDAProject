package Database;

import java.util.ArrayList;
import BusinessLogic.*;
import java.sql.*;


//import com.mysql.jdbc.Statement;


public class DBHandler {

	Connection con=null;
	

	public void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sdaproject","root","");
			if(con == null) {
			System.out.println("DB connection failed");}
			else
			System.out.println("DB connection successful");

			}
			catch(Exception e) {
			System.out.println("exception: "+e);

			}
		
	}

	public void addToStudent(Student st) {
		String sql ="INSERT INTO student (RollNumber, Name, PhoneNumber,Username,Password,Amount) VALUES (?, ?, ?, ?, ?, ?)";

		java.sql.PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1,st.getRollNumber());
			statement.setString(2,st.getName());
			statement.setString(3,st.getPhoneNumber());
			statement.setString(4,st.getUserName());
			statement.setString(5,st.getPassword());
			statement.setDouble(6,st.getWalletAmount());
			
			int rowsInserted = statement.executeUpdate();
			
					if (rowsInserted>0) {System.out.println("A new student was inserted successfully!");
					}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		
		String sql ="UPDATE student SET Name=?, PhoneNumber=?, Username=?, Password=?, Amount=? WHERE RollNumber=?";
			java.sql.PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
		
			statement.setString(1,s.getName());
			statement.setString(2,s.getPhoneNumber());
			statement.setString(3, s.getUserName());
			statement.setString(4, s.getPassword());
			statement.setDouble(5,s.getWalletAmount());
			statement.setString(6, s.getRollNumber());
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated>0) {System.out.println("An existing student was updated successfully!");}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	public void DeleteStudent(Student s) {
		String sql ="DELETE FROM students WHERE RollNumber=?";
	    PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1,s.getRollNumber());
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted >0) {System.out.println("A student was deleted successfully!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Student> ReadStudents(ArrayList<Student> Students) {
		
		Statement stmt;
		try {
		stmt =con.createStatement();
		String sql="Select * from student ";
		ResultSet rs= stmt.executeQuery(sql);
		while(rs.next()) {
			Student s=new Student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6));
			Students.add(s);
		}
		con.close();
		}

		catch (SQLException e) {

		System.out.println("exception: "+e);
		}
		return Students;
	}
public double ReadWalletAmount(Student stu) {
		double amount=0;	
		Statement statement;
	try {
	statement =con.createStatement();
	String sql="Select Amount from student where RollNumber="+stu.getRollNumber();
	ResultSet rs= statement.executeQuery(sql);
	amount=rs.getDouble(6);	
	con.close();
	}
	catch (SQLException e) {
	System.out.println("exception: "+e);
	}
	return amount;
	}

public double ReadWalletAmount2(Student stu) {

double d=0;
	Statement stmt;
	try {
	stmt =con.createStatement();
	//String sql="Select * from student ";
	String sql2="Select Amount from student where RollNumber="+stu.getRollNumber();

	ResultSet rs= stmt.executeQuery(sql2);
	d=rs.getDouble("Amount");
	System.out.println(d);

	con.close();
	}

	catch (SQLException e) {

	System.out.println("exception: "+e);
	}
	return d;
}

	
	public void addFeedback(FeedbackForm f) {
		String sql ="INSERT INTO Feedback (StudentName, RollNumber,PhoneNumber,Route,BusRegNo,DriverName,Date,Time,Feedback) VALUES (?, ?, ?, ?, ?, ?, ? ,?, ?)";

		java.sql.PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1,f.getStudentName());
			statement.setString(2,f.getRollNumber());
			statement.setString(3,f.getPhoneNumber());
			statement.setString(4,f.getRouteName());
			statement.setInt(5,f.getBusRegNo());
			statement.setString(6,f.getDriverName());
			statement.setString(7,f.getDate());
			statement.setString(8,f.getTime());
			statement.setString(9,f.getFeedback());
			
			
			int rowsInserted = statement.executeUpdate();
			
					if (rowsInserted>0) {System.out.println("A new Feedback was inserted successfully!");
					}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
       public ArrayList<FeedbackForm> ReadFeedbacks(ArrayList<FeedbackForm> Feedbacks) {
		
		CallableStatement stmt;
		try {
		stmt = (CallableStatement) con.createStatement();
		String sql="Select * from Feedback ";
		ResultSet rs= stmt.executeQuery(sql);
		while(rs.next()) {
			FeedbackForm f=new FeedbackForm(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
		}
		con.close();
		}

		catch (SQLException e) {

		System.out.println("exception: "+e);
		}
		return Feedbacks;
	}
       
       public void addMaintainanceReq(MaintenanceRequestForm req) {
   		String sql ="INSERT INTO MaintenanceRequests (DriverName,EmployeeId,PhoneNumber,RouteName,BusRegNo,Date,Time,MaintenanceRequest) VALUES (?, ?, ?, ?, ?, ?, ? ,?)";

   		java.sql.PreparedStatement statement;
   		try {
   			statement = con.prepareStatement(sql);
   			statement.setString(1,req.getDriverName());
   			statement.setInt(2,req.getEmployeeId());
   			statement.setString(3,req.getPhoneNumber());
   			statement.setString(4,req.getRouteName());
   			statement.setInt(5,req.getBusRegNo());
   			statement.setString(6,req.getDate());
   			statement.setString(7,req.getTime());
   			statement.setString(8,req.getMaintenceReuest());
 
   			
   			
   			int rowsInserted = statement.executeUpdate();
   			
   					if (rowsInserted>0) {System.out.println("A new Feedback was inserted successfully!");
   					}
   		} catch (SQLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   	}
       
       public ArrayList<MaintenanceRequestForm> ReadMaintenanceRequests(ArrayList<MaintenanceRequestForm> Requests) {
   		
   		CallableStatement stmt;
   		try {
   		stmt = (CallableStatement) con.createStatement();
   		String sql="Select * from MaintenanceRequests ";
   		ResultSet rs= stmt.executeQuery(sql);
   		while(rs.next()) {
   			MaintenanceRequestForm req=new MaintenanceRequestForm(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6),rs.getString(7), rs.getString(8));
   		}
   		con.close();
   		}

   		catch (SQLException e) {

   		System.out.println("exception: "+e);
   		}
		return Requests;
   	} 
       
       public void addToBookBus(BookBus b) {
   		String sql ="INSERT INTO BookBus (BusNumber, TotalSeats, Route,Fare,Time) VALUES (?, ?, ?, ?, ?)";

   		java.sql.PreparedStatement statement;
   		try {
   			
   			statement = con.prepareStatement(sql);
   			statement.setInt(1,b.getBusNumber());
   			statement.setInt(2,b.gettotalseats());
   			statement.setString(3,b.getRoute());
   			statement.setString(4,b.getFare());
   			statement.setString(5,b.getTime());
   			
   			int rowsInserted = statement.executeUpdate();
   			
   					if (rowsInserted>0) {System.out.println("A new bus was inserted successfully!");
   					}
   		} catch (SQLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   	}  
       
       public void DeleteBookBus(BookBus b) {
   		String sql ="DELETE FROM BookBus WHERE BusNumber=?";
   	    PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			statement.setInt(1,b.getBusNumber());
	   		int rowsDeleted = statement.executeUpdate();
	   		if (rowsDeleted >0) {System.out.println("A Bus was deleted successfully!");
	   		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		
   	} 
       
       public void updateBookBus(BookBus b) {
   		// TODO Auto-generated method stub
   		
   		String sql ="UPDATE BookBus SET TotalSeats=?, Route=?, fare=? WHERE BusNumber=?";
   			java.sql.PreparedStatement statement;
   		try {
   			statement = con.prepareStatement(sql);
   		 System.out.println(b.gettotalseats());
   			statement.setInt(1,b.gettotalseats());
   			statement.setString(2,b.getRoute());
   			statement.setString(3, b.getFare());
   			statement.setInt(4, b.getBusNumber());

   		
   			int rowsUpdated = statement.executeUpdate();
   			if (rowsUpdated>0) {System.out.println("An existing bus was updated successfully!");}
   		} catch (SQLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   				
   	} 
       
       public ArrayList<BookBus> ReadBookBus(ArrayList<BookBus> book) {
      		book=new ArrayList<BookBus>();
      		Statement stmt;
      		try {
      		stmt =con.createStatement();
      		String sql="Select * from BookBus ";
      		ResultSet rs= stmt.executeQuery(sql);
      		while(rs.next()) {
      			BookBus b=new BookBus(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5));
      			book.add(b);
      		}
      		con.close();
      		}

      		catch (SQLException e) {

      		System.out.println("exception: "+e);
      		}
			return book;
      	}     
       
}
