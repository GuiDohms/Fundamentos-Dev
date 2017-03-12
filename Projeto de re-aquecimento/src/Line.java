import java.util.ArrayList;


public class Line {
	private static Line clientLst = new Line();
	public ArrayList<Client> clients;
	private int lineNum;
	
	public Line(){
		clients = new ArrayList<>();
		lineNum = 0;
	}
	
	 public static Line getInstance(){
	        return(clientLst);
	    }
	
	public boolean addClient(Client aClient){
		clients.add(aClient);
		return true;
	}
	
	public boolean removeClient(Client aClient){
		clients.remove(aClient);
		return true;
	}
	
	public Client lineNum(){
		return(clients.get(lineNum));
	}

}
	

