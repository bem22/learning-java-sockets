package ass2;

import java.io.BufferedReader;
import java.io.IOException;

public class ServerReceiver extends Thread {
	private ServerSender sender;
	private String userName;
	private BufferedReader fromClient;
	private LoggedUsers activeUsers;
	private FLAG_logged logged;
	private FLAG_quit quit;

	
	public ServerReceiver(ServerSender sender, String userName, BufferedReader fromClient, LoggedUsers activeUsers, FLAG_logged logged, FLAG_quit quit) {
		this.sender = sender;
		this.userName = userName;
		this.fromClient = fromClient;
		this.activeUsers = activeUsers;
		this.logged = logged;
		this.quit = quit;
	}
	private void logout(){
	}
	private void quit(){
		logout();
		quit.setValue(true);
	}
	@Override
	public void run(){
		this.sender.start();
		try{
			while(!Thread.currentThread().isInterrupted()){
				String action = this.fromClient.readLine();
				
				if (action.equals("logout")){
					this.logged.setValue(false);
					System.out.println(userName + " logged out");
					this.activeUsers.logout(userName);
					this.sender.interrupt();
					Thread.currentThread().interrupt();
				}
				/////////////////////////////////////////////
				
				if(action.equals("message")){
					String recipient = fromClient.readLine();
						if(recipient!=null){
							if(activeUsers.isLogged(recipient)){
								String text = fromClient.readLine();
									if(text != null){
										Message msg = new Message(userName, text);
										MessageQueue recipientsQueue = activeUsers.getQueue(recipient);
							
										if(recipientsQueue != null)
											recipientsQueue.offer(msg);
									}
									else sender.sendInfo("Null text format");
							}
							else sender.sendInfo("User is offline.");
						}
						else sender.sendInfo("null recipient");
				}
				//////////////////////////////////////////////////////////
				
			}
		} catch (IOException e){}
		
	}
}
