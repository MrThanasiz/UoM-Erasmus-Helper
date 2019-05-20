import java.util.HashMap;
import java.util.Map.Entry;

public class Score {
	private static final double WG1 = 0.25;		//Average Grade Weight
	private static final double WG2 = 0.15;		//Current Year Weight
	private static final double WG3 = 0.25;		//Total Failed courses after September Weight
	private static final double WG4 = 0.35;		//Languages Degrees Weight
	private static final double WL1 = 0.4;		//English Degree Sub-Weight
	private static final double WL2 = 0.5;		//Destination Language Degree Sub-Weight
	private static final double WL3 = 0.1;		//Average of Other Degrees Sub-Weight
	
	public static double CalculateGrade(Student stud) {
		return WG1*stud.getAverageGrade();
		
	}
	
	public static double CalculateYear(Student stud) {
		int year=stud.getAcademicYear();
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
		int failed=stud.getnFailed();
		double failedScore=0;
		if (failed<=3)
			failedScore=10;
		else if (failed<=7)
			failedScore=7.5;
		else if (failed<=11)
			failedScore=5;
		else if (failed<=15)
			failedScore=2.5;
		return WG3*failedScore;
		
	}
	
	
	public static double CalculateLEnglish(Student stud) {
		HashMap<String, Integer> degrees=stud.getLangDegrees();
		double engScore=0;
		if(degrees.containsKey("English")) {
			int level=degrees.get("English");
			
			if (level==1)
				engScore=4;
			else if (level==2)
				engScore=5.5;
			else if (level==3)
				engScore=7;
			else if (level==4)
				engScore=10;
		}
		return WL1*engScore;
		
	}
	
	public static double CalculateLNative(Student stud, University uni) {
		HashMap<String, Integer> degrees=stud.getLangDegrees();
		double ntvScore=0;
		String ntvLang=uni.getLanguage();
		if(degrees.containsKey(ntvLang)) {
			int level=degrees.get(ntvLang);
			
			if (level==1)
				ntvScore=4;
			else if (level==2)
				ntvScore=5.5;
			else if (level==3)
				ntvScore=7;
			else if (level==4)
				ntvScore=10;
		}
		return WL2*ntvScore;
		
	}
	
	public static double CalculateLOther(Student stud, University uni) {
		HashMap<String, Integer> degrees=stud.getLangDegrees();
		double otrScore=0;
		if (!degrees.isEmpty()) {
			String ntvLang=uni.getLanguage();
			int otrCount=0;
			int level=0;
			for (Entry<String, Integer> entry : degrees.entrySet()) {
			    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			    if(entry.getKey()!="English" && entry.getKey()!=ntvLang) {
			    	level=entry.getValue();
			    	otrCount++;
			    	if (level==1)
						otrScore+=4;
					else if (level==2)
						otrScore+=5.5;
					else if (level==3)
						otrScore+=7;
					else if (level==4)
						otrScore+=10;
			    }
			    otrScore=otrScore/otrCount;
			}
		}
		return WL3*otrScore;
		
	}
	
	public static double CalculateLanguage(Student stud, University uni) {
		double engScore=CalculateLEnglish(stud);
		double ntvScore=CalculateLNative(stud,uni);
		double otrScore=CalculateLOther(stud,uni);
		double langScore=engScore+ntvScore+otrScore;
		return WG4*langScore;
		
	}
	
	public static double CalculateTotal(Student stud, University uni) {
		double Final=CalculateGrade(stud)+CalculateYear(stud)+CalculateFailed(stud)+CalculateLanguage(stud,uni);
		return Final;
		
	}
}
