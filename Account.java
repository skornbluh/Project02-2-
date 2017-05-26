public class Account {
	private String manager;
	private int code;
	private char identifier;
	private String label;
	
	public Account(String manager, int code, char identifier, String label) {
		this.manager = manager;
		this.code = code;
		this.identifier = identifier;
		this.label = label;
		
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public char getIdentifier() {
		return identifier;
	}

	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	
	
}
