import java.util.ArrayList;

public class Main {

	
	
	public static void main(String[] args) {
		
		ArrayList<University> uniList;
		ArrayList<Student> studentsList = new ArrayList<>();
		uniList = CentralRegistry.createUnis();
		CentralRegistry.createDep(uniList, studentsList);
	
		
		
		CreateFile file = new CreateFile();
		if(!file.checkFile()) {
			file.newFile();
		}
		
		//initialize list
		CentralRegistry.desirializeUsers();
		//strarting frame
		new HomeFrame();
		
		//new RegisterFrame();
	
	//	Student stud = new Student("user","cod");
		//stud.setDepartment(CentralRegistry.getDepartments().get(0));
	//	new InputDataFrame(stud);
		
		//new SecretariatFrame();
	}
	
	
}