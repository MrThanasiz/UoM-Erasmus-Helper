import java.util.ArrayList;

public class Main {

	
	
	public static void main(String[] args) {
		
		ArrayList<University> uniList;
		ArrayList<Student> studentsList = new ArrayList<>();
		uniList = CentralRegistry.createUnis();
		CentralRegistry.createDep();
	
		
		
		CreateFile file = new CreateFile();
		if(!file.checkFile()) {
			file.newFile();
		}
		
		//initialize list
		CentralRegistry.desirializeUsers();
		//Starting frame
		new HomeFrame();
	}
	
	
}