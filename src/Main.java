import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
	
	}
	
	public void createUnis() {
		
		String name;
		String town;
		String country;
		String language;
		boolean langRequired;
		int i=0;
		ArrayList<Integer> coop = null;
		coop.add(1);
		File f = new File("Unis.txt");
		try {
			
			Scanner sc = new Scanner(f);
			while(sc.hasNext()) {
				
				name = sc.next();
				town = sc.next();
				country = sc.next();
				language = sc.next();
				langRequired = sc.nextBoolean();
				
				University un = new University(name,town,country,language,coop,langRequired);
				i++;
				
			}
			
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	
}




