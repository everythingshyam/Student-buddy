package com.sbuddy.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sbuddy.dbrepository.CRUDRepository;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage {

	private JFrame frame;
	private JTextField emailField;
	private JTextField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
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
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 799, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Buddy");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setBounds(259, 10, 283, 61);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(145, 106, 528, 248);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel emailLabel = new JLabel("E-Mail");
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		emailLabel.setBounds(62, 36, 113, 25);
		panel.add(emailLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		passwordLabel.setBounds(62, 94, 113, 25);
		panel.add(passwordLabel);
		
		emailField = new JTextField();
		emailField.setBounds(207, 36, 246, 19);
		panel.add(emailField);
		emailField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBounds(207, 94, 246, 19);
		panel.add(passwordField);
		
		JButton loginBtn = new JButton("Log In");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email=emailField.getText();
				String password=passwordField.getText();
				
				int uid =CRUDRepository.getLoginUID(email,password);
				if(uid>0)
				{
					loginUID=uid;
					window.frame.setVisible(false);
					//takes to Main Content Page
					frame.getContentPane().setLayout(null);
					frame.setContentPane(getMainContentContainer());
					window.frame.setVisible(true);
				}
					
			}
		});
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginBtn.setBounds(329, 156, 85, 21);
		panel.add(loginBtn);
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				emailField.setText("");
				passwordField.setText("");
			}
		});
		clearBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		clearBtn.setBounds(90, 156, 85, 21);
		panel.add(clearBtn);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.frame.setVisible(false);
				//takes to First Page
				frame.getContentPane().setLayout(null);
				frame.setContentPane(getMainContainer());
				window.frame.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(10, 432, 85, 21);
		frame.getContentPane().add(btnBack);
	}
}
