package ass2;

import java.net.*;
import java.io.*;

public class Server {
	ServerSocket SSocket;
	Socket SCSocket;
	
	public Server() {
		try {
			SSocket = new ServerSocket(Port.number);
			
		} catch (IOException e) {}
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
				String userName = null;
				
				boolean logged = false;
				try{
					
				while(!logged){
					toClient.println("Please register and/or login");
					String action = fromClient.readLine();
					
					if(action.equals("login")){
						userName = fromClient.readLine();
						if(namePassword.users.containsKey(userName)){
							if(!activeUsers.isLogged(userName)){
								String password = fromClient.readLine();
								if(namePassword.getPassword(userName).equals(password)){
									activeUsers.add(userName);
									logged = true;
									System.out.println("User " + userName + " has logged in");
									toClient.println("You have succesfuly logged in!");
								
								// TO DO (START THREADS)
								}
								else if(!namePassword.getPassword(userName).equals(password))
										toClient.println("Incorrect credentials. Please retry.");
							}
							else toClient.println("You are already logged in from another client.");
						}
						else toClient.println("Incorrect credentials. Please retry.");
					}
					
					else if(action.equals("quit")){
						System.out.println("User quit");
						break;
					}

					else if(action.equals("register")){
							userName = fromClient.readLine();
							if(!namePassword.users.containsKey(userName)){
								String password = fromClient.readLine();
								if(password != null && !password.equals("") && password.length() > 3){
									namePassword.users.put(userName, password);
								}
								else toClient.println("Password too short or empty");
							}
							
							else toClient.println("This username is already taken");
					}
					
				} // End !ogged
				
				ServerSender sender = new ServerSender(toClient, activeUsers.getQueue(userName)); // BBBBBBB
				ServerReceiver receiver = new ServerReceiver(sender, userName, fromClient, activeUsers); // AAAAAAAA
				
			} catch (IOException e){
				System.out.println("Client closed.");
			}
			}
			
		}
		
		catch (IOException e){
			
		}
		
	}

}
