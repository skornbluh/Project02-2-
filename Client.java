public class Client extends Person {

	public Client(String id, String firstName, String lastName, String street, String city, String state, String zipCode,
			String country, String[] emailAddress) {
		super(id, firstName, lastName, street, city, state, zipCode, country, emailAddress);
	}

	public boolean isBroker() {
		return false;
	}
}
