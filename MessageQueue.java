package ass2;
import java.util.concurrent.*;
public class MessageQueue {
	
	private BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();
	
	public void offer(Message m) {
	    queue.offer(m);
	}
	
	public Message take() throws InterruptedException {

	        return(queue.take());
	        
	}

}
