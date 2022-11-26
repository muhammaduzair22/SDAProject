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

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import BusinessLogic.Admin;
import BusinessLogic.BookBusList;
import BusinessLogic.DriverList;
import BusinessLogic.RegisteredStudentsList;
import BusinessLogic.Student;
import Database.DBHandler;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtusername;
	private JPasswordField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	boolean adminlogin=false;
	boolean studentlogin=false;
	boolean driverlogin=false;
	
	public Login(boolean admin,boolean student,boolean driver)
	{
		login(admin, student, driver);
}
	public void login(boolean admin,boolean student,boolean driver)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1281, 719);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("University Bus MS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 50));
		lblNewLabel.setBounds(321, 10, 537, 77);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LogIn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(500, 76, 189, 53);
		contentPane.add(lblNewLabel_1);
		
		Icon imgIcon = new ImageIcon(this.getClass().getResource("/busgif.gif"));
		JLabel label = new JLabel(imgIcon);
		label.setBounds(27, 192, 506, 343); // You can use your own values
		contentPane.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(841, 147, 129, 29);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(841, 219, 129, 33);
		contentPane.add(lblNewLabel_3);
		
		txtusername = new JTextField();
		txtusername.setBounds(993, 147, 198, 29);
		contentPane.add(txtusername);
		txtusername.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(993, 219, 198, 33);
		contentPane.add(txtpassword);
		
		JLabel lblNewLabel_4 = new JLabel("Don't have account?");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(993, 282, 160, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblcreataccount = new JLabel("Creat an account.");
		lblcreataccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(admin==false && driver==false)
				{
					Signup s=new Signup();
					s.setVisible(true);
					dispose();
				}
				
				
			}
		});
		lblcreataccount.setForeground(Color.BLUE);
		lblcreataccount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblcreataccount.setBounds(993, 309, 160, 20);
		contentPane.add(lblcreataccount);
		
		JButton btnNewButton = new JButton("LogIn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(student==true)
				{
					DBHandler db=new DBHandler();
					ArrayList<Student> Students=new ArrayList<Student>();
					db.connectDB();
					Students=db.ReadStudents(Students);
					RegisteredStudentsList rl=RegisteredStudentsList.getInstance();
					RegisteredStudentsList.getInstance().setList(Students);
					
					if(txtusername.getText().equals("") || txtpassword.getText().equals(""))
				     {
				    	 JOptionPane.showMessageDialog(contentPane, "Fields Empty",
					               "Error",JOptionPane.ERROR_MESSAGE );
				     }

					if(rl.login(txtusername.getText(),txtpassword.getText())==2)
					{
						
						for(int i=0;i<rl.getList().size();i++)
						{
							if(rl.getList().get(i).getUserName().equals(txtusername.getText()))
							{
								StudentDashboard sd=new StudentDashboard(rl.getList().get(i));
								sd.setVisible(true);
								dispose();
							}
						}
						
					}
					else if(rl.login(txtusername.getText(),txtpassword.getText())==1)
					{
						JOptionPane.showMessageDialog(contentPane, "Incorrect Password",
					               "Error",JOptionPane.ERROR_MESSAGE );
					}
					else if(rl.login(txtusername.getText(),txtpassword.getText())==0)
					{
						JOptionPane.showMessageDialog(contentPane, "No existing account",
					               "Error",JOptionPane.ERROR_MESSAGE );
					}
				
				}
				else if(driver==true)
				{
					DriverList dl=DriverList.getInstance();
					if(txtusername.getText().equals("") || txtpassword.getText().equals(""))
				     {
				    	 JOptionPane.showMessageDialog(contentPane, "Fields Empty",
					               "Error",JOptionPane.ERROR_MESSAGE );
				     }

					if(dl.login(txtusername.getText(),txtpassword.getText())==2)
					{
						int i=0;
						for(;i<dl.getList().size();i++)
						{
							if(dl.getList().get(i).getUsername().equals(txtusername))
							{
								break;
							}
						}
						DriverDashboard sd=new DriverDashboard();
						sd.setVisible(true);
						dispose();
					}
					else if(dl.login(txtusername.getText(),txtpassword.getText())==1)
					{
						JOptionPane.showMessageDialog(contentPane, "Incorrect Password",
					               "Error",JOptionPane.ERROR_MESSAGE );
					}
					else if(dl.login(txtusername.getText(),txtpassword.getText())==0)
					{
						JOptionPane.showMessageDialog(contentPane, "No existing account",
					               "Error",JOptionPane.ERROR_MESSAGE );
					}
				}
				
				else if(admin==true)
				{
					Admin a=new Admin("admin", "123");
					if(txtusername.getText().equals("") || txtpassword.getText().equals(""))
				     {
				    	 JOptionPane.showMessageDialog(contentPane, "Fields Empty",
					               "Error",JOptionPane.ERROR_MESSAGE );
				     }

				     if(txtusername.getText().equals(a.getUserName()) && txtpassword.getText().equals(a.getPassword()))
					{
				    	 AdminDashBoard ad=new AdminDashBoard();
						ad.setVisible(true);
						dispose();
					}
					
				}
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(1096, 339, 95, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home h=new Home();
				h.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(989, 339, 102, 46);
		contentPane.add(btnNewButton_1);
	}
	
}
