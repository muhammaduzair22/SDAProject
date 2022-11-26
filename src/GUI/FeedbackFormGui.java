package GUI;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import BusinessLogic.*;
import Database.DBHandler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class FeedbackFormGui extends JFrame {

	private JPanel contentPane;
	private JTextField inputName;
	private JTextField inputRollNo;
	private JTextField inputPhNo;
	private JTextField inputRouteName;
	private JTextField inputBusRegNo;
	private JTextField inputDrvierName;
	private JTextField inputDate;
	private JTextField inputFeedback;
	private JTextField inputTime;
	private JButton btnNewButton;
	private JLabel lblName;
	private JLabel lblRollNumber;
	private JLabel lblPhoneNumber;
	private JLabel lblRouteName;
	private JLabel lblBusRegistrationNo;
	private JLabel lblDriverName;
	private JLabel lblDate;
	private JLabel lblTime;
	private JLabel lblFeedback;
	private JLabel lblFeedbackForm;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	/*	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeedbackFormGui frame = new FeedbackFormGui();
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
	public FeedbackFormGui(Student s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		inputName = new JTextField();
		inputName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputName.setColumns(10);
		inputName.setBounds(293, 131, 160, 36);
		contentPane.add(inputName);
		
		inputRollNo = new JTextField();
		inputRollNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputRollNo.setColumns(10);
		inputRollNo.setBounds(293, 192, 160, 36);
		contentPane.add(inputRollNo);
		
		inputPhNo = new JTextField();
		inputPhNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputPhNo.setColumns(10);
		inputPhNo.setBounds(293, 257, 160, 36);
		contentPane.add(inputPhNo);
		
		inputRouteName = new JTextField();
		inputRouteName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputRouteName.setColumns(10);
		inputRouteName.setBounds(293, 328, 160, 36);
		contentPane.add(inputRouteName);
		
		inputBusRegNo = new JTextField();
		inputBusRegNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputBusRegNo.setColumns(10);
		inputBusRegNo.setBounds(293, 392, 160, 36);
		contentPane.add(inputBusRegNo);
		
		inputDrvierName = new JTextField();
		inputDrvierName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputDrvierName.setColumns(10);
		inputDrvierName.setBounds(293, 461, 160, 36);
		contentPane.add(inputDrvierName);
		
		inputDate = new JTextField();
		inputDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputDate.setColumns(10);
		inputDate.setBounds(293, 536, 160, 36);
		contentPane.add(inputDate);
		
		inputFeedback = new JTextField();
		inputFeedback.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputFeedback.setColumns(10);
		inputFeedback.setBounds(757, 192, 295, 128);
		contentPane.add(inputFeedback);
		
		inputTime = new JTextField();
		inputTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputTime.setColumns(10);
		inputTime.setBounds(293, 605, 160, 36);
		contentPane.add(inputTime);
		
		btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FeedbackForm form= new FeedbackForm();
				  form.setStudentName(inputName.getText());
				  form.setDriverName(inputDrvierName.getText());
				  form.setPhoneNumber(inputPhNo.getText());
				  form.setRouteName(inputRouteName.getText());
				  form.setBusRegNo(Integer.parseInt(inputBusRegNo.getText())); 
				  form.setDate(inputDate.getText());
				  form.setTime(inputTime.getText());
				  form.setRollNumber(inputRollNo.getText());
				  form.setFeedback(inputFeedback.getText());
				  form.saveFeedback(form);
				  
				  DBHandler db=new DBHandler();
				  db.connectDB();
				  
				  db.addFeedback(form);
				  
				  StudentDashboard sd=new StudentDashboard(s);
				  sd.setVisible(true);
				  dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(757, 374, 130, 36);
		contentPane.add(btnNewButton);
		
		lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBounds(90, 135, 118, 23);
		contentPane.add(lblName);
		
		lblRollNumber = new JLabel("Roll Number:");
		lblRollNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRollNumber.setBounds(90, 196, 141, 23);
		contentPane.add(lblRollNumber);
		
		lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPhoneNumber.setBounds(90, 261, 181, 23);
		contentPane.add(lblPhoneNumber);
		
		lblRouteName = new JLabel("Route Name:");
		lblRouteName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRouteName.setBounds(90, 332, 130, 23);
		contentPane.add(lblRouteName);
		
		lblBusRegistrationNo = new JLabel("Bus Number");
		lblBusRegistrationNo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBusRegistrationNo.setBounds(90, 396, 181, 23);
		contentPane.add(lblBusRegistrationNo);
		
		lblDriverName = new JLabel("Driver Name:");
		lblDriverName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDriverName.setBounds(90, 465, 141, 23);
		contentPane.add(lblDriverName);
		
		lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDate.setBounds(90, 540, 141, 23);
		contentPane.add(lblDate);
		
		lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTime.setBounds(90, 609, 141, 23);
		contentPane.add(lblTime);
		
		lblFeedback = new JLabel("Feedback:");
		lblFeedback.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFeedback.setBounds(757, 143, 118, 23);
		contentPane.add(lblFeedback);
		
		lblFeedbackForm = new JLabel("Feedback Form");
		lblFeedbackForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeedbackForm.setFont(new Font("Sitka Heading", Font.BOLD, 40));
		lblFeedbackForm.setBounds(395, 10, 396, 59);
		contentPane.add(lblFeedbackForm);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StudentDashboard sd=new StudentDashboard(s);
				sd.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(920, 374, 130, 36);
		contentPane.add(btnNewButton_1);
	}
}
