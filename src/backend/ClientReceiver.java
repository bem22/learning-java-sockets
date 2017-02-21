package backend;

import java.io.*;

public class ClientReceiver extends Thread{
	private BufferedReader fromServer;
	public EventHandler eHandler = new EventHandler();
	
	public ClientReceiver(BufferedReader fromServer) {
		this.fromServer = fromServer;
	}
	
	public void run(){
		
		try{
			while(true){
				String s = fromServer.readLine();
				if(s.equals("event:Logged")){
					eHandler.setLogged(true);
					System.out.println(eHandler.getLogged());
				}
				if(s != null)
					System.out.println(s);
			}
		} catch (IOException e){}
		
	}

}
