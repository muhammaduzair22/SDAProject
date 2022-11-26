package BusinessLogic;
import java.util.ArrayList;

public class RegisteredStudentsList {
	 
	private ArrayList<Student> StudentList= new ArrayList<Student>();
	private static RegisteredStudentsList uniqueList;
 	private RegisteredStudentsList() {}
 	public static RegisteredStudentsList getInstance()
 	{
	 	if(uniqueList==null)
			uniqueList=new RegisteredStudentsList();
		return uniqueList;
 	}
	
	public ArrayList<Student> getList()
	{
		return StudentList;
	}

	public void setList(ArrayList<Student> arr)
	{
		 StudentList=arr;
	}
	
	public int login(String username, String password)
	{
		for(int i=0;i<StudentList.size();i++)
		{
			if(StudentList.get(i).getUserName().equals(username))
			{ 
				if(StudentList.get(i).getPassword().equals(password))
				{
					return 2;//successfull login
				}
				else 
				{
						return 1;// password incorrect
				}
			}
		}
		return 0;//wrong username
	}
	private boolean signup(Student s)
	{   
		for(Student stu:StudentList)
		{
			if(stu.getRollNumber().equals(s.getRollNumber()))
			{ 
				return false;
			}
		}
		return true;
	}
	
	public boolean save(Student s)
	{
		if(signup(s))
		{
			StudentList.add(s);
			return true;
		}
		else 
			{
			  return false;
			}
	}
	
	public int getIndex(Student s) //return -1 if no student is found 
	{
		for (int i=0;i<StudentList.size();i++)
		{
			if(StudentList.get(i).getRollNumber().equals(s.getRollNumber()))
				return i;
		}
		return -1;
	}
	public Student getStudent(String username)
	{
		for(int i=0;i<StudentList.size();i++)
		{
			if(StudentList.get(i).getUserName().equals(username))
				return StudentList.get(i);
		}
		return null;
	}
	
}
