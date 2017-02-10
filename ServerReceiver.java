package ass2;

import java.io.BufferedReader;
import java.io.IOException;

public class ServerReceiver extends Thread {
	private ServerSender sender;
	private String userName;
	private BufferedReader fromClient;
	private LoggedUsers activeUsers;

	
	public ServerReceiver(ServerSender sender, String userName, BufferedReader fromClient, LoggedUsers activeUsers) {
		this.sender = sender;
		this.userName = userName;
		this.fromClient = fromClient;
		this.activeUsers = activeUsers;
	}
	
	
	@Override
	public void run(){
		sender.start();
		try{
			while(true){
				String action = fromClient.readLine();
				
				if (action.equals("logout") || action.equals("quit")){
					activeUsers.logout(userName);
					System.out.println(userName + " logged out");
					sender.sendInfo("You have logged out");
					sender.interrupt();
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
		sender.interrupt();
		
	
		
	}


}
