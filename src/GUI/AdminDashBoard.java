package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class AdminDashBoard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashBoard frame = new AdminDashBoard();
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
	public AdminDashBoard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1280,720 );
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("University Bus MS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Heading", Font.BOLD, 50));
		lblNewLabel.setBounds(370, 10, 479, 63);
		contentPane.add(lblNewLabel);
		
		JLabel lblMangeBus = new JLabel("Manage Buses");
		lblMangeBus.setHorizontalAlignment(SwingConstants.CENTER);
		lblMangeBus.setFont(new Font("Sitka Heading", Font.PLAIN, 30));
		lblMangeBus.setBounds(45, 456, 308, 44);
		contentPane.add(lblMangeBus);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image Im=new ImageIcon(this.getClass().getResource("/managebus.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(Im));
		lblNewLabel_1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/managebus.png")).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminManageBus ad=new AdminManageBus();
				ad.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1.setBounds(45, 155, 308, 255);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FeedbackFormView ff=new FeedbackFormView();
				ff.setVisible(true);
				dispose();
			}
		});
		Image Im2=new ImageIcon(this.getClass().getResource("/viewfeedback.png")).getImage();
		lblNewLabel_1_1.setIcon(new ImageIcon(Im2));
		lblNewLabel_1_1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/viewfeedback.png")).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(452, 155, 308, 255);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MaintenanceFormView mv=new MaintenanceFormView();
				mv.setVisible(true);
				dispose();
			}
		});
		Image Im3=new ImageIcon(this.getClass().getResource("/mform.jpg")).getImage();
		lblNewLabel_1_1_1.setIcon(new ImageIcon(Im3));
		lblNewLabel_1_1_1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/mform.jpg")).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));	
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(876, 155, 308, 255);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblViewFeedback = new JLabel("View Feedbacks");
		lblViewFeedback.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewFeedback.setFont(new Font("Sitka Heading", Font.PLAIN, 30));
		lblViewFeedback.setBounds(452, 456, 308, 44);
		contentPane.add(lblViewFeedback);
		
		JLabel lblViewMaintenecesReq = new JLabel("View Maintenance requests");
		lblViewMaintenecesReq.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewMaintenecesReq.setFont(new Font("Sitka Heading", Font.PLAIN, 30));
		lblViewMaintenecesReq.setBounds(858, 456, 376, 44);
		contentPane.add(lblViewMaintenecesReq);
		
		JLabel lblNewLabel_2 = new JLabel("Admin Dashboard");
		lblNewLabel_2.setFont(new Font("Sitka Heading", Font.BOLD, 24));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(380, 61, 469, 63);
		contentPane.add(lblNewLabel_2);
		
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
		btnNewButton.setBounds(10, 10, 126, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBounds(21, 611, 126, 38);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Bus Details");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Viewbusdetails vd=new Viewbusdetails();
				vd.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(1030, 605, 171, 44);
		contentPane.add(btnNewButton_2);
	}

}
