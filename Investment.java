
public class Investment extends Account{
	private double quarterlyDividend;
	private double baseRateOfReturn;
	
	public Investment(String manager, int code, char identifier, String label, double quarterlyDividend, double baseRateOfReturn) {
		super(manager, code, identifier, label);
		this.quarterlyDividend = quarterlyDividend;
		this.baseRateOfReturn = baseRateOfReturn;
	}
	
	public double getQuarterlyDividend() {
		return quarterlyDividend;
	}
	public void setQuarterlyDividend(double quarterlyDividend) {
		this.quarterlyDividend = quarterlyDividend;
	}
	public double getBaseRateOfReturn() {
		return baseRateOfReturn;
	}
	public void setBaseRateOfReturn(double baseRateOfReturn) {
		this.baseRateOfReturn = baseRateOfReturn;
	}
	
}
