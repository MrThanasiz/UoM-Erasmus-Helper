import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static ArrayList<Department> departmentsList;
	
	public static void main(String[] args) {
		
	ArrayList<University> uniList = new ArrayList<>();
	ArrayList<Student> studentsList = new ArrayList<>();
	
	//CentralRegistry.desirializeUsers();
	
		
	//HomeFrame fr = new HomeFrame();
	
	
	//fr.WelcomeFrame();
	
	uniList = createUnis();
	
	createDep(uniList, studentsList);
	
	
	new SecretariatFrame();
	
	
	}
	
	private static ArrayList<University> createUnis() {
		
		String name;
		String town;
		String country;
		String language;
		String line = null;
		int nex = 0;
		boolean langRequired;
		ArrayList<University> uniList = new ArrayList<>();
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
				uniList.add(uni);
			}
			lineSc.close();
			
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return uniList;
		
	}
	
	private static void createDep(ArrayList<University> uniList, ArrayList<Student> studentsList) {
		
		departmentsList = new ArrayList<>();
		
		Department informatics = new Department("Applied Informatics",uniList,studentsList,0);
		Department economics = new Department("Economics",uniList,studentsList,1);
		Department balkan = new Department("Balkan Studies",uniList,studentsList,2);
		Department businessadm = new Department("Business Admninistration",uniList,studentsList,3);
		Department accounting = new Department("Accounting & Finance",uniList,studentsList,4);
		Department european = new Department("European Studies",uniList,studentsList,5);
		Department social = new Department("Educational & Social Policy",uniList,studentsList,6);
		Department music = new Department("Music Science & Art",uniList,studentsList,7);
		
		departmentsList.add(informatics);
		departmentsList.add(economics);
		departmentsList.add(balkan);
		departmentsList.add(businessadm);
		departmentsList.add(accounting);
		departmentsList.add(european);
		departmentsList.add(social);
		departmentsList.add(music);
	}

	public static ArrayList<Department> getDepartments(){
		return departmentsList;
	}
}