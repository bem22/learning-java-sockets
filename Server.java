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
				ServerThread t = new ServerThread(SCSocket, activeUsers, namePassword);
				t.start();
			}

		}catch (Exception e) {
	    }
	}
}
