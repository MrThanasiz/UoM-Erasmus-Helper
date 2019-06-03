import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
	ArrayList<University> unilist = new ArrayList<>();
	
	CentralRegistry.desirializeUsers();
	
		
	HomeFrame fr = new HomeFrame();
	
	
	fr.WelcomeFrame();
	
	unilist = createUnis();
	//testing createUnis
	/*for(int y=0;y<unilist.size();y++) {
		System.out.println(unilist.get(y).getName());
		System.out.println(unilist.get(y).getTown());
		System.out.println(unilist.get(y).getCountry());
		System.out.println(unilist.get(y).getLanguage());
		System.out.println(unilist.get(y).getLangRequired());
		System.out.println(unilist.get(y).getCoop());
	}*/
	
	
	
	
	
	}
	
	private static ArrayList<University> createUnis() {
		
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
			
			Scanner sc = new Scanner(f).useDelimiter(",");
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
		return unilist;
		
	}

	
}




