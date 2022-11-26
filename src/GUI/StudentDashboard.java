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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import BusinessLogic.BookBusList;
import BusinessLogic.Student;
import java.awt.Color;

public class StudentDashboard extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDashboard frame = new StudentDashboard();
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

	public StudentDashboard(Student s) {
		studentdash( s);
	}
	
	public void studentdash(Student s)
	{
		JLabel lbllogin = new JLabel(s.getUserName());

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("University Bus MS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 50));
		lblNewLabel.setBounds(304, 10, 645, 72);
		contentPane.add(lblNewLabel);
		
		
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
		
		lbllogin.setHorizontalAlignment(SwingConstants.CENTER);
		lbllogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbllogin.setBounds(1157, 120, 100, 24);
		contentPane.add(lbllogin);
		
		JLabel lbladmin = new JLabel("");
		lbladmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Searchandbook sb=new Searchandbook(s);
				sb.setVisible(true);
				dispose();
				
			}
		});
		Image Im2=new ImageIcon(this.getClass().getResource("/book.png")).getImage();
		lbladmin.setIcon(new ImageIcon(Im2));
		lbladmin.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/book.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		lbladmin.setBounds(328, 173, 214, 216);
		contentPane.add(lbladmin);
		
		JLabel lblNewLabel_5 = new JLabel("Book");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_5.setBounds(338, 401, 205, 38);
		contentPane.add(lblNewLabel_5);
		
		JLabel lbldriver = new JLabel("");
		lbldriver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Account a=new Account(s);
				a.setVisible(true);
				dispose();
				
			}
		});
		Image Im3=new ImageIcon(this.getClass().getResource("/account.png")).getImage();
		lbldriver.setIcon(new ImageIcon(Im3));
		lbldriver.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/account.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		lbldriver.setBounds(717, 175, 223, 216);
		contentPane.add(lbldriver);
		
		JLabel lblNewLabel_4 = new JLabel("Profile");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_4.setBounds(717, 401, 205, 38);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(40, 592, 139, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Bookings");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean flg=false;
				BookBusList Bl= BookBusList.getInstance();
				for(int i=0;i<Bl.getList().size();i++)
				{
					ArrayList<Student> students= new ArrayList<Student>();
					students=Bl.getBookedStudentList(i);
					for(int j=0;j<students.size();j++)
					{
						if(students.get(j).getRollNumber().equals(s.getRollNumber()))
						{
							String busid=String.valueOf(Bl.getList().get(i).getBusNumber());
							flg=true;
							StudentBookingDetails sbd=new StudentBookingDetails(s);
							sbd.setVisible(true);
							dispose();
						}
							
					}
					
				}
			 if(flg==false)
			 {
				 JOptionPane.showMessageDialog(contentPane, "No booking yet!",
			               "Error",JOptionPane.ERROR_MESSAGE );
			 }

				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(893, 592, 152, 38);
		contentPane.add(btnNewButton_2);
		
		JButton btnfeedback = new JButton("FeedBack");
		btnfeedback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FeedbackFormGui ff=new FeedbackFormGui(s);
				ff.setVisible(true);
				dispose();
			}
		});
		btnfeedback.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnfeedback.setBounds(1075, 592, 152, 38);
		contentPane.add(btnfeedback);
		
		JLabel lblNewLabel_1 = new JLabel("Student Dashboard");
		lblNewLabel_1.setFont(new Font("Sitka Heading", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(518, 68, 238, 53);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("LogOut");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home h=new Home();
				h.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(10, 20, 113, 47);
		contentPane.add(btnNewButton);
		Image Im4=new ImageIcon(this.getClass().getResource("/student.png")).getImage();
	}
}
