package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import backend.Client;
import backend.Printer;
import frontend.View;

public class Controller{
	
	private View view;
	public Client client;
	boolean truefalse = false;
	private Printer printer;
	
	public Controller(Client client, View view){
		this.view = view;
		this.client = client;
		this.view.loginListener(new login());
		this.view.loginLabelListener(new loginLabel());
		this.view.registerListener(new register());
		this.view.registerLabelListener(new registerLabel());
		this.view.quit(new quit());
		this.view.logoutListener(new logout());
		this.view.sendListener(new send());
		run();
	}
	
	public void run(){
		printer = new Printer(client , view);
		printer.setDaemon(false);
		printer.start();
		client.start();
		
		try {
			printer.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class login implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
		}
		@Override
		public void mousePressed(MouseEvent e) {
			client.receiver.eHandler.setAll(false);
			try{
				
				client.send("login");
				client.send(view.lPanel.userField.getText());
				client.send(view.lPanel.pwField.getText());		
				view.lPanel.serverResponse.setText("");
				view.lPanel.userField.setText("");
				view.lPanel.pwField.setText("");
			} catch (NullPointerException f){
				System.out.println("Server is dead");
				view.lPanel.serverResponse.setText("You are disconected");
			}
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			try{
				
				if(client.receiver.eHandler.getLogged()==true){
					view.chat();
				}
				if(client.receiver.eHandler.getWrong())
					view.lPanel.serverResponse.setText("Wrong credentials");
				
				if(client.receiver.eHandler.getAlready()){
					view.lPanel.serverResponse.setText("You are already connected");
				}
			}catch (NullPointerException g){}
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
	class loginLabel implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			 if (truefalse == true){
				truefalse = false;
				view.login();
				view.rPanel.serverResponse.setText("");
				view.rPanel.userField.setText("");
				view.rPanel.pwField1.setText("");
				view.rPanel.pwField2.setText("");
			}
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
	class register implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
		}
		@Override
		public void mousePressed(MouseEvent e) {
			client.receiver.eHandler.setAll(false);
			try{
				if(view.rPanel.pwField1.getText().equals(view.rPanel.pwField2.getText())){
					client.send("register");
					client.send(view.rPanel.userField.getText());
					client.send(view.rPanel.pwField1.getText());
				}
				else view.rPanel.serverResponse.setText("Passwords do not match");
				
			}catch (NullPointerException g){
				System.out.println("Server is dead");
				view.rPanel.serverResponse.setText("You are disconected");
			}
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			try{
				if(client.receiver.eHandler.getRegistered()==true){
					view.login();
				}
				if(client.receiver.eHandler.getExistentUser()){
					view.rPanel.serverResponse.setText("This name is taken");
				}
				if(client.receiver.eHandler.getShortPassword()){
					view.rPanel.serverResponse.setText("Password too short");
				}
			}catch (NullPointerException g){}
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
	class registerLabel implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			if (truefalse == false){
				truefalse = true;
				view.register();
				view.lPanel.serverResponse.setText("");
				view.lPanel.userField.setText("");
				view.lPanel.pwField.setText("");
			}
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
	class quit implements WindowListener{
		@Override
		public void windowOpened(WindowEvent e) {
		}
		@Override
		public void windowClosing(WindowEvent e) {
			client.send("quit");
		}
		@Override
		public void windowClosed(WindowEvent e) {
			
		}
		@Override
		public void windowIconified(WindowEvent e) {
		}
		@Override
		public void windowDeiconified(WindowEvent e) {
		}
		@Override
		public void windowActivated(WindowEvent e) {
		}
		@Override
		public void windowDeactivated(WindowEvent e) {
		}
	}
	class logout implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			client.send("logout");
			view.logout();
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}
	}
	class setTarget implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}
		
	}
	
	class send implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			client.send("message");
			client.send(view.cPanel.target);
			client.send(view.cPanel.messageEntry.getText());
			view.cPanel.messageEntry.setText("");
		}
		
	}
}
