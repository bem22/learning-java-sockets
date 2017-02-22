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
				Thread.sleep(1230);
				view.cPanel.onliners.removeAll();
				if(client.receiver.eHandler.getPingReceived() && client.receiver.onlineUsers.length>0){
				client.receiver.eHandler.setPingReceived(false);
				view.cPanel.listall(client.receiver.onlineUsers);
				}
				
				if(client.receiver.eHandler.getMessaged()){
				view.cPanel.chat.add(new JLabel(client.receiver.message));
				client.receiver.eHandler.setMessaged(false);
				}
			}
			
		} catch (InterruptedException e) {}
	}
}
