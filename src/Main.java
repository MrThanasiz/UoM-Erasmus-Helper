import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
	ArrayList<University> unilist = new ArrayList<>();
	ArrayList<Department> departmentslist = new ArrayList<>();
	ArrayList<Student> studentslist = new ArrayList<>();
	
	//CentralRegistry.desirializeUsers();
	
		
	//HomeFrame fr = new HomeFrame();
	
	
	//fr.WelcomeFrame();
	
	unilist = createUnis();
	//testing createUnis
	
	for(int y=0;y<unilist.size();y++) {
		
		System.out.println(unilist.get(y).getName());
		System.out.println(unilist.get(y).getTown());
		System.out.println(unilist.get(y).getCountry());
		System.out.println(unilist.get(y).getLanguage());
		System.out.println(unilist.get(y).getCoop());
		System.out.println(unilist.get(y).getLangRequired());
		System.out.println("\n");
		
		
	}
	
	
	Department informatics = new Department("Applied Informatics",unilist,studentslist,0);
	Department economics = new Department("Economics",unilist,studentslist,1);
	Department balkan = new Department("Balkan Studies",unilist,studentslist,2);
	Department businessadm = new Department("Business Admninistration",unilist,studentslist,3);
	Department accounting = new Department("Accounting & Finance",unilist,studentslist,4);
	Department european = new Department("European Studies",unilist,studentslist,5);
	Department social = new Department("Educational & Social Policy",unilist,studentslist,6);
	Department music = new Department("Music Science & Art",unilist,studentslist,7);
	
	departmentslist.add(informatics);
	departmentslist.add(economics);
	departmentslist.add(balkan);
	departmentslist.add(businessadm);
	departmentslist.add(accounting);
	departmentslist.add(european);
	departmentslist.add(social);
	departmentslist.add(music);
	
	
	
	
	}
	
	private static ArrayList<University> createUnis() {
		
		String name;
		String town;
		String country;
		String language;
		String line = null;
		int nex = 0;
		boolean langRequired;
		ArrayList<University> unilist = new ArrayList<>();
		ArrayList<Integer> coop;
		University uni;
		File f = new File("Unis.txt");
		try {
			
			Scanner lineSc = new Scanner(f);
			
			
			
			while(lineSc.hasNext()) {
				
				line = lineSc.nextLine();
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(line);
				sc.useDelimiter(",");
				
				name = sc.next();
				town = sc.next();
				country = sc.next();
				coop = new ArrayList<>();
				while(sc.hasNextInt()) {
					nex = sc.nextInt();
					coop.add(nex);
				}
				language = sc.next();
				langRequired = sc.nextBoolean();
				uni = new University(name,town,country,language,coop,langRequired);
				unilist.add(uni);
			}
			lineSc.close();
			
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return unilist;
		
	}

}