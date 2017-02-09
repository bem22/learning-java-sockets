package ass2;

import java.net.*;
import java.io.*;

public class Client {
	
	Socket CSSocket;
	String serverName;
	
	public Client(String serverName){
		try{
			CSSocket = new Socket(serverName, Port.number);
		}
		catch (IOException e){
			
		}
		
	}
	
	public void run(){
		while(true);
		
	}

}
