
public class Tips {
	private static Student stips = new Student(); //Student object required for Tips.java
	private static void updateDemo(Student stud) {
		stips.setAverageGrade(stud.getAverageGrade());
		stips.setAcademicYear(stud.getAcademicYear());
		stips.setnFailed(stud.getnFailed());
		stips.setLangDegrees(stud.getLangDegrees());
		
	}
	public static String getTipGrade(Student stud) {
		updateDemo(stud);
		stips.setAverageGrade(stips.getAverageGrade()+0.5);
		return null;
	}
	
	public static String getTipYear(Student stud) {
		updateDemo(stud);
		
		
		return null;
	}


	public static String getTipFailed(Student stud) {
		updateDemo(stud);
	
	
		return null;
}



	public static String getTipLEnglish(Student stud) {
		updateDemo(stud);
	
	
		return null;
}
	public static String getTipLNative(Student stud) {
		updateDemo(stud);
		
		
		return null;
}
}
