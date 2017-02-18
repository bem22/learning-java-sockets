package ass2;

import java.io.*;
import java.net.*;

public class ServerThread extends Thread{
	private Socket SCSocket = null;
	private LoggedUsers activeUsers;
	private UserCredentials namePassword;
	private FLAG_logged logged = new FLAG_logged();
	private FLAG_quit quit = new FLAG_quit();
	
	
	public ServerThread(Socket SCSocket, LoggedUsers activeUsers, UserCredentials namePassword){
		this.SCSocket = SCSocket;
		this.activeUsers = activeUsers;
		this.namePassword = namePassword;
		
	}
	
	public void run(){
		
		
		try{
			BufferedReader fromClient = new BufferedReader(new InputStreamReader(SCSocket.getInputStream()));
			PrintStream toClient = new PrintStream(SCSocket.getOutputStream());
			String userName = null;
			ServerSender sender = null;
			ServerReceiver receiver = null;
			
			
			this.logged.setValue(false);
			this.quit.setValue(false);
			
			while(true){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(this.logged.getValue() == false){
					toClient.println("Please register and/or login");
					
					String action = fromClient.readLine();
					
					if(action.equals("quit") || this.quit.getValue() == true){
						break;
					}
					
					if(action.equals("login")){
						userName = fromClient.readLine();
						if(namePassword.users.containsKey(userName)){
							if(!activeUsers.isLogged(userName)){
								String password = fromClient.readLine();
								//Handle Quit here
								if(namePassword.getPassword(userName).equals(password)){
									activeUsers.add(userName);
									this.logged.setValue(true);
									System.out.println("User " + userName + " has logged in");
									toClient.println("You have succesfuly logged in!");
									sender = new ServerSender(toClient, activeUsers.getQueue(userName)); // BBBBBBB
									receiver = new ServerReceiver(sender, userName, fromClient, activeUsers, this.logged, this.quit); // AAAAAAAA
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
					//////////////////////////////////////////////////////////////////////////////////////
					
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
					//////////////////////////////////////////////////////////////////////////////////////
				}
			}
		}catch(IOException e){}
	}
}

