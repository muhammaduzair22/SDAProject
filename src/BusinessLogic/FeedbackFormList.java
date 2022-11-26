package BusinessLogic;
import java.util.ArrayList;

public class FeedbackFormList {
 private ArrayList<FeedbackForm> list = new ArrayList<FeedbackForm>();

 //Singleton Applied
 	private static FeedbackFormList uniqueList;
 	private FeedbackFormList() {}
 	public static FeedbackFormList getInstance()
 	{
	 	if(uniqueList==null)
			uniqueList=new FeedbackFormList();
		return uniqueList;
 	}
 	public void save(FeedbackForm f)
 	{
 		list.add(f);
 	}
 	public ArrayList<FeedbackForm> GetList()
 	{
 		return list;
 	}
}
