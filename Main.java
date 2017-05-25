import java.io.File;
import java.util.Scanner;

public class Main {
	private String[][] personsData;
	private String[][] assetsData;
	private String[][] portfoliosData;
	private int rowCount = 0;
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
			String[][] data = null;
			switch (i) {
			case 0:
				scan = scanPersons;
				if (scan.hasNextInt()) {
					rowCount = scan.nextInt();
					scan.nextLine();
				} else {
					System.out.println("Bad file format, expected integer.");
					System.exit(-1);
				}
				personsData = new String[rowCount][PERSONS_COLUMN_COUNT];
				data = personsData;
				break;
			case 1:
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
			
			try {
				getData(scan, data);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			} finally {
				scan.close();
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Main instance = new Main();
		instance.printAllData(instance.getPersonsData());
		instance.printAllData(instance.getAssetsData());
		instance.printAllData(instance.getPortfoliosData());
		
	}


	public String[][] getPersonsData() {
		return personsData;
	}

	public String[][] getAssetsData() {
		return assetsData;
	}

	public String[][] getPortfoliosData() {
		return portfoliosData;
	}

	private void getData(Scanner scan, String[][] data) throws Exception {
		
		for (int r = 0; r < data.length; r++) {
			String row = scan.nextLine();
			String[] column = row.split(";");
			for (int c = 0; c < column.length; c++) {
				data[r][c] = column[c];
			}
		}
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
