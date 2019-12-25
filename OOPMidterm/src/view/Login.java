package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MainController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private MainController controller = MainController.getMainController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("OOP Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(96, 40, 165, 69);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(12, 138, 104, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBounds(12, 196, 104, 30);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(133, 144, 165, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(133, 202, 165, 22);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(164, 264, 97, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Stores user input into a string
				String username = textField.getText();
				String password = passwordField.getText();
				
				//sends the user input to controller class to check wether its true
				if(controller.verifyLogin(username, password)) {
					//if true display this
					JOptionPane.showMessageDialog(null, "Login Successful");
					//Open a new Window using the userdetails class
					UserDetails frame = new UserDetails();
					//set that frame to visible
					frame.setVisible(true);
					//delete this frame
					dispose();
				
				}else {
					//Display this message if no user matches within the list
					JOptionPane.showMessageDialog(null, "No User Found");
					// Open new Window from registration class 
					Registration frame = new Registration();
					//set visible
					frame.setVisible(true);


				}
				
				
				
			}
		});
		contentPane.add(btnNewButton);
	}
}
