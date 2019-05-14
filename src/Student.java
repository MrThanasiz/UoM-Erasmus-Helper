import java.util.ArrayList;
import java.util.HashMap;

public class Student extends User{
	
	private int academicYear = 0;
	private float averageGrade = 0;
	private int nFailed = 0;
	private HashMap<String, Integer> langDegrees= null;

	public Student(String username, String password) {
		super(username, password);
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setInfo(int academicYear, float averageGrade, int nFailed, HashMap<String, Integer> langDegrees) {
		
		this.academicYear = academicYear;
		this.averageGrade = averageGrade;
		this.nFailed = nFailed;
		this.langDegrees = langDegrees;
	}

	public int getAcademicYear() {
		return academicYear;
	}

	public float getAverageGrade() {
		return averageGrade;
	}

	public int getnFailed() {
		return nFailed;
	}

	public HashMap<String, Integer> getLangDegrees() {
		return langDegrees;
	}
	
	

}
