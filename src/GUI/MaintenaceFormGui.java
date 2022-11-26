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

public class MaintenaceFormGui extends JFrame {

	private JPanel contentPane;
	private JTextField inputName;
	private JTextField inputEmpID;
	private JTextField inputPhNo;
	private JTextField inputRouteName;
	private JTextField inputBusRegNo;
	private JTextField inputDate;
	private JTextField inputRequest;
	private JTextField inputTime;
	private JButton btnNewButton;
	private JLabel lblName;
	private JLabel lblRollNumber;
	private JLabel lblPhoneNumber;
	private JLabel lblRouteName;
	private JLabel lblBusRegistrationNo;
	private JLabel lblDate;
	private JLabel lblTime;
	private JLabel lblFeedback;
	private JLabel lblFeedbackForm;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		MaintenaceFormGui frame = new MaintenaceFormGui();
		frame.setVisible(true);
		/*
		 * EventQueue.invokeLater(new Runnable() { public void run() { try {
		 * 
		 * } catch (Exception e) { e.printStackTrace(); } } });
		 */
	}

	/**
	 * Create the frame.
	 */
	public MaintenaceFormGui() {
	 Gui();
	 
	}
	
	public void Gui()
	{

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
	
	inputEmpID = new JTextField();
	inputEmpID.setFont(new Font("Tahoma", Font.PLAIN, 15));
	inputEmpID.setColumns(10);
	inputEmpID.setBounds(293, 192, 160, 36);
	contentPane.add(inputEmpID);
	
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
	
	inputDate = new JTextField();
	inputDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
	inputDate.setColumns(10);
	inputDate.setBounds(293, 457, 160, 36);
	contentPane.add(inputDate);
	
	inputRequest = new JTextField();
	inputRequest.setFont(new Font("Tahoma", Font.PLAIN, 15));
	inputRequest.setColumns(10);
	inputRequest.setBounds(757, 192, 295, 98);
	contentPane.add(inputRequest);
	
	inputTime = new JTextField();
	inputTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
	inputTime.setColumns(10);
	inputTime.setBounds(293, 523, 160, 36);
	contentPane.add(inputTime);
	
	btnNewButton = new JButton("Submit");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			  MaintenanceRequestForm form= new MaintenanceRequestForm();
		      form.setDriverName(inputName.getText());
			  form.setEmployeeId(Integer.parseInt(inputEmpID.getText()));
			  form.setPhoneNumber(inputPhNo.getText());
			  form.setRouteName(inputRouteName.getText());
			  form.setBusRegNo(Integer.parseInt(inputBusRegNo.getText())); 
			  form.setDate(inputDate.getText());
			  form.setTime(inputTime.getText());
			  form.setMaintenceReuest(inputRequest.getText());
			  form.save(form);
			  
			  DBHandler db=new DBHandler();
			  db.connectDB();
			  db.addMaintainanceReq(form);
			  DriverDashboard dd =new DriverDashboard();
			  dd.setVisible(true);
			  dispose();
		}
	});
	btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
	btnNewButton.setBounds(757, 319, 130, 36);
	contentPane.add(btnNewButton);
	
	lblName = new JLabel("Driver Name:");
	lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblName.setBounds(90, 135, 118, 23);
	contentPane.add(lblName);
	
	lblRollNumber = new JLabel("Employee ID:");
	lblRollNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblRollNumber.setBounds(90, 196, 141, 23);
	contentPane.add(lblRollNumber);
	
	lblPhoneNumber = new JLabel("Phone Number:");
	lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblPhoneNumber.setBounds(90, 261, 141, 23);
	contentPane.add(lblPhoneNumber);
	
	lblRouteName = new JLabel("Route Name:");
	lblRouteName.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblRouteName.setBounds(90, 332, 130, 23);
	contentPane.add(lblRouteName);
	
	lblBusRegistrationNo = new JLabel("Bus Number:");
	lblBusRegistrationNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblBusRegistrationNo.setBounds(90, 396, 181, 23);
	contentPane.add(lblBusRegistrationNo);
	
	lblDate = new JLabel("Date:");
	lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblDate.setBounds(90, 461, 141, 23);
	contentPane.add(lblDate);
	
	lblTime = new JLabel("Time:");
	lblTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblTime.setBounds(90, 527, 141, 23);
	contentPane.add(lblTime);
	
	lblFeedback = new JLabel("Maintenance Request:");
	lblFeedback.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblFeedback.setBounds(757, 143, 226, 23);
	contentPane.add(lblFeedback);
	
	lblFeedbackForm = new JLabel("Maintenance Form");
	lblFeedbackForm.setHorizontalAlignment(SwingConstants.CENTER);
	lblFeedbackForm.setFont(new Font("Sitka Heading", Font.BOLD, 40));
	lblFeedbackForm.setBounds(395, 10, 396, 82);
	contentPane.add(lblFeedbackForm);
	
	btnNewButton_1 = new JButton("Back");
	btnNewButton_1.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			DriverDashboard dd=new DriverDashboard();
			dd.setVisible(true);
			dispose();
			
		}
	});
	btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
	btnNewButton_1.setBounds(907, 319, 144, 36);
	contentPane.add(btnNewButton_1);}
}
