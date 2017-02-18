package ass2;

public class FLAG_quit {
	
	private boolean value = false;
	
	public synchronized boolean getValue(){
		return value;
	}
	public synchronized void setValue(boolean value){
		this.value = value;
	}

}
