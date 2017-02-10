package ass2;

public class Message {
	private final String senderName;
	private final String text;

	public Message(String senderName, String text) {
		this.senderName = senderName;
		this.text = text;
	}
	
	public String getSender(){
		return senderName;
	}
	
	public String getText(){
		return text;
	}
	public String toStrig(){
		return "From " + senderName + ":" + text;
	}
}
