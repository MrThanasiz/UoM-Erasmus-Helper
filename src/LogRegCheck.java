import java.util.ArrayList;

public class LogRegCheck {

	private static boolean initializedList = false;
	private static ArrayList<String> users;
	
	
	public static void initializeUsersList() {
		
		//users = CentralRegistry.getUsers();
		initializedList = true;
	}
	
	
	/*
	 * Instructions:
	 * 		if (LogRegCheck.checkExistingRegistry == null)
	 * 			Initialize users list first.
	 * 		else if ( (boolean) LogRegCheck.checkExistingRegistry == true )
	 * 			User already exists.
	 * 		else
	 * 			User does not exist.
	 */
	public static Object checkUsername(String aUsername) {
		
		if ( !initializedList )
			return null;
		
		if ( users.contains(aUsername) )
			return true;
		return false;
	}
	
	
	public static boolean checkPassword(Student aStudent, String aPassword) {
		
		if( aStudent.getPassword().equals(aPassword) ) {
			return true;
		}
		return false;
			
	}
}
