
public class Tips {
	private static Student stips = new Student(); //Student object required for Tips.java
	
	public static String getTipGrade(Student stud) {
		stud.copyInfo(stips);
		stips.setAverageGrade(stips.getAverageGrade()+0.5);
		return null;
	}
	
	public static String getTipYear(Student stud) {
		stud.copyInfo(stips);
		int cyear=stud.getAcademicYear();
		if(cyear==1) {
			
		}
		else if(cyear==2) {
			
		}
		else if(cyear==3) {
			
		}
		else if(cyear==4) {
			
		}
		else {
			
		}
		return null;
	}


	public static String getTipFailed(Student stud) {
		stud.copyInfo(stips);
		int cfailed=stud.getnFailed();
		if (cfailed<=3) {
			
		}
		else if (cfailed<=7) {
			
		}
		else if (cfailed<=11) {
			
		}
		else if (cfailed<=15) {
			
		}
	
		return null;
}



	public static String getTipLEnglish(Student stud) {
		stud.copyInfo(stips);
	
	
		return null;
}
	public static String getTipLNative(Student stud) {
		stud.copyInfo(stips);
		
		
		return null;
}
}
