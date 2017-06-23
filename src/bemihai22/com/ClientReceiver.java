package bemihai22.com;

import java.io.*;

public class ClientReceiver extends Thread{
	private BufferedReader fromServer;
	public ClientReceiver(BufferedReader fromServer) {
		this.fromServer = fromServer;
	}
	
	public void run(){
		
		try{
			while(true){
				String s = fromServer.readLine();
				if(s != null)
					System.out.println(s);
				else 
					System.out.println("Server seems to have died");
			}
		} catch (IOException e){}
		
	}

}
