package ass2;

import java.net.*;
import java.io.*;

public class Client {
	
	Socket CSSocket;
	String serverName;
	
	PrintStream toServer;
	BufferedReader fromUser;
	BufferedReader fromServer;
	
	public Client(String serverName){
		try{
			CSSocket = new Socket(serverName, Port.number);
		}
		catch (IOException e){
			
		}
		
	}
	
	public void run(){
		
		BufferedReader fromUser = new BufferedReader(new InputStreamReader(System.in));
		
			try {
				
				while(true){
					String text;
					text = fromUser.readLine();
					toServer.println(text);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NullPointerException e){
				
			}
	}
		

}
