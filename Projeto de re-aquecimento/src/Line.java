import java.util.ArrayList;


public class Line {
	public ArrayList<Client> clients;
	
	public Line(){
		clients = new ArrayList<>();
	}
	
	public ArrayList<Client> getLine(){
		return(clients);
	}
	
	public boolean addClient(Client aClient){
		clients.add(aClient);
		return true;
	}
	
	public boolean removeClient(Client aClient){
		clients.remove(aClient);
		return true;
	}
	
}
