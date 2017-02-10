package ass2;

import java.io.*;

public class ClientSender extends Thread{
	private PrintStream toServer;
	public ClientSender(PrintStream toServer) {
		this.toServer = toServer;
	}
	
	public void run(){
		
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		
		
		try{
			while(true){
				String s = userInput.readLine();
				toServer.println(s);
				
				if(s.equals("quit"))
					break;
			}
		} catch (IOException e) {}
		
		
	}

}
