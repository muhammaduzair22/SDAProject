package BusinessLogic;
import java.util.ArrayList;

public class BookBusList {
	
 private static ArrayList<BookBus> BookBusList= new ArrayList<BookBus>();

 //Singleton Applied
 private static  BookBusList uniqueList;
 public BookBusList() {
	
 }
 public static  BookBusList getInstance()
 {
	 	if(uniqueList==null)
			uniqueList=new BookBusList();
		return uniqueList;
	}

 public BookBus getBus(int regnum)
  {
	  for(BookBus b:BookBusList)
	  {
		  if(b.getBusNumber()==regnum)
			  return b;
	  }
	  return null;
  }
 public void  setbus(ArrayList<BookBus> BookBusList)
 {
	 this.BookBusList=BookBusList;
 }
  public void saveBus(BookBus b)
  {
	 BookBusList.add(b);
  }
  public void deleteBus(BookBus b)
  {
	  BookBusList.remove(b);
  }
  public ArrayList<BookBus> returnlist()
  {
	  return BookBusList;
  }
  public boolean updateseats(int busid)
  {
	  for(int i=0; i<BookBusList.size();i++)
		{
			if(busid==(BookBusList.get(i).getBusNumber()))
			{
				if(BookBusList.get(i).gettotalseats()!=0)
				{
					int seats=BookBusList.get(i).gettotalseats();
					seats--;
					BookBusList.get(i).settotalseats(seats);					
					return true;
				}
				else
				{
					return false;	
				}
				
			}
		}
	return false;	
  }
  
  public void data()
  {
	  BookBusList.add(new BookBus(1,30,"Bahria","500","6:00am"));
	  BookBusList.add(new BookBus(2,30,"DHA","600","6:00am"));
	  BookBusList.add(new BookBus(3,30,"G11","200","5:00pm"));
	  BookBusList.add(new BookBus(4,30,"G10","100","5:00pm"));
	  BookBusList.add(new BookBus(5,30,"F10","300","5:00pm"));
	  BookBusList.add(new BookBus(6,30,"F11","200","6:00am"));
	  BookBusList.add(new BookBus(7,30,"F9","400","5:00pm"));
	  BookBusList.add(new BookBus(8,30,"H9","300","6:00am"));
	  BookBusList.add(new BookBus(9,30,"G13","200","6:00am"));
	  BookBusList.add(new BookBus(10,30,"H11","50","5:00pm"));
	  BookBusList.add(new BookBus(11,30,"G8","450","6:00am"));
	  BookBusList.add(new BookBus(12,30,"G15","350","6:00am"));
	  BookBusList.add(new BookBus(13,30,"I8","500","6:00am"));
	  BookBusList.add(new BookBus(14,30,"I9","200","6:00am"));
	  BookBusList.add(new BookBus(15,30,"F7","600","6:00am"));
  }
  public ArrayList<BookBus> getList()
  {
	  return BookBusList;
  }
  public ArrayList<Student> getBookedStudentList(int i)
  {
	  return BookBusList.get(i).getBookedStudentsList();
  }
  
}