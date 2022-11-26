package BusinessLogic;
import java.util.ArrayList;

public class DriverList {
	
	private ArrayList<Driver>  DriverList =new ArrayList<Driver>();
	
	//Singleton Applied
	 private static DriverList uniqueList;
	 private DriverList() {}
	 public static DriverList getInstance()
	 {
		 	if(uniqueList==null)
				uniqueList=new DriverList();
			return uniqueList;
	 }
	 
	 public ArrayList<Driver> getList()
		{
			return DriverList;
		}
	 
	 public Driver getDriver(int EmpNum)
	  {
		  for(Driver d:DriverList)
		  {
			  if(d.getEmpID()==EmpNum)
				  return d;
		  }
		  return null;
	  }
	  public void saveDriver(Driver d)
	  {
		 DriverList.add(d);
	  }
	  public void deleteDriver(Driver d)
	  {
		  DriverList.remove(d);
	  }
	  public int login(String username, String password)
		{
			for(Driver s:DriverList)
			{
				if(s.getUsername().equals(username))
				{ 
					if(s.getPassword().equals(password))
					{
						return 2;//successfull login
					}
				else return 1;// password incorrect
				}
			}
			return 0;//wrong username
		}
	  
}
