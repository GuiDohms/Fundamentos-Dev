
public class Cashier{
	private int num;
	private boolean statusFree;
	
	public Cashier(int num, boolean statusFree){
		this.num = num;
		this.statusFree = true;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public boolean isStatusFree() {
		return statusFree;
	}

	public void setStatusFree(boolean statusFree) {
		this.statusFree = statusFree;
	}

	@Override
	public String toString() {
		return "Cashier num: " + num + '\n' +
				"Free: " + statusFree;
	}
	
	
}
