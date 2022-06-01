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
import com.sbuddy.entity.Student;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class SignupPanel {

	JFrame frame;
	private JTextField nameField;
	private JTextField emailField;
	private JTextField contactField;
	private JTextField addressField;
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
					SignupPanel window = new SignupPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignupPanel() {
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
		
		//commented back button as its not working the way I want
		//TODO make it work
//		JButton backBtn = new JButton("Back");
//		backBtn.setBounds(10, 21, 85, 21);
//		backBtn.setBackground(Color.LIGHT_GRAY);
//		backBtn.setForeground(Color.BLACK);
//		backBtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//TODO code to go to mainframe
//				MainFrame.main(null);
//			}
//		});
//		backBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		container.add(backBtn);
		
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
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Student Sign Up", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 80, 766, 423);
		panel.setLayout(null);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameLabel.setBounds(178, 43, 113, 20);
		panel.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(321, 44, 261, 19);
		panel.add(nameField);
		nameField.setColumns(10);
		
		JLabel emailLabel = new JLabel("E-Mail");
		emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emailLabel.setBounds(178, 73, 113, 20);
		panel.add(emailLabel);
		
		JLabel contactLabel = new JLabel("Contact");
		contactLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		contactLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contactLabel.setBounds(178, 103, 113, 20);
		panel.add(contactLabel);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addressLabel.setBounds(178, 133, 113, 20);
		panel.add(addressLabel);
		
		JLabel xCoordinateLabel = new JLabel("X Coordinate");
		xCoordinateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
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
		emailField.setBounds(321, 73, 261, 19);
		panel.add(emailField);
		
		contactField = new JTextField();
		contactField.setColumns(10);
		contactField.setBounds(321, 104, 261, 19);
		panel.add(contactField);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(321, 133, 261, 19);
		panel.add(addressField);
		
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
				String name=nameField.getText();
				String email=emailField.getText();
				String contact=contactField.getText();
				String address=addressField.getText();
				String password=passwordField.getText();
				int xCoordinate=Integer.parseInt(xCoordinateField.getText());
				int yCoordinate=Integer.parseInt(yCoordinateField.getText());
				
				Student student=new Student(name,email,contact,address,password,xCoordinate,yCoordinate);
				
				CRUDRepository.saveStudent(student);
			}
		});
		signupBtn.setBackground(Color.GREEN);
		signupBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		signupBtn.setBounds(478, 254, 104, 25);
		panel.add(signupBtn);
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameField.setText("");
				emailField.setText("");
				contactField.setText("");
				addressField.setText("");
				passwordField.setText("");
				xCoordinateField.setText("");
				yCoordinateField.setText("");
			}
		});
		clearBtn.setBackground(Color.RED);
		clearBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		clearBtn.setBounds(256, 254, 104, 25);
		panel.add(clearBtn);
		
		JButton btnNotAStudent = new JButton("Not A Student? Sign up as Shop Owner");
		btnNotAStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShopSignupPanel.main(null);
			}
		});
		btnNotAStudent.setBackground(Color.YELLOW);
		btnNotAStudent.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNotAStudent.setBounds(485, 388, 271, 25);
		panel.add(btnNotAStudent);
		
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
		
		frame.setContentPane(container);
		//GUI Common elements over.
	}
}
