package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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

import BusinessLogic.BookBus;
import BusinessLogic.BookBusList;
import Database.DBHandler;

public class Viewbusdetails extends JFrame {


	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
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
	DBHandler db=new DBHandler();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viewbusdetails frame = new Viewbusdetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Viewbusdetails() {
		view();
	}
	
	public void view()
	{
		db.connectDB();
		BookBusList.getInstance().setbus(db.ReadBookBus(BookBusList.getInstance().getList()));
		String  [][] data =new String [BookBusList.getInstance().getList().size()][5];
		String col[]= {"Bus ID","Route","Fare","Time","Available Seats"};
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
		
		JLabel lblNewLabel_1 = new JLabel("Bus Details");
		lblNewLabel_1.setFont(new Font("Sitka Heading", Font.BOLD, 30));
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

				AdminDashBoard ad=new AdminDashBoard();
				ad.setVisible(true);
				dispose();
				    
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(1087, 611, 139, 39);
		contentPane.add(btnNewButton);
	    
	   
		
	}
	

}
