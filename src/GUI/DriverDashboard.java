package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BusinessLogic.BookBus;
import BusinessLogic.BookBusList;
import BusinessLogic.Student;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;

public class DriverDashboard extends JFrame {

	private JPanel contentPane;
	ArrayList<BookBus> Busarr= new ArrayList<BookBus>();
	ArrayList<Student> Stuarr= new ArrayList<Student>();
	BookBus bus;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DriverDashboard frame = new DriverDashboard();
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
	public DriverDashboard() {
		BookBusList bl=BookBusList.getInstance();
		bl.data();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image Im=new ImageIcon(this.getClass().getResource("/rstudents.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(Im));
		lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/rstudents.png")).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
		lblNewLabel.setBounds(182, 189, 327, 288);
		contentPane.add(lblNewLabel);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String busRegNo=JOptionPane.showInputDialog(contentPane,"Enter Bus Registration Number"); 

				int busreg=Integer.parseInt(busRegNo);
				int i=0;
				for(;i<BookBusList.getInstance().getList().size();i++)
				{
					if(BookBusList.getInstance().getList().get(i).getBusNumber()==busreg)
					{
						bus=BookBusList.getInstance().getList().get(i);
						break;
					}
				}
				if(bus==null) 
				{
					JOptionPane.showMessageDialog(contentPane, "No such bus!",
			               "Error",JOptionPane.ERROR_MESSAGE );
					}
				System.out.println("seats"+bus.gettotalseats());
				if(bus.gettotalseats()==30)
				{
					JOptionPane.showMessageDialog(contentPane, "No Bookings!",
				               "Error",JOptionPane.ERROR_MESSAGE );
				}
				else
				{
					DriverRegisteredStudents dr= new DriverRegisteredStudents(bus);
				//	System.out.println("dashboard:"+BookBusList.getInstance().getList().get(i).getBookedStudentsList().get(i).getName());

					dr.setVisible(true);
					dispose();				
					}
	
			}
		});
		
		JLabel lblRegisteredStudents = new JLabel("Registered Students");
		lblRegisteredStudents.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisteredStudents.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRegisteredStudents.setFont(new Font("Sitka Heading", Font.PLAIN, 30));
		lblRegisteredStudents.setBounds(182, 476, 338, 72);
		contentPane.add(lblRegisteredStudents);
		
		JLabel lblMaintenceForm = new JLabel("Maintence Form");
		lblMaintenceForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaintenceForm.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMaintenceForm.setFont(new Font("Sitka Heading", Font.PLAIN, 30));
		lblMaintenceForm.setBounds(757, 476, 213, 72);
		contentPane.add(lblMaintenceForm);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image Im2=new ImageIcon(this.getClass().getResource("/mform.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(Im2));
		lblNewLabel_1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/mform.jpg")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		lblNewLabel_1.setBounds(757, 222, 213, 255);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MaintenaceFormGui mf= new MaintenaceFormGui();
				mf.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("University Bus MS");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Sitka Heading", Font.BOLD, 50));
		lblNewLabel_2.setBounds(263, 11, 645, 72);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(38, 602, 138, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Diver Dashboard");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Sitka Heading", Font.BOLD, 26));
		lblNewLabel_3.setBounds(477, 71, 235, 54);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("LogOut");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home h=new Home();
				h.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(10, 11, 115, 40);
		contentPane.add(btnNewButton_1);
	}

}
