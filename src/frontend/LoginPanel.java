package frontend;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class LoginPanel extends JPanel {
	
	public JLabel userLabel = new JLabel("User");
	public JLabel passwordLabel = new JLabel("Password");
	public JLabel serverResponse = new JLabel("");
	public JTextField userField = new JTextField();	
	public JTextField pwField = new JTextField();
	public JButton loginButton = new JButton("Login");
	public JLabel noAcc = new JLabel("No account?");
	public JLabel toRegister = new JLabel("<HTML><U>Register</U></HTML>");
	
	public LoginPanel(){
		this.setForeground(Color.RED);
		this.setBackground(Color.DARK_GRAY);
		this.setBounds(0, 0, 831, 438);
		this.setLayout(null);
		
		userLabel.setBounds(308, 152, 88, 14);
		userLabel.setForeground(Color.WHITE);
		userLabel.setBackground(Color.DARK_GRAY);
		this.add(userLabel);
		
		passwordLabel.setBounds(308, 183, 88, 14);
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setBackground(Color.DARK_GRAY);
		this.add(passwordLabel);
		
		serverResponse.setBounds(315, 223, 158, 14);
		serverResponse.setHorizontalAlignment(SwingConstants.CENTER);
		serverResponse.setForeground(Color.RED);
		this.add(serverResponse);
		
		userField.setBounds(406, 149, 86, 20);
		userField.setForeground(Color.WHITE);
		userField.setColumns(10);
		userField.setBackground(Color.DARK_GRAY);
		this.add(userField);
		
		pwField.setBounds(406, 180, 86, 20);
		pwField.setForeground(Color.WHITE);
		pwField.setColumns(10);
		pwField.setBackground(Color.DARK_GRAY);
		this.add(pwField);
	
		loginButton.setBounds(350, 265, 89, 23);
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(Color.DARK_GRAY);
		this.add(loginButton);
		
		noAcc.setBounds(338, 340, 74, 14);
		noAcc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		noAcc.setForeground(Color.WHITE);
		this.add(noAcc);
		
		toRegister.setBounds(403, 332, 48, 30);
		toRegister.setForeground(Color.WHITE);
		toRegister.setBackground(Color.DARK_GRAY);
		toRegister.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.add(toRegister);
	}
	
	
	
	
	

	
	
}
