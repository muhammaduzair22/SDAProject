package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import BusinessLogic.*;
import Database.DBHandler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class AdminManageBus extends JFrame {
	private JTextField txtBusNumber;
	private JTextField txtToalSeats;
	private JTextField textRoute;
	private JTextField textFare;
	private JTextField textTime;
	private JTextField txtbusid;
	private JTextField RemoveBusNumber;
    JComboBox comboBox = new JComboBox();

  

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminManageBus frame = new AdminManageBus();
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
	public AdminManageBus() {
		 DBHandler db=new DBHandler();
		db.connectDB();
		getContentPane().setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBounds(0, 0, 1266, 683);
		getContentPane().add(contentPane);
		
		 comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));		    
		    comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seats","Route","Fare","Time"}));
		    comboBox.setSelectedIndex(0);		    
		    comboBox.setBounds(873, 271, 160, 39);
		    contentPane.add(comboBox);
		
		txtBusNumber = new JTextField();
		txtBusNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtBusNumber.setColumns(10);
		txtBusNumber.setBounds(246, 212, 160, 36);
		contentPane.add(txtBusNumber);
		
		txtToalSeats = new JTextField();
		txtToalSeats.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtToalSeats.setColumns(10);
		txtToalSeats.setBounds(246, 273, 160, 36);
		contentPane.add(txtToalSeats);
		
		textRoute = new JTextField();
		textRoute.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textRoute.setColumns(10);
		textRoute.setBounds(246, 341, 160, 36);
		contentPane.add(textRoute);
		
		textFare = new JTextField();
		textFare.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFare.setColumns(10);
		textFare.setBounds(246, 409, 160, 36);
		contentPane.add(textFare);
		
		textTime = new JTextField();
		textTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textTime.setColumns(10);
		textTime.setBounds(246, 486, 160, 36);
		contentPane.add(textTime);
		
		JLabel lblNumber = new JLabel("Bus Number:");
		lblNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNumber.setBounds(43, 212, 153, 27);
		contentPane.add(lblNumber);
		
		JLabel lblTotalSeats = new JLabel("Total Seats:");
		lblTotalSeats.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTotalSeats.setBounds(43, 277, 141, 23);
		contentPane.add(lblTotalSeats);
		
		JLabel lblRouteName = new JLabel("Route Name:");
		lblRouteName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRouteName.setBounds(43, 345, 153, 23);
		contentPane.add(lblRouteName);
		
		JLabel lblfare = new JLabel("Fare:");
		lblfare.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblfare.setBounds(43, 413, 181, 32);
		contentPane.add(lblfare);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTime.setBounds(43, 490, 141, 32);
		contentPane.add(lblTime);
		
		JLabel lblAddNewBus = new JLabel("Manage Buses");
		lblAddNewBus.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewBus.setFont(new Font("Sitka Heading", Font.BOLD, 40));
		lblAddNewBus.setBounds(377, 23, 396, 70);
		contentPane.add(lblAddNewBus);
		
		JButton btnNewButton = new JButton("Add Bus");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookBus b= new BookBus();
				b.setBusNumber(Integer.parseInt(txtBusNumber.getText()));
				b.settotalseats(Integer.parseInt(txtToalSeats.getText()));
				b.setRoute(textRoute.getText());
				b.setFare(textFare.getText());
				b.setTime(textTime.getText());
				BookBusList.getInstance().saveBus(b);
				
				db.addToBookBus(b);
				JOptionPane.showMessageDialog(contentPane, "Bus Added Sucessfully!" );

			}
		});
		btnNewButton.setBounds(246, 561, 160, 36);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Admin");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(1135, 152, 90, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblAddNewBus_2 = new JLabel("Add New Bus");
		lblAddNewBus_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewBus_2.setFont(new Font("Sitka Heading", Font.BOLD, 30));
		lblAddNewBus_2.setBounds(23, 127, 396, 50);
		contentPane.add(lblAddNewBus_2);
		
		JLabel lblAddNewBus_2_1 = new JLabel("Edit Bus");
		lblAddNewBus_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewBus_2_1.setFont(new Font("Sitka Heading", Font.BOLD, 30));
		lblAddNewBus_2_1.setBounds(682, 141, 351, 36);
		contentPane.add(lblAddNewBus_2_1);
		
		JLabel lblNumber_1 = new JLabel("Bus Number:");
		lblNumber_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNumber_1.setBounds(691, 211, 160, 32);
		contentPane.add(lblNumber_1);
		
		txtbusid = new JTextField();
		txtbusid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtbusid.setColumns(10);
		txtbusid.setBounds(873, 212, 160, 36);
		contentPane.add(txtbusid);
		
		JLabel lblFeilds = new JLabel("Select Field:");
		lblFeilds.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFeilds.setBounds(691, 271, 172, 39);
		contentPane.add(lblFeilds);
		
		JLabel lblfare_1 = new JLabel("Bus Number:");
		lblfare_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblfare_1.setBounds(691, 474, 172, 36);
		contentPane.add(lblfare_1);
		
		RemoveBusNumber = new JTextField();
		RemoveBusNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RemoveBusNumber.setColumns(10);
		RemoveBusNumber.setBounds(873, 477, 160, 36);
		contentPane.add(RemoveBusNumber);
		
		JButton btnEditBus = new JButton("Delete");
		btnEditBus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEditBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flg=false;
				for (int i=0; i<BookBusList.getInstance().getList().size();i++)
				{
					if(BookBusList.getInstance().getList().get(i).getBusNumber()==Integer.parseInt(RemoveBusNumber.getText()))
						{
						flg=true;
						db.DeleteBookBus(BookBusList.getInstance().getList().get(i));
						BookBusList.getInstance().getList().remove(i);	
						}
					
				}
				if(flg==false)
				{
					JOptionPane.showMessageDialog(contentPane, "Enter Valid Bus ID",
	    		               "Error",JOptionPane.ERROR_MESSAGE );
				}
				else if(flg==true)
				{
					JOptionPane.showMessageDialog(contentPane, "Bus removed" );
				}
			}
		});
		btnEditBus.setBounds(873, 548, 160, 36);
		contentPane.add(btnEditBus);
		
		JLabel lblAddNewBus_2_1_1 = new JLabel("Remove Bus");
		lblAddNewBus_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewBus_2_1_1.setFont(new Font("Sitka Heading", Font.BOLD, 30));
		lblAddNewBus_2_1_1.setBounds(682, 428, 351, 36);
		contentPane.add(lblAddNewBus_2_1_1);
		
		JButton btnEditBus_1 = new JButton("Edit Bus");
		btnEditBus_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEditBus_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String choice=comboBox.getSelectedItem().toString();
				int busid=Integer.parseInt(txtbusid.getText());
				BookBusList.getInstance();
				
				int i=0;
				for (; i<BookBusList.getInstance().getList().size();i++)
				{
					if(BookBusList.getInstance().getList().get(i).getBusNumber()==busid)
						{
							break;
						}
					
				}
				if(choice.equals("Seats"))
				{
					String seats="";
					seats=JOptionPane.showInputDialog(contentPane,"Enter new Seats");
					BookBusList.getInstance().getList().get(i).settotalseats(Integer.parseInt(seats));
					db.updateBookBus(BookBusList.getInstance().getList().get(i));
					JOptionPane.showMessageDialog(contentPane, "Seat Updated" );

					
				}
				else if(choice.equals("Route"))
				{
					String route="";
					route=JOptionPane.showInputDialog(contentPane,"Enter new Route");
					BookBusList.getInstance().getList().get(i).setRoute(route);
					db.updateBookBus(BookBusList.getInstance().getList().get(i));
					JOptionPane.showMessageDialog(contentPane, "Route Updated" );


				}
				else if(choice.equals("Fare"))
				{
					String fare="";
					fare=JOptionPane.showInputDialog(contentPane,"Enter new Fare");
					BookBusList.getInstance().getList().get(i).setFare(fare);
					db.updateBookBus(BookBusList.getInstance().getList().get(i));
					JOptionPane.showMessageDialog(contentPane, "Fare Updated" );


				}
				else if(choice.equals("Time"))
				{
					String time="";
					time=JOptionPane.showInputDialog(contentPane,"Enter new Time");
					BookBusList.getInstance().getList().get(i).setTime(time);
					db.updateBookBus(BookBusList.getInstance().getList().get(i));
					JOptionPane.showMessageDialog(contentPane, "Time Updated" );


				}

			}
		});
		btnEditBus_1.setBounds(873, 338, 160, 36);
		contentPane.add(btnEditBus_1);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminDashBoard ad=new AdminDashBoard();
				ad.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(1075, 612, 160, 39);
		contentPane.add(btnNewButton_1);
	}
}
