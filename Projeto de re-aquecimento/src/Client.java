import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Client {
	private int age;
	private String name;
	private boolean elder;
	private LocalDateTime now;
	
	public Client(int age, String name){
		this.name = name;
		this.age = age;
		if(age >= 65){
			this.elder=true;
		}else{
			this.elder=false;
		}
		this.now = LocalDateTime.now();
	}
	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Client Name: " + name + '\n' + 
			   "Age: " + age + '\n' + 
			   "Elderly: " + elder + '\n' +
			   "Date & Time: " + now;
	}
	
	
	
	
}
