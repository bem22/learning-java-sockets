package backend;

import java.io.*;
import java.util.ArrayList;

public class ClientReceiver extends Thread{
	public BufferedReader fromServer;
	public EventHandler eHandler = new EventHandler();
	public String s;
	public String message;
	public String[] onlineUsers;
	
	public ClientReceiver(BufferedReader fromServer) {
		this.fromServer = fromServer;
		Thread.currentThread().setName("RECEIVER");
	}
	
	public void run(){
		
		try{
			while(true){
				s = fromServer.readLine();
				
				if(s.equals("event:Registered"))
				{
					eHandler.setRegistered(true);
				}
				
				if(s.equals("event:Logged")){
					eHandler.setLogged(true);
				}
				if(s.equals("event:Wrong")){
					eHandler.setWrong(true);
				}
				
				if(s.equals("event:ExistentUser")){
					eHandler.setExistentUser(true);
				}
				
				if(s.equals("event:Already")){
					eHandler.setAlready(true);
				}
				if(s.equals("event:ShortPassword")){
					eHandler.setShortPassword(true);
				}
				if(s.equals("event:Online")){
					eHandler.setPingReceived(true);
					
					s = fromServer.readLine();
					s = s.replaceAll("\\[", "");
					s = s.replaceAll("\\]", "");
					onlineUsers = s.split(",\\ ");
				}
				if(s.equals("event:Message")){
					eHandler.setMessaged(true);
					message = fromServer.readLine();
				}
			}
		} catch (IOException e){}
		
	}

}
