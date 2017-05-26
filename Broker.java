public class Broker extends Person {
	private String secID;
	
	public Broker(String id, String firstName, String lastName, String street, String city, String state, String zipCode, String country, String[] emailAddress, String secID) {
		super(id, firstName, lastName, street, city, state, zipCode, country, emailAddress);
		this.secID = secID;
	}
	
	public boolean isBroker() {
		return true;
	}
	
	// this will be either E or J
	private String position;
	
	public String getSecID() {
		return secID;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}


	
	
	

}
