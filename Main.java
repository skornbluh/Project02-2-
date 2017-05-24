import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
	private static String data;
	
	public static void main(String[] args) {
	
		String fileName = args[0];
		getDataFile(fileName);
		System.out.println(data);
		
		
		String[] people = new String[4];
		people[0] = "Bernie Sanders";
		System.out.println(people[0]);

	}
	
	public static void getDataFile (String fileName) {
		try {
			Scanner scan = new Scanner(fileName);
			scan.useDelimiter("\\z");
			String content = scan.next();
			FileReader inputFile = new FileReader(fileName);
			BufferedReader bufferReader = new BufferedReader(inputFile);
			data = bufferReader.readLine();
		} catch (Exception e) {
			
		}
		
	}
}
