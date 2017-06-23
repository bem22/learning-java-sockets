package bemihai22.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class ServerReceiver extends Thread {
	private ServerSender sender;
	private String userName;
	private BufferedReader fromClient;
	private LoggedUsers activeUsers;
	private FLAG_logged logged;
	private FLAG_quit quit;
	private GroupHash groups;
	private UserCredentials namePassword;
	
	public ServerReceiver(ServerSender sender, String userName, BufferedReader fromClient, LoggedUsers activeUsers, FLAG_logged logged, FLAG_quit quit, GroupHash groups, UserCredentials namePassword) {
		this.sender = sender;
		this.userName = userName;
		this.fromClient = fromClient;
		this.activeUsers = activeUsers;
		this.logged = logged;
		this.quit = quit;
		this.groups = groups;
		this.namePassword = namePassword;
	}
	
	@Override
	public void run(){
		this.sender.start();
	
			while(!Thread.currentThread().isInterrupted()){
				String action;
				try {
					action = this.fromClient.readLine();
				
					if (action.equals("logout")){
						logout();
					}
					if(action.equals("message")){
						talk();
					}
					if (action.equals("quit")){
						quit();
					}
					if (action.equals("creategroup")){
						createGroup();
					}
					if (action.equals("removegroup")){
						removeGroup();
					}
					if (action.equals("listgroups")){
						printGroups();
					}
					if (action.equals("addmember")){
						addMember();
					}
					if(action.equals("sendall")){
						sendAll();
					}
				} catch (IOException e) {}
			}
	}
	
	private void logout(){
		this.logged.setValue(false);
		System.out.println(userName + " logged out");
		this.activeUsers.logout(userName);
		this.sender.interrupt();
		Thread.currentThread().interrupt();
	}
	
	private void quit(){
		logout();
		quit.setValue(true);
	}
	
	private void talk(){
		try {
			String recipient;
				recipient = fromClient.readLine();
			if(recipient!=null){
				if(activeUsers.isLogged(recipient)){
					String text = fromClient.readLine();
						if(text != null){
							Message msg = new Message(userName, text);
							MessageQueue recipientsQueue = activeUsers.getQueue(recipient);
				
							if(recipientsQueue != null)
								recipientsQueue.offer(msg);
						}
						else sender.sendInfo("Null text format");
				}
				else sender.sendInfo("User is offline.");
			}
			else sender.sendInfo("null recipient");
		} catch (IOException e) {}
	}
	
	private void createGroup(){
		try{
			ArrayList<String> admins = new ArrayList<String>();
			ArrayList<String> members = new ArrayList<String>();
			admins.add(userName);
			members.add(userName);
			String name = fromClient.readLine();
			Group groupName1 = new Group(admins, members);
			groups.addGroup(name, groupName1);
			sender.sendInfo("Group " + name + " has been created");
		}catch(IOException e){}
	}
	
	private boolean removeGroup(){
		try{
			String groupName = fromClient.readLine();
			if(groups.hashTable.containsKey(groupName)){
				if(groups.hashTable.get(groupName).isAdmin(userName)){
					groups.removeGroup(groupName);
					sender.sendInfo("Group " + groupName + " has been deleted.");
					return true;
				}
				sender.sendInfo("You are not admin");
				return false;
			}
			sender.sendInfo("Group does not exist");
			return false;
		}catch(IOException e){}
		return false;
	}
	
	private void printGroups(){
		sender.sendInfo("Visible groups are: " + groups.listGroups());
	}
	
	private void addMember(){
		try{
			String groupName = fromClient.readLine();
			if(groups.hashTable.containsKey(groupName)){
				if(groups.hashTable.get(groupName).isAdmin(userName)){
					String membername = fromClient.readLine();
					if(namePassword.users.containsKey(membername)){
						groups.hashTable.get(groupName).addMember(membername);
						sender.sendInfo("You added: " + membername + " to group: " + groupName);
						if(activeUsers.isLogged(membername)){
							String text = "You have been added to group; " + groupName;
							Message msg = new Message(userName, text);
							MessageQueue recipientsQueue = activeUsers.getQueue(membername);
							if(recipientsQueue != null)
								recipientsQueue.offer(msg);
						}
					}
				}
				else sender.sendInfo("You are not admin in this group");
			}
			else sender.sendInfo("This group does not exist");
		} catch (IOException e) {}
	}
	
	private void removeMember(){
		try{
			String groupName = fromClient.readLine();
			if(groups.hashTable.containsKey(groupName)){
				if(groups.hashTable.get(groupName).isAdmin(userName)){
					String membername = fromClient.readLine();
					if(namePassword.users.containsKey(membername)){
						groups.hashTable.get(groupName).removeMember(membername);
						if(activeUsers.isLogged(membername)){
							String text = "You have been removed from group; " + groupName;
							Message msg = new Message(membername, text);
							MessageQueue recipientsQueue = activeUsers.getQueue(membername);
							if(recipientsQueue != null)
								recipientsQueue.offer(msg);
						}
					}
				}
			}
		}catch(IOException e){}
	}
	
	private void sendAll(){
		try {
			String groupName = fromClient.readLine();
			if(groups.hashTable.containsKey(groupName)){
				String text = fromClient.readLine();
				if(groups.hashTable.get(groupName).isMember(userName)){
					for(int i=0;i<groups.hashTable.get(groupName).members.size();i++){
						if(activeUsers.isLogged(groups.hashTable.get(groupName).members.get(i)) && !groups.hashTable.get(groupName).members.get(i).equals(userName)){
							Message msg = new Message(userName, text);
							MessageQueue recipientsQueue = activeUsers.getQueue(groups.hashTable.get(groupName).members.get(i));
							if(recipientsQueue != null)
								recipientsQueue.offer(msg);
						}
					}
				}
			}
		} catch (IOException e) {}
	}
	
	private void leaveGroup(){
		try{
			String groupName = fromClient.readLine();
			if(groups.hashTable.containsKey(groupName)){
				if(groups.hashTable.get(groupName).isMember(userName)){
					if(groups.hashTable.get(groupName).isAdmin(userName) && groups.hashTable.get(groupName).members.size()==1){
						groups.hashTable.get(groupName).removeAdmin(userName);
						groups.hashTable.remove(groupName);
					}
					groups.hashTable.get(groupName).removeMember(userName);
					sender.sendInfo("You left the group: " + groupName);	
				}
				else sender.sendInfo("You are not a member of this group.");
			}
			else sender.sendInfo("Group " + groupName+ " doesn't exist");
		}catch(IOException e){}
	}
}
