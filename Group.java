package ass2;

import java.util.ArrayList;

public class Group {
	ArrayList<String> admins = new ArrayList<String>();
	ArrayList<String> members = new ArrayList<String>();
	
	
	public Group(ArrayList<String> admins, ArrayList<String> members){
		this.admins = admins;
		this.members = members;
	}
	
	public boolean isAdmin(String userName){
		if(admins.contains(userName))
			return true;
		return false;
	}
	
	public boolean isMember(String userName){
		if(members.contains(userName))
			return true;
		return false;
	}
	public ArrayList<String> getMembers(){
		return members;
	}
	
	public void addMember(String name){
		members.add(name);
	}
	
	public void removeMember(String name){
		members.remove(name);
	}
	public void removeAdmin(String name){
		admins.remove(name);
	}
}
