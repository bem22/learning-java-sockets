package ass2;

import java.net.*;
import java.io.*;

public class Client {
	
	Socket CSSocket;
	String serverName;
	PrintStream toServer = null;
    BufferedReader fromServer = null;


	
	public Client(String serverName){
		try{
			
			CSSocket = new Socket(serverName, Port.number);
			toServer = new PrintStream(CSSocket.getOutputStream());
			fromServer = new BufferedReader(new InputStreamReader(CSSocket.getInputStream()));
		}
		catch (IOException e){
		}
		
	}
	
	public void run(){
		
		if(CSSocket.isConnected()){
			ClientSender sender = new ClientSender(toServer);
			ClientReceiver receiver = new ClientReceiver(fromServer);
			
			sender.start();
			receiver.start();
		
		
			try{
				sender.join();
			    toServer.close();
			    receiver.join();
			    fromServer.close();
			    CSSocket.close();
			} catch (IOException e){} catch(InterruptedException d){}     
		}
	}
}
