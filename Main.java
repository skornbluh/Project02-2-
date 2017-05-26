import java.io.File;
import java.util.Scanner;

public class Main {
	private Person[] personData = null;
	private String[][] assetsData;
	private String[][] portfoliosData;
	private int rowCount = 0;
	private String[][] data = null;
	private static final int PERSONS_COLUMN_COUNT = 5;
	private static final int ASSETS_COLUMN_COUNT = 21;
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
				// makeAssets(scanAssets)
				scan = scanAssets;
				if (scan.hasNextInt()) {
					rowCount = scan.nextInt();
					scan.nextLine();
				} else {
					System.out.println("Bad file format, expected integer.");
					System.exit(-1);
				}
				assetsData = new String[rowCount][ASSETS_COLUMN_COUNT];
				data = assetsData;
				break;
			case 2:
				// makePortfolios(scanPortfolios)
				scan = scanPortfolios;
				if (scan.hasNextInt()) {
					rowCount = scan.nextInt();
					scan.nextLine();
				} else {
					System.out.println("Bad file format, expected integer.");
					System.exit(-1);
				}
				portfoliosData = new String[rowCount][PORTFOLIOS_COLUMN_COUNT];
				data = portfoliosData;
				break;
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
				personData[r] = new Broker(id, firstName, lastName, street, city, state, zipCode, country, emailAddress, broker);
			} else {
				personData[r] = new Client(id, firstName, lastName, street, city, state, zipCode, country, emailAddress);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Main instance = new Main();
		instance.printAllData(instance.getAssetsData());
		instance.printAllData(instance.getPortfoliosData());

	}

	public Person[] getPersonsData() {
		return personData;
	}

	public String[][] getAssetsData() {
		return assetsData;
	}

	public String[][] getPortfoliosData() {
		return portfoliosData;
	}

	private void printAllData(String[][] data) {
		System.out.println("\n -- new file -- \n");
		for (int r = 0; r < data.length; r++) {
			for (int c = 0; c < data[0].length; c++) {
				System.out.print(data[r][c] + "\t");
			}
			System.out.println();
		}
	}
}
