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

public class UserDetails extends JFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField mname;
	private JTextField lname;
	private JTextField age;
	private JTextField address;
	private JTextField number;
	private MainController controller = MainController.getMainController();

	public UserDetails() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		
		JLabel lblNewLabel = new JLabel("User Details");
		lblNewLabel.setFont(new Font("Constantia", Font.BOLD, 35));
		lblNewLabel.setBounds(106, 37, 226, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFirstName.setBounds(44, 134, 87, 16);
		contentPane.add(lblFirstName);
		
		JLabel lblMiddleName = new JLabel("Middle Name:");
		lblMiddleName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMiddleName.setBounds(44, 163, 100, 16);
		contentPane.add(lblMiddleName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLastName.setBounds(44, 192, 87, 16);
		contentPane.add(lblLastName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAge.setBounds(44, 221, 58, 16);
		contentPane.add(lblAge);
		
		fname = new JTextField();
		fname.setBounds(162, 132, 226, 22);
		contentPane.add(fname);
		fname.setColumns(10);
		
		mname = new JTextField();
		mname.setColumns(10);
		mname.setBounds(162, 161, 226, 22);
		contentPane.add(mname);
		
		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(162, 190, 226, 22);
		contentPane.add(lname);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(162, 219, 226, 22);
		contentPane.add(age);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setBounds(44, 250, 87, 16);
		contentPane.add(lblAddress);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(162, 251, 226, 22);
		contentPane.add(address);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(162, 336, 97, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Puts the inputs into a string
				String firstname = fname.getText();
				String middlename = mname.getText();
				String lastname = lname.getText();
				int Age = Integer.valueOf(age.getText());
				String Address = address.getText();
				int Number = Integer.valueOf(number.getText());;
				
				//sends user inputs to maincontroller class addDetails method
				controller.addDetails(firstname, middlename, lastname, Address, Number, Age);	
				
				//goes to maincontroller class data method
				controller.data();
				Prymid py = new Prymid();
				py.setVisible(true);
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(291, 336, 97, 25);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//delete this frame/ close
				dispose();
				//open the login screen
				Login l = new Login();
			}
		});
		contentPane.add(btnExit);
		
		JLabel FavoriteNumberlbl = new JLabel("Favorite Number:");
		FavoriteNumberlbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		FavoriteNumberlbl.setBounds(44, 288, 106, 16);
		contentPane.add(FavoriteNumberlbl);
		
		number = new JTextField();
		number.setColumns(10);
		number.setBounds(162, 286, 226, 22);
		contentPane.add(number);
	}

}
