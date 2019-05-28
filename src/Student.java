import java.util.HashMap;
import java.io.Serializable;

public class Student implements Serializable{
	
	private String username;
	private String password;
	private int academicYear = 0;
	private double averageGrade = 0;
	private int nFailed = 0;
	private HashMap<String, Integer> langDegrees= null;

	public Student(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	
	public void copyInfo(Student copy) {
		copy.setAverageGrade(this.getAverageGrade());
		copy.setAcademicYear(this.getAcademicYear());
		copy.setnFailed(this.getnFailed());
		copy.setLangDegrees(this.getLangDegrees()); 
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
	
}
