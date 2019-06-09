
public class Main {
	
	public static void main(String[] args) {
		
		//Initialize Students
		CreateFile file = new CreateFile();
		if(!file.checkFile())
			file.newFile();
		CentralRegistry.desirializeUsers();
		
		//Initialize Departments
		CentralRegistry.createDep();
		
		//starting frame
		new HomeFrame();
	}
}