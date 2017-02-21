package frontend;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.*;

public class View extends JFrame{
	
	public LoginPanel lPanel = null;
	public RegisterPanel rPanel = null;
	public ChatPanel cPanel = null;
	
	public View(){
		initialize();
		this.setVisible(true);
	}
	
	public void initialize(){
		this.getContentPane().setLayout(null);
		this.setBounds(100, 100, 847, 477);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		lPanel = new LoginPanel();
		this.getContentPane().add(lPanel);
		rPanel = new RegisterPanel();
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
		cPanel = new ChatPanel();
		this.getContentPane().add(cPanel);
		
		lPanel.setVisible(false);
		cPanel.setVisible(true);
	}
	
	public void loginListener(MouseListener listenForLogin){
		lPanel.loginButton.addMouseListener(listenForLogin);
	}
	public void loginLabelListener(MouseListener listenForLogin){
		rPanel.toLogin.addMouseListener(listenForLogin);
	}
	
	public void registerListener(ActionListener listenForRegister){
		rPanel.registerButton.addActionListener(listenForRegister);
	}
	
	public void registerLabelListener(MouseListener listenForRegister){
		lPanel.toRegister.addMouseListener(listenForRegister);
	}
	
}
