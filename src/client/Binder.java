package client;
import controller.Controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import backend.Client;
import frontend.View;

public class Binder {
	public static void main(String[] args) {
		View view = new View();
		Client client;
		try {
			client = new Client(InetAddress.getByName("127.168.1.1"));
			Controller controller = new Controller(client, view);
		} catch (UnknownHostException e) {
			System.out.println("Unknown host");
		}
		
	}
}
