import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Client a = new Client(23, "Elza");
		System.out.println(a);
		Client b = new Client(65, "Eli");
		System.out.println(b);
		Client c = new Client(68, "Elie");
		System.out.println(c);
		
		Line line = new Line();
		line.addClient(a);
		line.addClient(b);
		line.addClient(c);
		System.out.println("fila: " + line.getLine());
		
		line.removeClient(a);
		line.removeClient(b);
		System.out.println("fila: " + line.getLine());
	
		
		
	}

}
