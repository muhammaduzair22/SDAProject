package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import BusinessLogic.*;
import Database.DBHandler;
public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		data();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Home() {
		
		home();
	}
	
	public static void data()
	{
		BookBusList bl=BookBusList.getInstance();
		bl.data();	
	}
	public void home()
	{
		
		Student s=new Student("haris","12345678910", "1234567", "haris", "Uzair11@",1000.00);
		RegisteredStudentsList rl=RegisteredStudentsList.getInstance();
		rl.save(s);
		Driver d=new Driver("Uzair", 001, 500, "uzair", "Uzair11@");
		DriverList dl=DriverList.getInstance();
		dl.saveDriver(d);
		Admin a=new Admin("admin","123");
		
		DBHandler db=new DBHandler();
		db.connectDB();
		//BookBusList.getInstance().setbus(null);
		
		//BookBusList.getInstance().setbus(db.ReadBookBus(BookBusList.getInstance().getList()));
		//db.addToBookBus(BookBusList.getInstance().getList());
		//db.addToStudent(RegisteredStudentsList.getInstance().getList());
		
		//RegisteredStudentsList.getInstance().setList(db.ReadStudents(RegisteredStudentsList.getInstance().getList()));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("University Bus Management");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.PLAIN, 50));
		lblNewLabel.setBounds(304, 10, 645, 72);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("System");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.PLAIN, 50));
		lblNewLabel_1.setBounds(528, 72, 214, 72);
		contentPane.add(lblNewLabel_1);
		
		
		JLabel lbluser = new JLabel("");
		lbluser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		Image Im=new ImageIcon(this.getClass().getResource("/profile.jpg")).getImage();
		lbluser.setIcon(new ImageIcon(Im));
		lbluser.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/profile.jpg")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		lbluser.setBounds(1157, 10, 100, 100);
		contentPane.add(lbluser);
		
		JLabel lbladmin = new JLabel("");
		lbladmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login l=new Login(true, false, false);
				l.setVisible(true);
				dispose();
				
			}
		});
		Image Im2=new ImageIcon(this.getClass().getResource("/admin.jpg")).getImage();
		lbladmin.setIcon(new ImageIcon(Im2));
		lbladmin.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/admin.jpg")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		lbladmin.setBounds(97, 175, 205, 216);
		contentPane.add(lbladmin);
		
		JLabel lblNewLabel_5 = new JLabel("Admin");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_5.setBounds(97, 401, 205, 38);
		contentPane.add(lblNewLabel_5);
		
		JLabel lbldriver = new JLabel("");
		lbldriver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login l=new Login(false, false, true);
				l.setVisible(true);
				dispose();
				
			}
		});
		Image Im3=new ImageIcon(this.getClass().getResource("/driver.png")).getImage();
		lbldriver.setIcon(new ImageIcon(Im3));
		lbldriver.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/driver.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		lbldriver.setBounds(942, 175, 205, 216);
		contentPane.add(lbldriver);
		
		JLabel lblNewLabel_4 = new JLabel("Driver");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_4.setBounds(942, 401, 205, 38);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(40, 592, 152, 39);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Student");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(537, 404, 205, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblstudent = new JLabel("");
		lblstudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login l=new Login(false,true, false);
				l.setVisible(true);
				dispose();
				
			}
		});
		Image Im4=new ImageIcon(this.getClass().getResource("/student.png")).getImage();
		lblstudent.setIcon(new ImageIcon(Im3));
		lblstudent.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/student.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		lblstudent.setBounds(537, 175, 205, 204);
		contentPane.add(lblstudent);
	}
	
}
