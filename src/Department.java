import java.util.ArrayList;

public class Department {
	
	private String name;
	private ArrayList<University> cooplist;
	private ArrayList<Student> studentslist;
	private int numberofdep;
	
	public Department(String name, ArrayList<University> cooplist, ArrayList<Student> studentslist,int numberofdep) {
		
		ArrayList<University> coplist = new ArrayList<>();
		University auni = new University(name, name, name, name, null, false);
		this.name = name;
		this.studentslist = studentslist;
		
		for(int i=0;i<cooplist.size();i++) {
			auni = cooplist.get(i);
			if( auni.getCoop().contains(numberofdep))
				coplist.add(cooplist.get(i));
		}
		
		this.cooplist = coplist;
		
		
	}
	
	public void sortStudents( ) {
		
		
		
	}
	
	public ArrayList<University> getCooplist() {
		return cooplist;
	}
	
	public ArrayList<Student> getStudentslist() {
		return studentslist;
	}
	
	public String getName() {
		return name;
	}

}
