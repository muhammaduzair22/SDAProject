package BusinessLogic;
import java.util.ArrayList;

public class MaintenanceRequestFormList {
	 private ArrayList<MaintenanceRequestForm> list = new ArrayList<MaintenanceRequestForm>();

	 //Singleton Applied
	 	private static MaintenanceRequestFormList uniqueList;
	 	private MaintenanceRequestFormList() {}
	 	public static MaintenanceRequestFormList getInstance()
	 	{
		 	if(uniqueList==null)
				uniqueList=new MaintenanceRequestFormList();
			return uniqueList;
	 	}
	 	public void save(MaintenanceRequestForm f)
	 	{
	 		list.add(f);
	 		System.out.println(f.toString());
	 	}
	 	
	 	public ArrayList<MaintenanceRequestForm> GetList()
		{
			return list;
		}
}
