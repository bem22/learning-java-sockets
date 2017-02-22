package frontend;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;

import javax.swing.*;

public class View extends JFrame{
	
	public LoginPanel lPanel = new LoginPanel();
	public RegisterPanel rPanel = new RegisterPanel();
	public ChatPanel cPanel = new ChatPanel();
	
	public View(){
		initialize();
		this.setVisible(true);
	}
	
	public void initialize(){
		this.getContentPane().setLayout(null);
		this.setBounds(100, 100, 847, 477);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.getContentPane().add(lPanel);
		this.getContentPane().add(rPanel);
		
		rPanel.setVisible(false);
		lPanel.setVisible(true);
	}
	
	public void register(){
		lPanel.setVisible(false);
		rPanel.setVisible(true);
	}
	
	public void login(){
		rPanel.setVisible(false);
		lPanel.setVisible(true);
	}
	
	public void chat(){
		this.getContentPane().add(cPanel);
		lPanel.setVisible(false);
		rPanel.setVisible(false);
		cPanel.setVisible(true);
	}
	
	public void logout(){
		this.getContentPane().remove(cPanel);
		lPanel.setVisible(true);
	}
	
	public void loginListener(MouseListener listenForLogin){
		lPanel.loginButton.addMouseListener(listenForLogin);
	}
	public void loginLabelListener(MouseListener listenForLogin){
		rPanel.toLogin.addMouseListener(listenForLogin);
	}
	
	public void registerListener(MouseListener listenForRegister){
		rPanel.registerButton.addMouseListener(listenForRegister);
	}
	
	public void registerLabelListener(MouseListener listenForRegister){
		lPanel.toRegister.addMouseListener(listenForRegister);
	}
	
	public void quit(WindowListener listenForX){
		this.addWindowListener(listenForX);
	}
	
	public void logoutListener(MouseListener listenForLogout){
		cPanel.logoutButton.addMouseListener(listenForLogout);
	}
	
	public void sendListener(ActionListener listenForSend){
		cPanel.sendButton.addActionListener(listenForSend);
	}
	
	
	
}
