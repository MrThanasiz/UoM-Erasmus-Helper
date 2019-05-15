
public class Tips {
	private static Student stips = new Student(); //Student object required for Tips.java
	private static void updateDemo(Student stud) {
		stips.setGrade(stud.getGrade());
		stips.setYear(stud.getYear());
		stips.setFailed(stud.getFailed());
		stips.setLanguage(stud.getLanguage());
		
	}
	public static String getTipGrade(Student stud) {
		updateDemo(stud);
		stips.setGrade(stips.getGrade()+0.5);
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
