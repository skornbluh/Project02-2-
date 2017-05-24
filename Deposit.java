
public class Deposit extends Account {
	private double apr;
	
	public Deposit(String manager, int code, char identifier, String label, double apr) {
		super(manager, code, identifier, label);
		this.apr = apr;
	}

	public double getApr() {
		return apr;
	}

	public void setApr(double apr) {
		this.apr = apr;
	}
	
	
	
}
