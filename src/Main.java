public class Main {

	public static void main(String[] args) {
		
		CentralRegistry.createDep();
	
		CreateFile file = new CreateFile();
		if(!file.checkFile()) file.newFile();
		
		//initialize list
		CentralRegistry.desirializeUsers();
		CentralRegistry.assignStudsToDeps();
		
		//Starting frame
		new HomeFrame();
	}
}