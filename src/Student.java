import java.util.HashMap;
import java.io.Serializable;

public class Student implements Serializable{
	
	private static final long serialVersionUID = 4342381322739408012L;
	
	private String username;
	private String password;
	private int academicYear;
	private double averageGrade;
	private int nFailed;
	private Department department;
	private HashMap<String, Integer> langDegrees;
	private HashMap<Integer, String> degreeLevels;
	private HashMap<University, Double> scores;

	public HashMap<University, Double> getScores() {
		return scores;
	}

	public void setScores(HashMap<University, Double> scores) {
		this.scores = scores;
	}

	public Student(String username, String password) {
		this.username = username;
		this.password = password;
		degreeLevels = new HashMap<>();
		degreeLevels.put(1, "B1");
		degreeLevels.put(2, "B2");
		degreeLevels.put(3, "C1");
		degreeLevels.put(4, "C2");
	}
	
	public void setDepartment(Department department) {
		this.department = department;
		CentralRegistry.getDepartments().get(CentralRegistry.getDepartments().indexOf(department)).addNewUser(this);
	}

	public void setAcademicYear(int academicYear) {
		this.academicYear = academicYear;
	}

	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}

	public void setnFailed(int nFailed) {
		this.nFailed = nFailed;
	}

	public void setLangDegrees(HashMap<String, Integer> langDegrees) {
		this.langDegrees = langDegrees;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public Department getDepartment() {
		return this.department;
	}

	public int getAcademicYear() {
		return this.academicYear;
	}

	public double getAverageGrade() {
		return this.averageGrade;
	}

	public int getnFailed() {
		return this.nFailed;
	}

	public HashMap<String, Integer> getLangDegrees() {
		return this.langDegrees;
	}
	
	
	public void copyTo(Student copy) {
		copy.scores = new HashMap<>(this.getScores());
		copy.department = this.getDepartment();
		copy.academicYear = this.getAcademicYear();
		copy.averageGrade = this.getAverageGrade();
		copy.nFailed = this.getnFailed();
		copy.langDegrees = new HashMap<>(this.getLangDegrees());

	}
	
	
	public String toString() {
		
		return "Student ID: " + username + "    Year: " + academicYear
				+ "    Average Grade: " + averageGrade + "    Failed classes: " + nFailed;
	}
	
	public String getDetails() {
		
		String str;
		
		str = username;
		
		if(!langDegrees.isEmpty())
			for(String degree: langDegrees.keySet()) {
				str += "   " + degree + ": ";
				str += degreeLevels.get(langDegrees.get(degree));
			}
		else
			str += "    No degrees";
		
		str += "\n";
		
		if(scores != null)
			for(University university: scores.keySet()) {
				str += "\n" + university.toString() + "    ";
				str += "Score: " + scores.get(university).toString();
			}
		else
			str += "   No Universities chosen!";
		
		return str;
	}	
}
