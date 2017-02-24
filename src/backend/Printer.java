package backend;

import javax.swing.JLabel;

import frontend.View;

public class Printer extends Thread{
	Client client;
	View view;
	
	public Printer(Client client, View view){
		this.client = client;
		this.view = view;
		Thread.currentThread().setName("Printer");
	}
	public void run(){
		try {
			while(true){
				Thread.sleep(15);
				
				if(!client.receiver.messages.isEmpty())
				view.cPanel.listMessage(client.receiver.messages.take());
				
				if(client.receiver.eHandler.getPingReceived() && client.receiver.onlineUsers.length>0){
					view.cPanel.onliners.removeAll();
					view.cPanel.listall(client.receiver.onlineUsers);
				}
			}
			
		} catch (InterruptedException e) {}
	}
}
