package ass2;

import java.io.BufferedReader;
import java.io.IOException;

public class ServerReceiver extends Thread {
	
	private String userName;
	private BufferedReader fromClient;
	private LoggedUsers activeUsers;
	private ServerSender sender;
	
	public ServerReceiver(ServerSender sender, String userName, BufferedReader fromClient, LoggedUsers activeUsers) {
		this.userName = userName;
		this.fromClient = fromClient;
		this.activeUsers = activeUsers;
		this.sender = sender;
	}
	
	public void logout(){
		
		
	}
	
	public void quit(){
		
	}
	
	public void run(){
		try{
			while(true){
				String action = fromClient.readLine();
				
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
				
				else if(action.equals("quit")){
					
				}
				else if (action.equals("logout")){
					
				}
			}
		} catch (IOException e){}
		
	}

}
