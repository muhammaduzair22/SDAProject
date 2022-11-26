package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import BusinessLogic.*;
import Database.DBHandler;
public class Searchandbook extends JFrame {

	BookBusList bl=BookBusList.getInstance();
	
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField txtid;
    private JTable table_2;
	 JScrollPane scrollPane = new JScrollPane();

    JComboBox comboBox = new JComboBox();
    JComboBox comboBox_1 = new JComboBox();
    boolean printstatus=false;
    int bseat;
    int eseat;
    String bseats;
    String eseats;

    ArrayList<BookBus> arr=BookBusList.getInstance().getList();
	String component2;
	
	String  [][] data =new String [arr.size()][5];
	String col[]= {"Bus ID","Route","Fare","Time","Available Seats"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Searchandbook frame = new Searchandbook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}




	/**
	 * Create the frame.
	 */
	/**
		 * @wbp.parser.entrypoint
		 */
		
	public Searchandbook(Student s) {
		searchbook(s);
	}

	public void searchbook(Student s)
	{	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("University Bus MS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Heading", Font.BOLD, 50));
		lblNewLabel.setBounds(376, 10, 481, 63);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book Desired Seat");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(512, 74, 223, 39);
		contentPane.add(lblNewLabel_1);

		for(int i=0; i<arr.size(); i++)
    	{
    		for(int j=0; j<7; j++)
    		{
    			String id=String.valueOf(arr.get(i).getBusNumber());
    			String seats=String.valueOf(arr.get(i).gettotalseats());
    			data[i][0]=id;
    			data[i][1]=arr.get(i).getRoute();
    			data[i][2]=arr.get(i).getFare();
    			data[i][3]=arr.get(i).getTime();
    			data[i][4]=seats;
    		}
    	}
		table_1 = new JTable(data,col);
		

	 scrollPane.setBounds(40, 146, 1177, 380);
	 contentPane.add(scrollPane);
	
 	scrollPane.setViewportView(table_1);
	table_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
    table_1.setRowHeight(40);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				    table_1=new JTable();
				    contentPane.repaint();
				    table_1.repaint();

				    StudentDashboard sd=new StudentDashboard(s);
				    sd.setVisible(true);
					dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(1087, 611, 139, 39);
		contentPane.add(btnNewButton);
		
	    JLabel lblNewLabel_2 = new JLabel("Enter Bus ID");
	    lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    lblNewLabel_2.setBounds(40, 616, 139, 29);
	    contentPane.add(lblNewLabel_2);
	    
	    txtid = new JTextField();
	    txtid.setBounds(169, 614, 176, 31);
	    contentPane.add(txtid);
	    txtid.setColumns(10);
	    
	    JButton btnNewButton_2 = new JButton("Book");
	    btnNewButton_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    btnNewButton_2.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		
	    		if(txtid.getText().equals(""))
	    		{
	    			JOptionPane.showMessageDialog(contentPane, "Enter Valid Bus ID",
	    		               "Error",JOptionPane.ERROR_MESSAGE );
	    		}
	    		
	    		int i=0;
	    		int id=Integer.parseInt(txtid.getText());
				for(;i<arr.size();i++)
				{
					if(id==arr.get(i).getBusNumber())
					{
						break;
					}
				}				
				if(check_id()==true)
				{
					BookBusList.getInstance().getList().get(i).getBookedStudentsList().add(s);
					System.out.println("student:"+BookBusList.getInstance().getList().get(i).getBookedStudentsList().get(i).getName());
					
					double fare=Double.parseDouble(BookBusList.getInstance().getList().get(i).getFare());
					double amount=BookBusList.getInstance().getList().get(i).getBookedStudentsList().get(i).getWalletAmount()-fare;
					
					BookBusList.getInstance().getList().get(i).getBookedStudentsList().get(i).setWalletAmount(amount);
					DBHandler db=new DBHandler();
					db.connectDB();
					s.setWalletAmount(amount);
					db.updateStudent(s);
					
					update_seats(arr.get(i).getBusNumber());
				   StudentDashboard sd=new StudentDashboard(s);
					db.updateBookBus(BookBusList.getInstance().getList().get(i));

				   JOptionPane.showMessageDialog(contentPane, "Seat Booked Successfully!!");
				   sd.setVisible(true);
				   dispose();
				}
	    		else
				{
					JOptionPane.showMessageDialog(contentPane, "Bus ID not found",
				               "Error",JOptionPane.ERROR_MESSAGE );
				}
					
	    	}
	    });
	    btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    btnNewButton_2.setBounds(928, 611, 139, 39);
	    contentPane.add(btnNewButton_2);
	    
	   
		
	}
	boolean check_id()
	{
		
		boolean flag=false;
			for(int i=0; i<arr.size();i++)
			{
				int busid=Integer.parseInt(txtid.getText());
				if(busid==arr.get(i).getBusNumber())
				{
					return true;
				}
			}
		if(flag==false)
		{
				JOptionPane.showMessageDialog(contentPane, "Enter Valid Bus ID",
			               "Error",JOptionPane.ERROR_MESSAGE );
		}
		return flag;
	}
	void update_seats(int busid)
	{
		int bus=Integer.parseInt(txtid.getText());
			
					if(bl.updateseats(busid)==true)
					{
		    			for(int i=0; i<arr.size(); i++)
		    	    	{
		    	    		for(int j=0; j<7; j++)
		    	    		{
		    	    			String id=String.valueOf(arr.get(i).getBusNumber());
		    	    			String seats=String.valueOf(arr.get(i).gettotalseats());
		    	    			data[i][0]=id;
		    	    			data[i][1]=arr.get(i).getRoute();
		    	    			data[i][2]=arr.get(i).getFare();
		    	    			data[i][3]=arr.get(i).getTime();
		    	    			data[i][4]=seats;
		    	    	  		contentPane.repaint();

		    	    		}
		    	    	}
					}
					else
					{
						JOptionPane.showMessageDialog(contentPane, "Seats Not available",
					               "Error",JOptionPane.ERROR_MESSAGE );
					}
					
				
	  		contentPane.repaint();
			table_1 = new JTable(data,col);
			scrollPane.setViewportView(table_1);
			table_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		    table_1.setRowHeight(40);

			}
	
}
