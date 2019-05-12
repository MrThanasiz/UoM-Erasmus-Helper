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
	public static Object checkUsername(String aRegister) {
		
		if ( !initializedList )
			return null;
		
		if ( users.contains(aRegister) )
			return true;
		return false;
	}
	
	public static boolean checkPassword(Users aUser, String aPassword) {
		
		if( aUser.getPassword().equals(aPassword) ) {
			return true;
		}
		return false;
			
	}
}
