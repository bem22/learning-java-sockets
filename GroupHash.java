package ass2;
import java.util.*;

public class GroupHash {
	Map <String, Group> hashTable= new HashMap <String, Group> ();
	
	
	
	public void addGroup(String groupName, Group group){
		hashTable.put(groupName, group);
	}
	
	public void removeGroup(String name){
		hashTable.remove(name);
	}
	
	
	
	public Group getGroup(String name){
			return hashTable.get(name);
	}
	
	public Set listGroups(){
		return hashTable.keySet();
	}
}
