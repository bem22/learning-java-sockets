package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;


class message extends JLabel{
	public message(String text){
		this.setText(text);
		this.setPreferredSize(new Dimension(700,15));
		this.setBackground(Color.DARK_GRAY);
		this.setForeground(Color.white);
	}
}
public class ChatPanel extends JPanel {
	
		public String loggedUser = null;
		public static String target = "";
		public JButton logoutButton = new JButton("Logout");
		public JButton sendButton = new JButton("Send");
		public JPanel chat = new JPanel();
		public JTextField messageEntry = new JTextField();
		public JPanel onliners = new JPanel();
	
		public ChatPanel(){
			this.setForeground(Color.RED);
			this.setBackground(Color.DARK_GRAY);
			this.setBounds(0, 0, 831, 438);
			this.setLayout(null);
			
			logoutButton.setBounds(720, 11, 101, 23);
			logoutButton.setBackground(Color.DARK_GRAY);
			logoutButton.setForeground(Color.WHITE);
			this.add(logoutButton);
			
			onliners.setBackground(Color.GRAY);
			onliners.setBounds(720, 41, 101, 386);
			onliners.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			this.add(onliners);
			
			chat.setBounds(10, 11, 700, 334);
			chat.setBackground(Color.GRAY);
			chat.setBounds(10, 11, 700, 334);
			chat.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			this.add(chat);
			
			messageEntry.setForeground(new Color(255, 255, 255));
			messageEntry.setBackground(Color.GRAY);
			messageEntry.setBounds(10, 356, 614, 71);
			this.add(messageEntry);
			
			sendButton.setForeground(Color.WHITE);
			sendButton.setBackground(Color.GRAY);
			sendButton.setBounds(634, 356, 78, 71);
			this.add(sendButton);
		}
		
		public void listMessage(String text){
			chat.add(new message(text));
			chat.validate();
			chat.repaint();
		}
		
		public void resetUI(){
			loggedUser = null;
		}
		
		public void listall (String [] users){
			for(int i = 0; i < users.length; i++){
				if(!users[i].equals(loggedUser))
				onliners.add(new UserTag(users[i], target));
				onliners.validate();
				onliners.repaint();
			}
		}
		public void setTarget(String target){
			this.target = target;
		}
		
		public String getTarget(){
			return target;
		}
		
		

}
