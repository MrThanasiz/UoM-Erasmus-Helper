import java.io.Serializable;
import java.util.ArrayList;

public class Department implements Serializable{
	
	private static final long serialVersionUID = -4656698189033269601L;
	
	private String name;
	private ArrayList<University> cooplist;
	private ArrayList<Student> studentsList;
	private int numberofdep;
	private String prefix;
	
	public Department(String name, ArrayList<University> cooplist, int numberofdep, String prefix) {
		
		ArrayList<University> coplist = new ArrayList<>();
		
		this.name = name;
		this.numberofdep = numberofdep;
		this.prefix = prefix;
		
		for(University aUni: cooplist) {
			if(aUni.getCoop().contains(numberofdep)) {
				coplist.add(aUni);
			}
		}
		
		
		this.cooplist = coplist;
		
		
	}
	
	
	public void addNewUser(Student stu) {
		studentsList.add(stu);
	}
	
	
	public ArrayList<University> getCooplist() {
		return cooplist;
	}
	
	public ArrayList<Student> getStudentslist() {
		return studentsList;
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
