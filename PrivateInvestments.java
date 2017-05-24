
public class PrivateInvestments extends Investment {
	private double omegaMeasure;
	private double totalValue;
	
	public PrivateInvestments(String manager, int code, char identifier, String label, double quarterlyDividend, double baseRateOfReturn,
			double omegaMeasure, double totalValue) {
		super(manager, code, identifier, label, quarterlyDividend, baseRateOfReturn);
		this.omegaMeasure = omegaMeasure;
		this.totalValue = totalValue;
	}
	
	public double getOmegaMeasure() {
		return omegaMeasure;
	}
	public void setOmegaMeasure(double omegaMeasure) {
		this.omegaMeasure = omegaMeasure;
	}
	public double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	
	

}
