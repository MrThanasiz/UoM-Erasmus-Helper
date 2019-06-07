import java.util.HashMap;
import java.io.Serializable;

public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4342381322739408012L;
	
	private String username;
	private String password;
	private int academicYear = 0;
	private double averageGrade = 0;
	private int nFailed = 0;
	private Department department;
	private HashMap<String, Integer> langDegrees;
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
	}
	
	public void setDepartment(Department department) {
		this.department = department;
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
	
	
	public void copyFrom(Student copy) {
		copy.setScores(this.getScores());
		copy.setDepartment(this.getDepartment());
		copy.setAcademicYear(this.getAcademicYear());
		copy.setAverageGrade(this.getAverageGrade());
		copy.setnFailed(this.getnFailed());
		copy.setLangDegrees(this.getLangDegrees()); 
		
	}
	
	
	public String toString() {
		
		String str;
		
		str = username;
		
		for(University university: scores.keySet()) {
			str += "   " + university.toString() + "   ";
			str += scores.get(university).toString();
		}
		
		return str;
	}
	
	public String getDetails() {
		return "kati";
	}	
}
