
public class Stocks extends Investment {
	private double betaMeasure;
	private String stockSymbol;
	private double sharePrice;
	
	public Stocks(String manager, int code, char identifier, String label, double quarterlyDividend, double baseRateOfReturn,
			double betaMeasure, String stockSymbol, double sharePrice) {
		super(manager, code, identifier, label, quarterlyDividend, baseRateOfReturn);
			this.betaMeasure = betaMeasure;
			this.stockSymbol = stockSymbol;
			this.sharePrice = sharePrice;
		
	}
	
	public double getBetaMeasure() {
		return betaMeasure;
	}
	public void setBetaMeasure(double betaMeasure) {
		this.betaMeasure = betaMeasure;
	}
	public String getStockSymbol() {
		return stockSymbol;
	}
	public double getSharePrice() {
		return sharePrice;
	}
	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}
	
	

}
