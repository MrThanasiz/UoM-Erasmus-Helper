
public class Score {
	private static final double WG1 = 0.25;		//Average Grade Weight
	private static final double WG2 = 0.15;		//Current Year Weight
	private static final double WG3 = 0.25;		//Total Failed courses after September Weight
	private static final double WG4 = 0.35;		//Languages Degrees Weight
	private static final double WL1 = 0.4;		//English Degree Sub-Weight
	private static final double WL2 = 0.5;		//Destination Language Degree Sub-Weight
	private static final double WL3 = 0.1;		//Average of Other Degrees Sub-Weight
	
	public static double CalculateGrade(Student stud) {
		return WG1*stud.getGrade();
		
	}
	
	public static double CalculateYear(Student stud) {
		int year=stud.getYear();
		double yearScore=0;
		if (year==2)
			yearScore=7.5;
		else if (year==3)
			yearScore=10;
		else if (year==4)
			yearScore=5;
		return WG2*yearScore;
		
	}
	
	public static double CalculateFailed(Student stud) {
		int failed=stud.getFailed();
		double failedScore=0;
		if (failed<=3)
			failedScore=10;
		else if (failed<=7)
			failedScore=7.5;
		else if (failed<=11)
			failedScore=5;
		else if (failed<=15)
			failedScore=2.5;
		return WG3*failed;
		
	}
	
	
	public static double CalculateLEnglish(Student stud, University uni) {
		//Wainting for Class Student & University
		return 0;
		
	}
	
	public static double CalculateLNative(Student stud, University uni) {
		//Wainting for Class Student & University
		return 0;
		
	}
	
	public static double CalculateLOther(Student stud, University uni) {
		//Wainting for Class Student & University
		return 0;
		
	}
	
	public static double CalculateTotal(Student stud, University uni) {
		float Final=CalculateGrade(stud)+CalculateYear(stud)+CalculateFailed(stud)+CalculateLanguage(stud,uni);
		return Final;
		
	}
}
