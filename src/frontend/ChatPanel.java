package frontend;

import java.awt.Color;

import javax.swing.*;

public class ChatPanel extends JPanel {
	
	public JLabel userLabel = new JLabel("User");
	public JLabel passwordLabel = new JLabel("Password");
	public JLabel serverResponse = new JLabel("");
	public JTextField userField = new JTextField();	
	public JTextField pwField = new JTextField();
	public JButton loginButton = new JButton("Login");
	public JLabel noAcc = new JLabel("No account?");
	public JLabel register = new JLabel("<HTML><U>Register</U></HTML>");
	
	public ChatPanel(){
		this.setForeground(Color.RED);
		this.setBackground(Color.DARK_GRAY);
		this.setBounds(0, 0, 831, 438);
		this.setLayout(null);
		
	}

}
