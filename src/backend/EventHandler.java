package backend;

public class EventHandler {
	private boolean logged = false;
	private boolean wrong = false;
	private boolean existent = false;
	private boolean registered = false;
	private boolean already = false;
	private boolean shortPassword = false;
	private boolean pingReceived = false;
	private boolean messaged = false;
	
	public void setAll(boolean all){
		this.logged = false;
		this.wrong = false;
		this.existent = false;
		this.registered = false;
		this.already = false;
		this.shortPassword = false;
		this.pingReceived = false;
		this.messaged = false;
	}
	
	public void setAlready(boolean already){
		this.already = already;
	}
	
	public boolean getAlready(){
		return already;
	}
	
	public void setRegistered(boolean registered){
		this.registered = registered;
	}
	
	public boolean getRegistered(){
		return registered;
	}
	
	public void setExistentUser(boolean existent){
		this.existent = existent;
	}
	
	public boolean getExistentUser(){
		return existent;
	}
	
	public void setWrong(boolean wrong){
		this.wrong = wrong;
	}
	
	public boolean getWrong(){
		return wrong;
	}
	
	public void setLogged(boolean logged){
		this.logged = logged;
	}
	
	public boolean getLogged(){
		return logged;
	}

	public void setShortPassword(boolean shortPassword) {
		this.shortPassword = shortPassword;
	}

	public boolean getShortPassword() {
		return shortPassword;
	}
	
	public void setPingReceived(boolean ping){
		this.pingReceived = ping;
	}
	
	public boolean getPingReceived(){
		return pingReceived;
	}
	
	public void setMessaged(boolean messaged){
		this.messaged = messaged;
	}
	
	public boolean getMessaged(){
		return messaged;
	}	
}
