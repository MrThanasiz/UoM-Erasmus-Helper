import java.io.Serializable;
import java.util.ArrayList;

public class Department implements Serializable{
	
	private static final long serialVersionUID = -4656698189033269601L;
	
	private String name;
	private ArrayList<University> cooplist;
	private ArrayList<Student> studentslist;
	private int numberofdep;
	private String prefix;
	
	public Department(String name, ArrayList<University> cooplist, ArrayList<Student> studentslist,int numberofdep,String prefix) {
		
		ArrayList<University> coplist = new ArrayList<>();
		University auni = new University(name, name, name, name, new ArrayList<>(), false);
		this.name = name;
		this.studentslist = studentslist;
		this.numberofdep = numberofdep;
		this.prefix = prefix;
		
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
	
	public String getPrefix() {
		return prefix;
	}
	
	public String toString() {
		return name;
	}

}
