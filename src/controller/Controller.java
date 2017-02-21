package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import backend.Client;
import frontend.View;

public class Controller {
	
	private View view;
	public Client client;
	
	boolean truefalse = false;
	
	
	public Controller(Client client, View view){
		this.view = view;
		this.client = client;
		this.view.loginListener(new login());
		this.view.loginLabelListener(new loginLabel());
		this.view.registerListener(new register());
		this.view.registerLabelListener(new registerLabel());
		
		
	}
	
	public void launchChat(){
		while(client.receiver.eHandler.getLogged() == false){
			
			if(client.receiver.eHandler.getLogged() == true){
				view.chat();
				break;
			}
		}
	}
	class login implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
			client.send("login");
			client.send(view.lPanel.userField.getText());
			client.send(view.lPanel.pwField.getText());			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if(client.receiver.eHandler.getLogged()==true){
				view.chat();
			}
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
	class loginLabel implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			 if (truefalse == true){
				truefalse = false;
				view.login();
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
	class register implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(view.rPanel.pwField1.getText().equals(view.rPanel.pwField2.getText())){
				client.send("register");
				client.send(view.rPanel.userField.getText());
				client.send(view.rPanel.pwField1.getText());
			}
		}
		
	}
	class registerLabel implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			if (truefalse == false){
				truefalse = true;
				view.register();
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

}
