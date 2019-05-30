import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Department pliroforiki = new Department("Εφαρμοσμένη Πληροφορική", );
		
	
	}
	
	private static void createUnis() {
		
		String name;
		String town;
		String country;
		String language;
		boolean langRequired;
		ArrayList<University> unilist = new ArrayList<>();
		int i=0;
		ArrayList<Integer> coop = new ArrayList<>();
		File f = new File("Unis.txt");
		try {
			
			Scanner sc = new Scanner(f);
			while(sc.hasNext()) {
				
				name = sc.next();
				town = sc.next();
				country = sc.next();
				language = sc.next();
				langRequired = sc.nextBoolean();
				while(sc.hasNextInt()) {
					coop.add(sc.nextInt());
				}
				
				University uni = new University(name,town,country,language,coop,langRequired);
				unilist.add(uni);
				i++;
				
			}
			sc.close();
			
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	
}




