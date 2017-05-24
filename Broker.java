
public class Broker extends Person {
	private int secID;
	
	public Broker(String firstName, String lastName, String street, String city, String state, int zipCode, String country, String emailAddress, int secID) {
		super(firstName, lastName, street, city, state, zipCode, country, emailAddress);
		this.secID = secID;
	}
	
	// this will be either E or J
	private String position;
	
	public int getSecID() {
		return secID;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}


	
	
	

}
