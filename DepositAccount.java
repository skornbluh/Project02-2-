public class DepositAccount extends Account {
	private double apr;
	
	public DepositAccount(String code, String label, double apr) {
		super(code,label);
		this.apr = apr;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		System.out.println("*****************Deposit Account***************** \n");
		sb.append("Code: " + getCode() + " \n");
		sb.append("Label: " + getLabel() + " \n");
		sb.append("APR: " + getApr() + " \n");
		
		return sb.toString();
	}
	
	
	public double getApr() {
		return apr;
	}

	public void setApr(double apr) {
		this.apr = apr;
	}
	
	
	
}
