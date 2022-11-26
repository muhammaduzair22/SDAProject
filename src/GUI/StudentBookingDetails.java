package GUI;

import java.awt.BorderLayout;
import BusinessLogic.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentBookingDetails extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentBookingDetails frame = new StudentBookingDetails(null);
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
	public StudentBookingDetails(Student s) {
		gui(s);
	}
	
	public void gui(Student s)
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(SystemColor.activeCaption);
		contentPane_1.setBounds(10, 10, 1265, 683);
		contentPane.add(contentPane_1);
		
		JLabel lblNewLabel = new JLabel("University Bus MS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 50));
		lblNewLabel.setBounds(0, 21, 1265, 56);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Current Bookings");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Sitka Heading", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(537, 78, 206, 38);
		contentPane_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StudentDashboard sd=new StudentDashboard(s);
				sd.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(1052, 611, 152, 38);
		contentPane_1.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Bus Number:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(40, 225, 144, 33);
		contentPane_1.add(lblNewLabel_2);
		
		JLabel lblname = new JLabel("");
		lblname.setForeground(Color.BLUE);
		lblname.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblname.setBackground(Color.WHITE);
		lblname.setBounds(210, 231, 217, 27);
		contentPane_1.add(lblname);
		
		JLabel lblNewLabel_3 = new JLabel("Route:");
		lblNewLabel_3.setToolTipText("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(40, 286, 144, 33);
		contentPane_1.add(lblNewLabel_3);
		
		JLabel lblRoute = new JLabel("");
		lblRoute.setForeground(Color.BLUE);
		lblRoute.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRoute.setBounds(210, 290, 217, 27);
		contentPane_1.add(lblRoute);
		
		JLabel lblNewLabel_4 = new JLabel("Fare:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(40, 347, 97, 33);
		contentPane_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Time:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(40, 406, 97, 33);
		contentPane_1.add(lblNewLabel_6);
		
		JLabel lbltime = new JLabel("");
		lbltime.setForeground(Color.BLUE);
		lbltime.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbltime.setBounds(210, 412, 185, 27);
		contentPane_1.add(lbltime);
		
		JLabel lblFare = new JLabel("");
		lblFare.setForeground(Color.BLUE);
		lblFare.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFare.setBounds(210, 353, 217, 27);
		contentPane_1.add(lblFare);
		
		//JLabel lblNewLabel_5 = new JLabel("");
		Icon imgIcon = new ImageIcon(this.getClass().getResource("/showbooking.gif"));
		JLabel lblNewLabel_5 = new JLabel(imgIcon);
		lblNewLabel_5.setBounds(741, 145, 421, 387);
		contentPane_1.add(lblNewLabel_5);
		
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
					lblname.setText(busid);
					lblRoute.setText(Bl.getList().get(i).getRoute());
					lblFare.setText(Bl.getList().get(i).getFare());
					lbltime.setText(Bl.getList().get(i).getTime());				
				}
	
			}
			
		}
	
	}
}
