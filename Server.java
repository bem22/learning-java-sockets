package ass2;

import java.net.*;
import java.io.*;

public class Server {
	ServerSocket SSocket;
	Socket SCSocket;

	public Server() {
		
		try {
			SSocket = new ServerSocket(Port.number);
			
		} catch (IOException e) {
		}
	}
	
	
	public void run(){
		
		
		UserCredentials namePassword = new UserCredentials(); // ALL REGISTERED USERS
		LoggedUsers activeUsers = new LoggedUsers(); // ALL LOGGED USERS (0 when the server starts)
		
		
		try{
			
			while(true){
				SCSocket = SSocket.accept();
				System.out.println("New client on server");
				
			
				
				
				PrintStream toClient = new PrintStream(SCSocket.getOutputStream());
				BufferedReader fromClient = new BufferedReader(new InputStreamReader(SCSocket.getInputStream()));
				boolean logged = false;
				try{
				while(!logged){
					
						
					
					String action = fromClient.readLine();
					
					if(action.equals("login")){
						String userName = fromClient.readLine();
						String password = fromClient.readLine();
						if(namePassword.users.containsKey(userName)){
							if(!activeUsers.isLogged(userName)){
								if(namePassword.getPassword(userName).equals(password)){
								activeUsers.add(userName);
								logged = true;
								System.out.println("User " + userName + " has logged in");
								
								// TO DO (START THREADS)
								}
								else if(!namePassword.getPassword(userName).equals(password))
										System.out.println("wrong pw");
							}
						}
					}
					
				}
			} catch (IOException e){
				System.out.println("User abandoned");
			}
			}
			
		}
		
		catch (IOException e){
			
		}
		
	}

}
