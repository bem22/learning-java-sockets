package ass2;

import java.net.*;
import java.io.*;

public class Server {
	ServerSocket SSocket;
	Socket SCSocket;
	String text;
	public Server() {
		
		try {
			SSocket = new ServerSocket(Port.number);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void run(){
		
		
		UserCredentials namePassword = new UserCredentials(); // ALL REGISTERED USERS
		
		LoggedUsers activeUsers = new LoggedUsers(); // ALL LOGGED USERS (0 when the server starts)
		
		
		try{
			
			while(true){
				SCSocket = SSocket.accept();
				
				System.out.println("New client on server");
				
				BufferedReader fromClient = new BufferedReader(new InputStreamReader(SCSocket.getInputStream()));
				
				boolean logged = false;
				
				while(!logged){
					String action = fromClient.readLine();
					
					if(action.equals("login")){
						String userName = fromClient.readLine();
						String password = fromClient.readLine();
						if(namePassword.users.containsKey(userName)){
							if(!activeUsers.isLogged(userName)){
								if(namePassword.getPassword(userName).equals(password)){
								activeUsers.add(userName);
								System.out.println("User " + userName + " has logged in");
								}
							}
						}
					}
					
				}
				
				
				
				
				
				
			
				
			
				
			}
			
		}
		
		catch (IOException e){
			
		}
		
	}

}
