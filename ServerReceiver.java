package ass2;

import java.io.BufferedReader;
import java.io.IOException;

public class ServerReceiver extends Thread {
	private ServerSender sender;
	private String userName;
	private BufferedReader fromClient;
	private LoggedUsers activeUsers;
	private FLAG_logged logged;

	
	public ServerReceiver(ServerSender sender, String userName, BufferedReader fromClient, LoggedUsers activeUsers, FLAG_logged logged) {
		this.sender = sender;
		this.userName = userName;
		this.fromClient = fromClient;
		this.activeUsers = activeUsers;
		this.logged = logged;
	}
	
	@Override
	public void run(){
		sender.start();
		try{
			while(true){
				String action = fromClient.readLine();
				
				if (action.equals("logout")){
					logged.setValue(false);
					
					System.out.println("User logged out");
					activeUsers.logout(userName);
					this.sender.interrupt();
					break;
				}
				
				
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
			}
			
		} catch (IOException e){}
		this.sender.interrupt();
	}
}
