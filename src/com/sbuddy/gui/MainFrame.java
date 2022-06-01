package com.sbuddy.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import com.sbuddy.dbrepository.CRUDRepository;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Container;

public class MainFrame {

	public JFrame frame;
	private static MainFrame window;
	private JPanel panel;
	
	private JTextField emailField;
	private JTextField passwordField;
	private static int loginUID=0;
	
	JButton backBtn = new JButton("Back");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
					window = new MainFrame();
					window.frame.setVisible(true);
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
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
		panel=new JPanel();
		panel.setLayout(null);
		
		//All the common GUI elements here
		Container container=new Container();
		container.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Buddy");
		lblNewLabel.setBounds(244, -7, 283, 61);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		container.add(lblNewLabel);
		
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(10, 21, 85, 21);
		backBtn.addActionListener(new ActionListener() {
			//TODO
			public void actionPerformed(ActionEvent e) {
				//code to ask if user wants to exit, then act accordingly
				System.out.println("Outermost back button worked.");
				window.frame.setVisible(false);
				initialize();
				window.frame.setVisible(true);
			}
		});
		backBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		container.add(backBtn);
		
		JButton exitBtn = new JButton("Exit");
		exitBtn.setBounds(661, 21, 85, 21);
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO code to ask for confirmation
				
				CRUDRepository.commit();
				System.exit(0);//to close the program
			}
		});
		exitBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		container.add(exitBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Your Virtual Guardian, away from home");
		lblNewLabel_1.setBounds(277, 48, 334, 21);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		container.add(lblNewLabel_1);
		//GUI Common elements over.

		//Designing the panel here
		panel=new JPanel();
		panel.setBounds(10, 80, 766, 423);
		panel.setLayout(null);
		
		JLabel emailLabel = new JLabel("E-Mail");
		emailLabel.setBounds(212, 94, 113, 25);
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(emailLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(189, 141, 113, 25);
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(passwordLabel);
		
		emailField = new JTextField();
		emailField.setBounds(292, 99, 246, 19);
		panel.add(emailField);
		emailField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(292, 141, 246, 19);
		passwordField.setColumns(10);
		panel.add(passwordField);
		
		JButton loginBtn = new JButton("Log In");
		loginBtn.setBounds(453, 191, 85, 21);
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email=emailField.getText();
				String password=passwordField.getText();
				
				int uid =CRUDRepository.getLoginUID(email,password);
				if(uid>0)
				{
					loginUID=uid;
					window.frame.setVisible(false);
					panel.removeAll();
					JLabel temp=new JLabel("Login Successful! UID="+loginUID);
					temp.setBounds(189, 141, 200, 25);
					temp.setFont(new Font("Tahoma", Font.BOLD, 16));
					panel.add(temp);
					window.frame.setVisible(true);
				}
				else
				{
					window.frame.setVisible(false);
					panel.removeAll();
					JLabel temp=new JLabel("Login Unsuccessful!");
					temp.setBounds(189, 141, 200, 25);
					temp.setFont(new Font("Tahoma", Font.BOLD, 16));
					panel.add(temp);
					window.frame.setVisible(true);
				}
					
			}
		});
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(loginBtn);
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.setBounds(344, 191, 85, 21);

		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				emailField.setText("");
				passwordField.setText("");
			}
		});
		clearBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(clearBtn);
		
		JButton signupBtn = new JButton("Sign Up");
		signupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO code to go to Sign up page
				SignupPanel.main(null);
			}
		});
		signupBtn.setBounds(212, 191, 102, 21);
		signupBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(signupBtn);
		container.add(panel);
		
		frame.setContentPane(container);
	}
	
}
