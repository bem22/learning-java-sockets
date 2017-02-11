package ass2;

import java.util.*;

public class UserCredentials {
	Map <String, String> users = new HashMap<String, String>();
	
	public UserCredentials() {
		users.put("nume1", "pw1");
		users.put("nume2", "pw2");
		users.put("nume3", "pw3");
		users.put("luiza", "mihaismek");
	}
	
	public String getPassword(String userName){
		return users.get(userName);
		
	}

}
