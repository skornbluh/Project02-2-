import java.io.File;
import java.util.Scanner;

public class Main {
	private Person[] personData = null;
	private Account[] accountData = null;
	private String[][] portfoliosData = null;
	private int rowCount = 0;
	private static final int PORTFOLIOS_COLUMN_COUNT = 10;

	private Scanner scanPersons = null;
	private Scanner scanAssets = null;
	private Scanner scanPortfolios = null;

	/**
	 * constructor initializes all data
	 */
	public Main() {
		try {
			scanPersons = new Scanner(new File("Persons.dat"));
			scanAssets = new Scanner(new File("Assets.dat"));
			scanPortfolios = new Scanner(new File("Portfolios.dat"));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		for (int i = 0; i < 3; i++) {
			Scanner scan = null;

			switch (i) {
			case 0:
				makePerson(scanPersons);
				break;
			case 1:
				makeAccount(scanAssets);
				break;
//			case 2:
//				// makePortfolios(scanPortfolios)
//				scan = scanPortfolios;
//				if (scan.hasNextInt()) {
//					rowCount = scan.nextInt();
//					scan.nextLine();
//				} else {
//					System.out.println("Bad file format, expected integer.");
//					System.exit(-1);
//				}
//				portfoliosData = new String[rowCount][PORTFOLIOS_COLUMN_COUNT];
//				data = portfoliosData;
//				break;
			}
		}
	}

	/**
	 * String firstName, String lastName, String street, String city, String
	 * state, String zipCode, String country, String emailAddress, String secID
	 * 
	 * @param scanPersons
	 */
	private void makePerson(Scanner scanPersons) {
		if (scanPersons.hasNextInt()) {
			rowCount = scanPersons.nextInt();
			personData = new Person[rowCount];
			scanPersons.nextLine();
		} else {
			System.out.println("Bad file format, expected integer.");
			System.exit(-1);
		}

		//
		// create person object
		//
		String id = "";
		String broker = "";
		String firstName = "";
		String lastName = "";
		String street = "";
		String city = "";
		String state = "";
		String zipCode = "";
		String country = "";
		String[] emailAddress = null;

		for (int r = 0; r < personData.length; r++) {
			String row = scanPersons.nextLine();
			String[] column = row.split(";");
			boolean isBroker = (!column[1].isEmpty());
			String[] temp = null;

			// create client object
			for (int c = 0; c < column.length; c++) {
				switch (c) {
				case 0: // id
					id = column[0];
					break;
				case 1: // broker
					if (isBroker) {
						broker = column[1];
					}
					break;
				case 2: // full name
					temp = column[2].split(",");
					if (!temp[1].isEmpty()) {
						firstName = temp[1];
					}
					if (!temp[0].isEmpty()) {
						lastName = temp[0];
					}
					break;
				case 3: // address
					temp = column[3].split(",");
					if (!temp[0].isEmpty()) {
						street = temp[0];
					}
					if (!temp[1].isEmpty()) {
						city = temp[1];
					}
					if (!temp[2].isEmpty()) {
						state = temp[2];
					}
					if (!temp[3].isEmpty()) {
						zipCode = temp[3];
					}
					if (!temp[4].isEmpty()) {
						country = temp[4];
					}
					break;
				case 4: // email addresses
					temp = column[4].split(",");
					emailAddress = new String[temp.length];
					for (int f = 0; f < temp.length; f++) {
						emailAddress[f] = temp[f];
					}
					break;
				}
			}
			if (isBroker) {
				personData[r] = new Broker(id, firstName, lastName, street, city, state, zipCode, country, emailAddress,
						broker);
			} else {
				personData[r] = new Client(id, firstName, lastName, street, city, state, zipCode, country,
						emailAddress);
			}
		}
	}

	/**
	 * load the account objects
	 * @param scanAssets
	 */
	private void makeAccount(Scanner scanAssets) {
		if (scanAssets.hasNextInt()) {
			rowCount = scanAssets.nextInt();
			accountData = new Account[rowCount];
			scanAssets.nextLine();
		} else {
			System.out.println("Bad file format, expected integer.");
			System.exit(-1);
		}
		//
		// create account objects
		//
		String code = "";
		String label = "";
		double apr = 0.0;
		double quarterlyDividend = 0.0;
		double baseRateOfReturn = 0.0;
		double omegaMeasure = 0.0;
		double totalValue = 0.0;
		double betaMeasure = 0.0;
		String stockSymbol = "";
		double sharePrice = 0.0;

		for (int r = 0; r < accountData.length; r++) {
			String row = scanAssets.nextLine();
			String[] column = row.split(";");
			String accountType = column[1];

			// create client object
			for (int c = 0; c < column.length; c++) {
				// all classes need this
				code = column[0];
				label = column[2];

				switch (accountType) {
				case "D": // store the fields and create DepositAccount
					apr = Double.parseDouble(column[3]);
					accountData[r] = new DepositAccount(code,label,apr);
					break;
				case "S": // store the fields and create StockAccount
					quarterlyDividend = Double.parseDouble(column[3]);
					baseRateOfReturn = Double.parseDouble(column[4]);
					betaMeasure = Double.parseDouble(column[5]);
					stockSymbol = column[6];
					sharePrice = Double.parseDouble(column[7]);
					accountData[r] = new StockAccount(code, label, quarterlyDividend, baseRateOfReturn,
						 betaMeasure, stockSymbol, sharePrice);
					break;
				case "P": // store the fields and create PrivateInvestmentAccount
					quarterlyDividend = Double.parseDouble(column[3]);
					baseRateOfReturn = Double.parseDouble(column[4]);
					omegaMeasure = Double.parseDouble(column[5]);
					totalValue = Double.parseDouble(column[6]);
					accountData[r] = new PrivateInvestmentAccount(code, label, quarterlyDividend, baseRateOfReturn, omegaMeasure, totalValue);
					break;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Main instance = new Main();
		printPersons(instance.getPersonsData());
		printAccounts(instance.getAccountData());
	}

	private static void printAccounts(Account[] accountData) {
		for (int i = 0; i < accountData.length; i++) {
			Account account = accountData[i]; // storing account types in account variable
			System.out.println(account.toString());
		}
		
	}

	private static void printPersons(Person[] personsData) {
		for (int i = 0; i < personsData.length; i++) {
			Person person = personsData[i]; // 
			System.out.println(person.toString());
		}
	}

	public Person[] getPersonsData() {
		return personData;
	}

	public Account[] getAccountData() {
		return accountData;
	}

	public String[][] getPortfoliosData() {
		return portfoliosData;
	}
}
