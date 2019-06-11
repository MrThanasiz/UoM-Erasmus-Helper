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
	
	public static double calculateGrade(Student stud) {
		return Math.floor((WG1*stud.getAverageGrade())*10000)/10000;
		
	}
	
	public static double calculateYear(Student stud) {
		int year=stud.getAcademicYear();
		double yearScore;
		switch(year) {
		case 2:
			yearScore=7.5;
			break;
		case 3:
			yearScore=10;
			break;
		case 4:
			yearScore=5;
			break;
		default:
			yearScore=0;
			break;
		}
		return Math.floor((WG2*yearScore)*10000)/10000;
		
	}
	
	public static double calculateFailed(Student stud) {
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
		return Math.floor((WG3*failedScore)*10000)/10000;
		
	}
	
	
	public static double calculateLEnglish(Student stud) {
		HashMap<String, Integer> degrees=stud.getLangDegrees();
		double engScore=0;
		if(degrees.containsKey("English")) {
			int level=degrees.get("English");
			
			switch (level) {
			case 1:
				engScore=4;
				break;
			case 2:
				engScore=5.5;
				break;
			case 3:
				engScore=7;
				break;
			case 4:
				engScore=10;
				break;
			default:
				System.out.println("Degree level out of bounds");
				break;
			}
		}
		return Math.floor((WG4*WL1*engScore)*10000)/10000;
		
	}
	
	public static double calculateLNative(Student stud, University uni) {
		HashMap<String, Integer> degrees=stud.getLangDegrees();
		double ntvScore=0;
		String ntvLang=uni.getLanguage();
		if(degrees.containsKey(ntvLang)) {
			int level=degrees.get(ntvLang);
			
			switch (level) {
			case 1:
				ntvScore=4;
				break;
			case 2:
				ntvScore=5.5;
				break;
			case 3:
				ntvScore=7;
				break;
			case 4:
				ntvScore=10;
				break;
			default:
				System.out.println("Degree level out of bounds");
				break;
			}
		}
		return Math.floor((WG4*WL2*ntvScore)*10000)/10000;
		
	}
	
	
	public static double calculateLOther(Student stud, University uni) {
		HashMap<String, Integer> degrees=stud.getLangDegrees();
		double otrScore=0;
		if (!degrees.isEmpty()) {
			String ntvLang=uni.getLanguage();
			int otrCount=0;
			int level=0;
			for (Entry<String, Integer> entry : degrees.entrySet()) {
			    if(!entry.getKey().equals("English") && !entry.getKey().equals(ntvLang)) {
			    	level=entry.getValue();
			    	otrCount++;
			    	switch (level) {
					case 1:
						otrScore+=4;
						break;
					case 2:
						otrScore+=5.5;
						break;
					case 3:
						otrScore+=7;
						break;
					case 4:
						otrScore+=10;
						break;
					default:
						System.out.println("Degree level out of bounds");
						break;
					}
			    }
			    if(otrCount>0) {
			    	otrScore=otrScore/otrCount;
			    }
			    else {
			    	otrScore=0;
			    }
			    
			}
		}
		return Math.floor((WG4*WL3*otrScore)*10000)/10000;
		
	}
	
	public static double calculateLanguage(Student stud, University uni) {
		double engScore=calculateLEnglish(stud);
		double ntvScore=calculateLNative(stud,uni);
		double otrScore=calculateLOther(stud,uni);
		double langScore=engScore+ntvScore+otrScore;
		return Math.floor((langScore)*10000)/10000;
		
	}
	
	public static double calculateTotal(Student stud, University uni) {
		double scrFinal=calculateGrade(stud)+calculateYear(stud)+calculateFailed(stud)+calculateLanguage(stud,uni);
		return Math.floor((scrFinal)*10000)/10000;
		
	}
}
