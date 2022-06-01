package com.sbuddy.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import com.sbuddy.dbrepository.CRUDRepository;
import com.sbuddy.entity.Shop;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class ShopSignupPanel {

	JFrame frame;
	private JTextField shopNameField;
	private JTextField ownerNameField;
	private JTextField emailField;
	private JTextField contactField;
	private JTextField xCoordinateField;
	private JTextField yCoordinateField;
	private JTextField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopSignupPanel window = new ShopSignupPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public ShopSignupPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100,800,540);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//All the common GUI elements here
		Container container=new Container();
		container.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Buddy");
		lblNewLabel.setBounds(244, -7, 283, 61);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		container.add(lblNewLabel);
		
		JButton exitBtn = new JButton("Exit");
		exitBtn.setBounds(661, 21, 85, 21);
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CRUDRepository.commit();
				System.exit(0);//to close the program
			}
		});
		exitBtn.setBackground(Color.RED);
		exitBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		container.add(exitBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Your Virtual Guardian, away from home");
		lblNewLabel_1.setBounds(277, 48, 334, 21);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		container.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Shop Sign Up", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 80, 766, 423);
		panel.setLayout(null);
		
		JLabel shopNameLabel = new JLabel("Shop Name");
		shopNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		shopNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		shopNameLabel.setBounds(178, 43, 113, 20);
		panel.add(shopNameLabel);
		
		shopNameField = new JTextField();
		shopNameField.setBounds(321, 44, 261, 19);
		panel.add(shopNameField);
		shopNameField.setColumns(10);
		
		JLabel emailLabel = new JLabel("E-Mail");
		emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emailLabel.setBounds(178, 105, 113, 20);
		panel.add(emailLabel);
		
		JLabel contactLabel = new JLabel("Contact");
		contactLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		contactLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contactLabel.setBounds(178, 133, 113, 20);
		panel.add(contactLabel);
		
		JLabel xCoordinateLabel = new JLabel("X Coordinate");
		xCoordinateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		xCoordinateLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xCoordinateLabel.setBounds(178, 189, 113, 20);
		panel.add(xCoordinateLabel);
		
		JLabel yCoordinateLabel = new JLabel("Y Coordinate");
		yCoordinateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		yCoordinateLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		yCoordinateLabel.setBounds(178, 219, 113, 20);
		panel.add(yCoordinateLabel);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(321, 106, 261, 19);
		panel.add(emailField);
		
		contactField = new JTextField();
		contactField.setColumns(10);
		contactField.setBounds(321, 133, 261, 19);
		panel.add(contactField);
		
		xCoordinateField = new JTextField();
		xCoordinateField.setColumns(10);
		xCoordinateField.setBounds(321, 191, 261, 19);
		panel.add(xCoordinateField);
		
		yCoordinateField = new JTextField();
		yCoordinateField.setColumns(10);
		yCoordinateField.setBounds(321, 220, 261, 19);
		panel.add(yCoordinateField);
		
		JButton signupBtn = new JButton("Sign Up");
		
		signupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String shopName=shopNameField.getText();
				String ownerName=ownerNameField.getText();
				String email=emailField.getText();
				String contact=contactField.getText();
				String password=passwordField.getText();
				int xCoordinate=Integer.parseInt(xCoordinateField.getText());
				int yCoordinate=Integer.parseInt(yCoordinateField.getText());
				
				Shop shop=new Shop(shopName,ownerName,email,contact,password,xCoordinate,yCoordinate);
				
				CRUDRepository.saveShop(shop);
			}
		});
		signupBtn.setBackground(Color.GREEN);
		signupBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		signupBtn.setBounds(478, 254, 104, 25);
		panel.add(signupBtn);
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shopNameField.setText("");
				ownerNameField.setText("");
				emailField.setText("");
				contactField.setText("");
				passwordField.setText("");
				xCoordinateField.setText("");
				yCoordinateField.setText("");
			}
		});
		clearBtn.setBackground(Color.RED);
		clearBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		clearBtn.setBounds(256, 254, 104, 25);
		panel.add(clearBtn);
		
		JButton btnNotAShopOwner = new JButton("Not A Shop Owner? Sign up as Student");
		btnNotAShopOwner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignupPanel.main(null);
			}
		});
		btnNotAShopOwner.setToolTipText("takes to Student Sign Up Page");
		btnNotAShopOwner.setBackground(Color.YELLOW);
		btnNotAShopOwner.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNotAShopOwner.setBounds(485, 388, 271, 25);
		panel.add(btnNotAShopOwner);
		
		container.add(panel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordLabel.setBounds(178, 163, 113, 20);
		panel.add(passwordLabel);
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBounds(321, 162, 261, 19);
		panel.add(passwordField);
		
		ownerNameField = new JTextField();
		ownerNameField.setColumns(10);
		ownerNameField.setBounds(321, 77, 261, 19);
		panel.add(ownerNameField);
		
		JLabel ownerNameLabel = new JLabel("Owner Name");
		ownerNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ownerNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ownerNameLabel.setBounds(178, 75, 113, 20);
		panel.add(ownerNameLabel);
		
		frame.setContentPane(container);
		//GUI Common elements over.
	}
}
