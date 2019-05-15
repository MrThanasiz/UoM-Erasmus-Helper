
public class Tips {
	private static Student stips = new Student(); //Student object required for Tips.java
	
	public static String getTipGrade(Student stud) {
		Student.copyInfo(stud,stips);
		stips.setAverageGrade(stips.getAverageGrade()+0.5);
		return null;
	}
	
	public static String getTipYear(Student stud) {
		Student.copyInfo(stud,stips);
		return null;
	}


	public static String getTipFailed(Student stud) {
		Student.copyInfo(stud,stips);
	
	
		return null;
}



	public static String getTipLEnglish(Student stud) {
		Student.copyInfo(stud,stips);
	
	
		return null;
}
	public static String getTipLNative(Student stud) {
		Student.copyInfo(stud,stips);
		
		
		return null;
}
}
