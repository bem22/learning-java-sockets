package client;
import controller.Controller;
import backend.Client;
import frontend.View;

public class Binder {
	public static void main(String[] args) {
		
		View view = new View();
		Client client = new Client("localhost");
		Controller lControl = new Controller(client, view);
		client.run();
		
	}

}
