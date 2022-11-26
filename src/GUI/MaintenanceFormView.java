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
import BusinessLogic.*;
public class MaintenanceFormView extends JFrame {

	
	
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
 
  //  ArrayList<BookBus> arr=bl.returnlist();
	
	ArrayList<MaintenanceRequestForm> arr= new ArrayList<MaintenanceRequestForm>();

//	String data [][] =new String [arr.size()][9];
	String col[]= {"Driver Name","Employee Id","Phone Number","Route Name","Bus Registration Number","Date","Time","Maintenance Request"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					MaintenanceFormView frame = new MaintenanceFormView();
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
	public MaintenanceFormView() {
		searchbook();
		
	}
	public void searchbook()
	{	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1279, 720);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("University Bus MS");
		lblNewLabel.setFont(new Font("Sitka Heading", Font.BOLD, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(282, 10, 576, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Maintenance Requests");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(292, 63, 566, 38);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(36, 112, 1184, 418);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		arr=MaintenanceRequestFormList.getInstance().GetList();
		String data [][] =new String [arr.size()][8];
		
		for(int i=0; i<arr.size(); i++)
		{
			for(int j=0; j<8; j++)
			{
				data[i][0]=arr.get(i).getDriverName();
				data[i][1]=String.valueOf(arr.get(i).getEmployeeId());
				data[i][2]=arr.get(i).getPhoneNumber();
				data[i][3]=arr.get(i).getRouteName();
				data[i][4]=String.valueOf(arr.get(i).getBusRegNo());
				data[i][5]=arr.get(i).getDate();
				data[i][6]=arr.get(i).getTime();
				data[i][7]=arr.get(i).getMaintenceReuest();
			}
		}
		
	//	String col[]= {"Student Name","Roll Number","Phone Number","Route Name","Bus Registration Number","Driver Name","Date","Time","Feedback"};
		
		table = new JTable(data,col);
		scrollPane.setViewportView(table);
		table.setRowHeight(40);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminDashBoard ad=new AdminDashBoard();
			    ad.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(1052, 611, 152, 38);
		contentPane.add(btnNewButton);
		
	}

}