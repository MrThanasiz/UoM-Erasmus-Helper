import java.util.ArrayList;

public class Department {
	
	private String name;
	private ArrayList<University> cooplist;
	private ArrayList<Student> studentslist;
	
	public Department(String name, ArrayList<University> cooplist, ArrayList<Student> studentslist) {
		
		this.name = name;
		this.cooplist = cooplist;
		this.studentslist = studentslist;
		
	}
	
	public void sortStudents( ) {
		
		
		
	}
	
	public ArrayList<University> getCooplist() {
		return this.cooplist;
	}
	
	public ArrayList<Student> getStudentslist() {
		return this.studentslist;
	}
	
	

}
