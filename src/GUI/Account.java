package GUI;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import BusinessLogic.*;
import Database.DBHandler;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Account extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account frame = new Account(new Student("", "", "", "", ""));//<-- Insert object of student who is logined 
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
	public Account(Student s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption	);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(SystemColor.activeCaption);
		contentPane_1.setBounds(0, 0, 1265, 684);
		contentPane.add(contentPane_1);
		
		JLabel lblname = new JLabel("");
		lblname.setForeground(Color.BLUE);
		lblname.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblname.setBackground(Color.WHITE);
		lblname.setBounds(221, 151, 217, 27);
		contentPane_1.add(lblname);
		
		JLabel lblNewLabel = new JLabel("University Bus MS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 50));
		lblNewLabel.setBounds(381, 25, 529, 63);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Account");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(550, 90, 196, 33);
		contentPane_1.add(lblNewLabel_1);
		
		lblname.setText(s.getName());
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(51, 151, 69, 33);
		contentPane_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Roll Number:");
		lblNewLabel_3.setToolTipText("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(51, 212, 144, 33);
		contentPane_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phone:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(51, 273, 97, 33);
		contentPane_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Username:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(51, 332, 115, 33);
		contentPane_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Password:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_7.setBounds(51, 386, 115, 33);
		contentPane_1.add(lblNewLabel_7);
		
		JLabel lblRollnum = new JLabel("");
		lblRollnum.setForeground(Color.BLUE);
		lblRollnum.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRollnum.setBounds(221, 212, 217, 27);
		contentPane_1.add(lblRollnum);
		lblRollnum.setText(s.getRollNumber());

		
		JLabel lblusername = new JLabel("");
		lblusername.setForeground(Color.BLUE);
		lblusername.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblusername.setBounds(221, 338, 185, 27);
		contentPane_1.add(lblusername);
		lblusername.setText(s.getUserName());
		
		JLabel lblpassword = new JLabel("");
		lblpassword.setForeground(Color.BLUE);
		lblpassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblpassword.setBounds(221, 386, 185, 33);
		contentPane_1.add(lblpassword);
		
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
		btnNewButton.setBounds(1086, 612, 154, 42);
		contentPane_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Change Password");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newpassword=JOptionPane.showInputDialog(contentPane,"Enter new Password");
				if(true)//checks of password
				{
					DBHandler db=new DBHandler();
					db.connectDB();
					
					Student stu= new Student(s.getRollNumber(),s.getName(),s.getPhoneNumber(),s.getUserName(),newpassword,s.getWalletAmount());
					
					//int i index of aray where student logined is saves
					int index = RegisteredStudentsList.getInstance().getIndex(s);
					RegisteredStudentsList.getInstance().getList().get(index).setPassword(newpassword);
					
					db.updateStudent(s);
					if(index==-1) {}//such student does not exisit
					else 
					{
						RegisteredStudentsList.getInstance().getList().get(index).setUserName(newpassword);
						lblpassword.setText(newpassword);
					}
					
					
					
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "Invalid Password",
				               "Error",JOptionPane.ERROR_MESSAGE );}
				contentPane.repaint();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(30, 613, 206, 42);
		contentPane_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Change Username");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newusername=JOptionPane.showInputDialog(contentPane,"Enter new Username");
				if(true)//check_username())
				{
					//int i=indexofStudent logined
					Student stu=new Student(s.getRollNumber(),s.getName(),s.getPhoneNumber(),newusername,s.getPassword(),s.getWalletAmount());
					DBHandler db=new DBHandler();
					db.connectDB();
									
					//int i index of aray where student logined is saves
					int index = RegisteredStudentsList.getInstance().getIndex(s);
					RegisteredStudentsList.getInstance().getList().get(index).setUserName(newusername);					
					db.updateStudent(s);
					if(index==-1) {}//such student does not exisit
					else 
					{
						RegisteredStudentsList.getInstance().getList().get(index).setUserName(newusername);
						lblusername.setText(newusername);
					}		
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane, "Invalid Username",
				               "Error",JOptionPane.ERROR_MESSAGE );
				}
				contentPane.repaint();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBounds(30, 561, 206, 42);
		contentPane_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Save");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Saved Sucessfully" );
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBounds(922, 611, 154, 43);
		contentPane_1.add(btnNewButton_3);
		
		JLabel lblName = new JLabel("");
		lblName.setForeground(Color.BLUE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(205, 157, 217, 27);
		contentPane_1.add(lblName);
		
		JLabel lblNewLabel_5 = new JLabel("");
		Image Im=new ImageIcon(this.getClass().getResource("/wallet.png")).getImage();
		lblNewLabel_5.setIcon(new ImageIcon(Im));
		lblNewLabel_5.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/wallet.png")).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
		lblNewLabel_5.setBounds(877, 150, 339, 313);
		contentPane_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_8 = new JLabel("Wallet");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_8.setBounds(968, 451, 126, 63);
		contentPane_1.add(lblNewLabel_8);
		
		JLabel lblphone = new JLabel("");
		lblphone.setForeground(Color.BLUE);
		lblphone.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblphone.setBounds(221, 267, 185, 33);
		contentPane_1.add(lblphone);
		lblphone.setText(s.getRollNumber());
		lblpassword.setText(s.getPassword());
		
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//DBHandler db=new DBHandler();
				//db.connectDB();
				double amount=s.getWalletAmount();
				System.out.println(amount);
				if(amount>0)
				{
					JOptionPane.showMessageDialog(contentPane, "Your Wallet amount is= "+ s.getWalletAmount());
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane, "Please Recharge Your Wallet!");

				}
			              
			}
		});

	}
}
