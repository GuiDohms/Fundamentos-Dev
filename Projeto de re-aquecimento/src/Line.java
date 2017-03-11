import java.util.ArrayList;
import java.time.*;

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
	
	
}
