package ass2;

import java.net.*;
import java.io.*;

public class Client {
	
	Socket CSSocket;
	
	public Client() {
		try{
			CSSocket = new Socket("localhost", Port.number);
		}
		catch (IOException e){
			
		}
		
	}
	
	public void run(){
		while(true);
		
	}

}
