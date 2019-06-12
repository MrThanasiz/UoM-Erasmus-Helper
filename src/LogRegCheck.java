public class LogRegCheck {

	public static Student checkUsername(String aUsername) {
		
		//We need a initializedList variable in Central Registry
		if ( !CentralRegistry.initializedList() )
			return null;
		
		for(Student student: CentralRegistry.getStudents())
			if(student.getUsername().equals(aUsername))
				return student;
		
		return null;
	}
	
	public static boolean checkPassword(Student aStudent, String aPassword) {
		
			return aStudent.getPassword().equals(aPassword);
	}
}
