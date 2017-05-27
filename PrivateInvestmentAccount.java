public class PrivateInvestmentAccount extends Account {
	private double omegaMeasure;
	private double totalValue;
	private double quarterlyDividend;
	private double baseRateOfReturn;
	
	public PrivateInvestmentAccount(String code, String label, double quarterlyDividend, double baseRateOfReturn,
			double omegaMeasure, double totalValue) {
		super(code, label);
		this.omegaMeasure = omegaMeasure;
		this.totalValue = totalValue;
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

	public String toString() {
		StringBuilder sb = new StringBuilder();
		System.out.println("*****************Private Investment Account***************** \n");
		sb.append("Code: " + getCode() + " \n");
		sb.append("Label: " + getLabel() + " \n");
		sb.append("Quarterly Dividend: " + getQuarterlyDividend() + " \n");
		sb.append("Base rate of return: " + getBaseRateOfReturn() + " \n");
		sb.append("Omega Measure: " + getOmegaMeasure() + " \n");
		sb.append("Total Value: " + getTotalValue() + " \n");
		
		
		return sb.toString();
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
