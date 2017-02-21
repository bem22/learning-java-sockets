package frontend;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegisterPanel extends JPanel {
	public JLabel userLabel = new JLabel("User");
	public JLabel passwordLabel1 = new JLabel("Password");
	public JLabel passwordLabel2 = new JLabel("Re-type Password");
	public JLabel serverResponse = new JLabel("");
	public JTextField userField = new JTextField();	
	public JTextField pwField1 = new JTextField("");
	public JTextField pwField2 = new JTextField();
	public JButton registerButton = new JButton("Register");
	public JLabel register = new JLabel("<HTML><U>Register</U></HTML>");
	public JLabel alrdy = new JLabel("Already have an account?");
	public JLabel toLogin = new JLabel("<HTML><U>Login</U></HTML>");
	
	public RegisterPanel(){
		this.setForeground(Color.RED);
		this.setBackground(Color.DARK_GRAY);
		this.setBounds(0, 0, 831, 438);
		this.setLayout(null);
		
		userLabel.setBounds(291, 152, 88, 14);
		userLabel.setForeground(Color.WHITE);
		this.add(userLabel);
		
		passwordLabel1.setBounds(291, 183, 105, 14);
		passwordLabel1.setForeground(Color.WHITE);
		this.add(passwordLabel1);
		
		passwordLabel2.setBounds(291, 214, 105, 14);
		passwordLabel2.setForeground(Color.WHITE);
		this.add(passwordLabel2);
		
		serverResponse.setToolTipText("serverResponse");
		serverResponse.setForeground(new Color(255, 0, 0));
		serverResponse.setBackground(Color.DARK_GRAY);
		serverResponse.setHorizontalAlignment(SwingConstants.CENTER);
		serverResponse.setBounds(291, 370, 201, 14);
		this.add(serverResponse);
		
		userField = new JTextField();
		userField.setBounds(406, 149, 86, 20);
		userField.setForeground(Color.WHITE);
		userField.setColumns(10);
		userField.setBackground(Color.DARK_GRAY);
		this.add(userField);
		
		pwField1.setForeground(Color.WHITE);
		pwField1.setColumns(10);
		pwField1.setBackground(Color.DARK_GRAY);
		pwField1.setBounds(406, 180, 86, 20);
		this.add(pwField1);
		
		pwField2.setForeground(Color.WHITE);
		pwField2.setColumns(10);
		pwField2.setBackground(Color.DARK_GRAY);
		pwField2.setBounds(406, 211, 86, 20);
		this.add(pwField2);
		
		registerButton.setForeground(Color.WHITE);
		registerButton.setBackground(Color.DARK_GRAY);
		registerButton.setBounds(291, 266, 201, 23);
		this.add(registerButton);
		
		alrdy.setBounds(305, 340, 664, 14);
		alrdy.setFont(new Font("Tahoma", Font.PLAIN, 11));
		alrdy.setForeground(Color.WHITE);
		this.add(alrdy);
		
		toLogin.setBounds(440, 332, 48, 30);
		toLogin.setForeground(Color.WHITE);
		toLogin.setBackground(Color.DARK_GRAY);
		toLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		this.add(toLogin);
		
		
		
	}
	

}
