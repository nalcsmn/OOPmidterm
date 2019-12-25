package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import controller.MainController;
public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	MainController controller = MainController.getMainController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(89, 27, 248, 77);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New Username:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(32, 128, 146, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewPassword.setBounds(32, 174, 146, 31);
		contentPane.add(lblNewPassword);
		
		JLabel lblVerifyPassword = new JLabel("Verify Password:");
		lblVerifyPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVerifyPassword.setBounds(32, 218, 146, 31);
		contentPane.add(lblVerifyPassword);
		
		textField = new JTextField();
		textField.setBounds(176, 133, 195, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(176, 179, 195, 22);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(176, 223, 195, 22);
		contentPane.add(passwordField_1);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(176, 278, 97, 25);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = textField.getText();
				
				if(passwordField.getText().equals(passwordField_1.getText())) {
					String password = passwordField.getText();
					
					//goes to maincontroller with user input to add to list
					if(controller.addPerson(username, password))
						//deletes this page
						dispose();
				}
			}
		});
		contentPane.add(btnSubmit);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(284, 278, 97, 25);
		contentPane.add(btnExit);
	}

}
