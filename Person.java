public abstract class Person {
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	private String[] emailAddress;
	private String id;
	
	public Person(String id, String firstName, String lastName, String street, String city, String state, String zipCode, String country, String[] emailAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
		this.emailAddress = emailAddress;
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public abstract boolean isBroker();
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String[] getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String[] emailAddress) {
		this.emailAddress = emailAddress;
	}
	
}
