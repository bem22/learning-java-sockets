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
			UserCredentials namePassword = new UserCredentials();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void run(){
		try{
			
			while(true){
				SCSocket = SSocket.accept();
				BufferedReader fromClient = new BufferedReader(new InputStreamReader(SCSocket.getInputStream()));
				while((text = fromClient.readLine()) != null){
					
					System.out.println(text);
					
				}
				
			}
			
		}
		
		catch (IOException e){
			
		}
		
	}

}
