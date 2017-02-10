package ass2;

import java.net.*;
import java.io.*;

public class Server {
	ServerSocket SSocket;
	Socket SCSocket;
	BufferedReader fromClient = null;
	PrintStream toClient = null;
	String userName;
	
	
	public void run(){
		UserCredentials namePassword = new UserCredentials(); // ALL REGISTERED USERS
		LoggedUsers activeUsers = new LoggedUsers(); // ALL LOGGED USERS (0 when the server starts)
		try {
			SSocket = new ServerSocket(Port.number);
			
		}  catch (IOException e) {
			System.out.println("Couldn't listen to port:" + Port.number);
		}
		try{
			
			while(true){
				SCSocket = SSocket.accept();
				System.out.println("New client on server");
				
				BufferedReader fromClient = new BufferedReader(new InputStreamReader(SCSocket.getInputStream()));
				PrintStream toClient = new PrintStream(SCSocket.getOutputStream());
				String userName = null;
				
				toClient.println("Please register and/or login");
				String action = fromClient.readLine();
					
					if(action.equals("login")){
						//Handle quit here
						userName = fromClient.readLine();
						if(namePassword.users.containsKey(userName)){
							if(!activeUsers.isLogged(userName)){
								String password = fromClient.readLine();
								//Handle Quit here
								if(namePassword.getPassword(userName).equals(password)){
									activeUsers.add(userName);
									System.out.println("User " + userName + " has logged in");
									toClient.println("You have succesfuly logged in!");
									
									ServerSender sender = new ServerSender(toClient, activeUsers.getQueue(userName)); // BBBBBBB
								
									ServerReceiver receiver = new ServerReceiver(sender, userName, fromClient, activeUsers); // AAAAAAAA
									receiver.setName("RECEIVER_THREAD");
									
									receiver.start();
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
					
				
			}
			} catch (IOException e){
				System.out.println("Client closed.");}
			
		
		}
		

}
