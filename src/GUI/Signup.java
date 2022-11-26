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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import BusinessLogic.RegisteredStudentsList;
import BusinessLogic.Student;
import Database.DBHandler;
import BusinessLogic.*;
public class Signup extends JFrame {

	private JPanel contentPane;

	private JTextField txtname;
	private JTextField txtphone;
	private JTextField txtrollnumber;
	private JTextField txtusername;
	private JTextField txtpassword;
	private JTextField txtcpassword;
	JCheckBox cbx = new JCheckBox("Accepted terms and conditions? ");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	public Signup() {
		signup();
	}
	
	public void signup()
	{	
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(942, 79, 73, 34);
		contentPane.add(lblNewLabel);
		
		txtname = new JTextField();
		txtname.setBounds(941, 110, 198, 34);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Phone Number");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(942, 154, 159, 39);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Roll Number");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(941, 234, 159, 34);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Username");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(941, 310, 106, 34);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(941, 389, 106, 34);
		contentPane.add(lblNewLabel_5);
		
		txtphone = new JTextField();
		txtphone.setBounds(941, 190, 198, 34);
		contentPane.add(txtphone);
		txtphone.setColumns(10);
		
		txtrollnumber = new JTextField();
		txtrollnumber.setBounds(941, 269, 198, 34);
		contentPane.add(txtrollnumber);
		txtrollnumber.setColumns(10);
		
		txtusername = new JTextField();
		txtusername.setBounds(941, 339, 198, 34);
		contentPane.add(txtusername);
		txtusername.setColumns(10);
		
		txtpassword = new JTextField();
		txtpassword.setBounds(941, 419, 198, 34);
		contentPane.add(txtpassword);
		txtpassword.setColumns(10);
		
		ButtonGroup btng =new ButtonGroup();
		
		JLabel lblNewLabel_6 = new JLabel("");
		Image Im=new ImageIcon(this.getClass().getResource("/bus.jpeg")).getImage();
		lblNewLabel_6.setIcon(new ImageIcon(Im));
		lblNewLabel_6.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/bus.jpeg")).getImage().getScaledInstance(650, 400, Image.SCALE_SMOOTH)));
		lblNewLabel_6.setBounds(31, 144, 663, 400);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("University Bus MS");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Sylfaen", Font.BOLD, 50));
		lblNewLabel_7.setBounds(362, 10, 479, 74);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("SignIn Form");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(554, 64, 127, 39);
		contentPane.add(lblNewLabel_8);
		

		cbx.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbx.setBounds(941, 547, 198, 45);
		contentPane.add(cbx);

		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(check_rollnumber() && check_name() && check_phone() && check_username() && check_password() && check_checkbox())
				{
					Student s=new Student(txtrollnumber.getText(),txtname.getText(), txtphone.getText(), txtusername.getText(), txtpassword.getText(),10000);
					RegisteredStudentsList rl=RegisteredStudentsList.getInstance();					
					
					if(rl.save(s))
					{
						//next screen
						DBHandler db=new DBHandler();
						db.connectDB();
						db.addToStudent(s);
						Login l=new Login(false,true,false);
						l.setVisible(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(contentPane, "Roll Number Already Exists",
					               "Error",JOptionPane.ERROR_MESSAGE );
					}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(1042, 598, 99, 45);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login l=new Login(false,true,false);
				l.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(941, 598, 91, 45);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_9 = new JLabel("Confirm Password");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_9.setBounds(941, 463, 198, 34);
		contentPane.add(lblNewLabel_9);
		
		txtcpassword = new JTextField();
		txtcpassword.setBounds(941, 494, 198, 34);
		contentPane.add(txtcpassword);
		txtcpassword.setColumns(10);
		
	}
	boolean check_name()
	{
		if(txtname.getText().equals("") || txtname.getText().contains("0") || txtname.getText().contains("1") || txtname.getText().contains("2") || txtname.getText().contains("3") || txtname.getText().contains("4") || txtname.getText().contains("5") || txtname.getText().contains("6") || txtname.getText().contains("7") || txtname.getText().contains("8") || txtname.getText().contains("9"))
		{
			JOptionPane.showMessageDialog(contentPane, "Invalid Name",
		               "Error",JOptionPane.ERROR_MESSAGE );
			return false;
		}
		else
			{
			  return true;
			}
	}
	boolean check_phone()
    {
		boolean flag=true;
		if (txtphone.getText().equals("")) {
        	JOptionPane.showMessageDialog(contentPane, "Enter Phone Number",
		               "Error",JOptionPane.ERROR_MESSAGE );
            return false;
		}	
		if(txtphone.getText().length()!=11)
		{
			flag=false;
		}
        for (int i = 0; i <txtphone.getText().length()  ; i++)
        {
            char c = txtphone.getText().charAt(i);
            if ((c>='0' && c<='9')==false) 
            {
                flag=false;
            }
        }
        if(flag==false)
        {
        	JOptionPane.showMessageDialog(contentPane, "Invalid Phone Number",
 	               "Error",JOptionPane.ERROR_MESSAGE );
        }
		return flag;
       
    }
	
	boolean check_rollnumber()
	{
		boolean flag=true;
		if (txtrollnumber.getText().equals("")) {
        	JOptionPane.showMessageDialog(contentPane, "Enter Roll Number",
		               "Error",JOptionPane.ERROR_MESSAGE );
            return false;
        }
		if((txtrollnumber.getText().length()!=7))
		{
			JOptionPane.showMessageDialog(contentPane, "Invalid Roll Number",
		               "Error",JOptionPane.ERROR_MESSAGE );
         return false;
		}
        if(flag==false)
        	{
        	   JOptionPane.showMessageDialog(contentPane, "Invalid Roll Number",
    	               "Error",JOptionPane.ERROR_MESSAGE );
        	}
        return flag;
	}
	boolean check_username()
	{
		if(txtusername.getText().equals(""))
		{
			JOptionPane.showMessageDialog(contentPane, "Invalid UserName",
		               "Error",JOptionPane.ERROR_MESSAGE );
			return false;
		}
		else
			{
			  return true;
			}
	}
	boolean check_password()
	{
		boolean flag=false;
		boolean capital=false;
		boolean small=false;
		boolean special=false;
		boolean number=false;
		boolean equal=false;
		if (txtpassword.getText().equals("") ) {
	        	JOptionPane.showMessageDialog(contentPane, "Enter password",
			               "Error",JOptionPane.ERROR_MESSAGE );
	            return false;
	        }
		 if((txtpassword.getText().length()!=8))
		 {
			 JOptionPane.showMessageDialog(contentPane, "Password length must be 8",
		               "Error",JOptionPane.ERROR_MESSAGE );
          return false;
		 }
	        for (int i = 0; i <txtpassword.getText().length()  ; i++)
	        {
	            char c=txtpassword.getText().charAt(i);
	            if ((c>='A' && c<='Z')) 
	            {
	            	capital=true;
	            }
	            if((c>='a' && c<='z'))
	                {
	            	small=true;
	                }
	            if(((c>='!' && c<='/') || (c>=':' && c<='@')))
	                	{
	    	            	special=true;
	                	}
	            if((c>='0' && c<='9'))
	                		{
	        	            	number=true;
	                		}

	           if(txtpassword.getText().equals(txtcpassword.getText()))
	        	       		 {
	        	       			 equal=true;
	        	       		 }
	        	    else
	        	    		 {
	        	    		        JOptionPane.showMessageDialog(contentPane, "Confirm password must be same",
	        	    			               "Error",JOptionPane.ERROR_MESSAGE );
	        	    		        return false;
	        	    		 }
	           if(capital && small && number && special && equal)
	           {
	        	   flag=true;
	           }
	                		
	        }
		 if(flag==false)
		 {
		        JOptionPane.showMessageDialog(contentPane, "Invalid Password",
			               "Error",JOptionPane.ERROR_MESSAGE );
		 }
	        return flag;
		 
	}
	boolean check_checkbox()
	{
		if(cbx.isSelected())
		{
			return true;
		}
		else
		{
			JOptionPane.showMessageDialog(contentPane, "Please accept terms and conditions",
		               "Error",JOptionPane.ERROR_MESSAGE );
		}
		return false;
	}


}
