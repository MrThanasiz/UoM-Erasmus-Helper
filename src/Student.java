import java.util.HashMap;

public class Student extends User{
	
	private int academicYear = 0;
	private double averageGrade = 0;
	private int nFailed = 0;
	private HashMap<String, Integer> langDegrees= null;

	public Student(String username, String password) {
		super(username, password);
	}
	
	public String getPassword() {
		return password;
	}
	
	
	public void copyInfo(Student copy) {
		copy.setAverageGrade(this.getAverageGrade());
		copy.setAcademicYear(this.getAcademicYear());
		copy.setnFailed(this.getnFailed());
		copy.setLangDegrees(this.getLangDegrees()); 
	}

	public int getAcademicYear() {
		return academicYear;
	}

	public double getAverageGrade() {
		return averageGrade;
	}

	public int getnFailed() {
		return nFailed;
	}

	public HashMap<String, Integer> getLangDegrees() {
		return langDegrees;
	}

	public void setAcademicYear(int academicYear) {
		this.academicYear = academicYear;
	}

	public void setAverageGrade(double d) {
		this.averageGrade = d;
	}

	public void setnFailed(int nFailed) {
		this.nFailed = nFailed;
	}

	public void setLangDegrees(HashMap<String, Integer> langDegrees) {
		this.langDegrees = langDegrees;
	}
	
}