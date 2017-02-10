package ass2;

import java.io.BufferedReader;
import java.io.PrintStream;

public class ServerSender extends Thread {
	private MessageQueue userQueue;
	private PrintStream toClient;
	public ServerSender(PrintStream toClient, MessageQueue userQueue) {
		this.userQueue = userQueue;
		this.toClient = toClient;
	}
	
	public void sendInfo(String msg){
		toClient.println(msg);
		
	}
	
	public void run(){
		while(true){
			Message msg = userQueue.take();
			toClient.println(msg);
		}
		
	}

}
