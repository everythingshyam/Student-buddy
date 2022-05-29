package com.sbuddy.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.sbuddy.dbrepository.CRUDRepository;
import com.sbuddy.entity.Student;

public class SignUpPage {

	private JFrame frame;
	private JTextField nameField;
	private JTextField emailField;
	private JTextField contactField;
	private JTextField addressField;
	private JTextField statusField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SignUpPage window = new SignUpPage();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the application.
	 */
//	public SignUpPage() {
//		initialize();
//	}

	/**
	 * Initialize the contents of the frame.
	 */
	public JFrame getSignUpFrame() {
		frame = new JFrame();
		frame.setBounds(100, 100, 760, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Buddy");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setBounds(213, 10, 283, 61);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Student Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(352, 81, 393, 282);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nameLabel.setBounds(10, 34, 96, 22);
		panel.add(nameLabel);
		
		JLabel emailLabel = new JLabel("E-Mail");
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		emailLabel.setBounds(10, 80, 96, 22);
		panel.add(emailLabel);
		
		JLabel contactLabel = new JLabel("Contact");
		contactLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contactLabel.setBounds(10, 123, 96, 22);
		panel.add(contactLabel);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		addressLabel.setBounds(10, 163, 96, 22);
		panel.add(addressLabel);
		
		nameField = new JTextField();
		nameField.setBounds(127, 34, 236, 22);
		panel.add(nameField);
		nameField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(127, 80, 236, 22);
		panel.add(emailField);
		
		contactField = new JTextField();
		contactField.setColumns(10);
		contactField.setBounds(127, 123, 236, 22);
		panel.add(contactField);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(127, 163, 236, 22);
		panel.add(addressField);
		
		JButton saveBtn = new JButton("Sign Up");
		saveBtn.setBackground(Color.GREEN);
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveStudent();
			}
		});
		saveBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		saveBtn.setBounds(251, 220, 112, 21);
		panel.add(saveBtn);
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.setBackground(Color.RED);
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAll();
			}
		});
		clearBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		clearBtn.setBounds(10, 220, 85, 21);
		panel.add(clearBtn);
		
		JButton exitBtn = new JButton("Exit");
		exitBtn.setBounds(661, 463, 85, 21);
		frame.getContentPane().add(exitBtn);
		exitBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 81, 330, 282);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Fill the details to sign up...");
		lblNewLabel_2.setBounds(10, 10, 203, 35);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Status", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 55, 310, 217);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		statusField = new JTextField();
		statusField.setText("NIL");
		statusField.setBounds(10, 22, 290, 185);
		panel_2.add(statusField);
		statusField.setColumns(10);
		
		JButton backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//takes to MainFrame
				frame.getContentPane().setLayout(null);
				frame=new MainFrame().getMainFrame();
			}
		});
		backBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backBtn.setBounds(10, 465, 85, 21);
		frame.getContentPane().add(backBtn);
		
		return frame;
	}
	
	private void saveStudent()
	{
		String name=nameField.getText();
		String email=emailField.getText();
		String contact=contactField.getText();
		String address=addressField.getText();
		
		Student student=new Student(name,email,contact,address);
		CRUDRepository.saveStudent(student);
		
		statusField.setText("Sign Up Successful\n Go back to Log In Page.");
	}
	
	private void clearAll() {
		nameField.setText("");
		emailField.setText("");
		contactField.setText("");
		addressField.setText("");
	}

}
