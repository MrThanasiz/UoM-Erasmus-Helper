import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	
	
	public static void main(String[] args) {
	ArrayList<University> uniList = new ArrayList<>();
	ArrayList<Student> studentsList = new ArrayList<>();
	uniList = createUnis();
	
	CentralRegistry.createDep(uniList, studentsList);
	
	
	CreateFile file = new CreateFile();
	if(!file.checkFile()) {
		file.newFile();
	}
	new RegisterFrame();
	//Student stud = new Student("user","cod");
	//stud.setDepartment(departmentsList.get(0));
	
	//new HomeFrame();
	//new InputDataFrame(stud);
	//new RegisterFrame();
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
				language = sc.next();
				langRequired = sc.nextBoolean();
				coop = new ArrayList<>();
				while(sc.hasNextInt()) {
					nex = sc.nextInt();
					coop.add(nex);
				}
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
}