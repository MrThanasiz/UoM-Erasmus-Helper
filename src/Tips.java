import java.util.HashMap;

public class Tips {
	private static Student stips = new Student("stipsuser","stipspass"); //Student object required for Tips.java
	
	public static String getTipGrade(Student stud,University uni) {
		stud.copyTo(stips);
		stips.setAverageGrade(stips.getAverageGrade()+0.5);
		double cscore=Score.CalculateGrade(stud);
		double tscore=Score.CalculateGrade(stips);
		double diffscore=Math.floor((tscore-cscore)*10000)/10000;
		return "If you improve your average by 0.5, "
				+ "your score will increase by: "+diffscore+" to -> "+Math.floor((Score.CalculateTotal(stud, uni)+diffscore)*10000)/10000;
	}
	
	public static String getTipFailed(Student stud,University uni) {
		stud.copyTo(stips);
		int cfailed=stud.getnFailed();
		double cscore = Score.CalculateFailed(stud);
		if (cfailed<=3) {
			return "That's great, you have the maximum score in this category!";
		}
		else {
			int prevc=3;
			
			
			if (cfailed<=7) {
				stips.setnFailed(prevc);
			}
			else if (cfailed<=11) {
				prevc=7;
				stips.setnFailed(prevc);
			}
			else if (cfailed<=15) {
				prevc=11;
				stips.setnFailed(prevc);
			}
			else {
				prevc=15;
				stips.setnFailed(prevc);
			}
			
			stips.setnFailed(prevc);
			double tscore = Score.CalculateFailed(stips);
			double diffscore=Math.floor((tscore-cscore)*10000)/10000;
			return "You can do better! If you manage to have only "+ prevc +" failed classes by "
					+ "September, your score will increase by: "+ diffscore+" to -> "+Math.floor((Score.CalculateTotal(stud, uni)+diffscore)*10000)/10000;
		}
		
		
	}
	
	public static String getTipYear(Student stud,University uni) {
		stud.copyTo(stips);
		int cyear=stud.getAcademicYear();
		double cscore = Score.CalculateYear(stud);
		stips.setAcademicYear(cyear+1);
		double tscore = Score.CalculateYear(stips);
		double diffscore=Math.floor((tscore-cscore)*10000)/10000;
		switch (cyear) {
		case 1:
			return "It's better to wait till next year, "
					+ "your score will increase by: "+diffscore+" to -> "+Math.floor((Score.CalculateTotal(stud, uni)+diffscore)*10000)/10000;
		case 2:
			return "It's a good point to apply, however next year "
					+ "your score will increase by: "+diffscore+" to -> "+Math.floor((Score.CalculateTotal(stud, uni)+diffscore)*10000)/10000;
		case 3:
			return "It's the perfect moment to apply, next year "
					+ "your score will decrease by: "+diffscore+" to -> "+Math.floor((Score.CalculateTotal(stud, uni)+diffscore)*10000)/10000;
		case 4:
			return "It's better to apply now, next year "
					+ "your score will decrease by: "+diffscore+" to -> "+Math.floor((Score.CalculateTotal(stud, uni)+diffscore)*10000)/10000;
		default:
			return "You're a bit old, your score stays the same from now on. :)";
		}
	}


	



	public static String getTipLEnglish(Student stud,University uni) {
		stud.copyTo(stips);
		HashMap<String, Integer> degrees=stips.getLangDegrees();
		double cscore=Score.CalculateLEnglish(stips);
		if (degrees.containsKey("English")) {
			if (degrees.get("English")==4)
				return "You've got a (C2) Proficiency, your English score can't get any better! :)";
			else {
				degrees.put("English",degrees.get("English")+1);
				stips.setLangDegrees(degrees);
				double tscore=Score.CalculateLEnglish(stips);
				if (uni.getLanguage().equals("English"))
					tscore=tscore+Score.CalculateLNative(stips,uni);
				double diffscore=Math.floor((tscore-cscore)*10000)/10000;
				return "There's room for improvement, if you get the next degree, "
						+ "your English Language score will increase by: " + diffscore + " to -> "+Math.floor((Score.CalculateTotal(stud, uni)+diffscore)*10000)/10000;
			}
			
		}
		else {
			degrees.put("English", 1);
			stips.setLangDegrees(degrees);
			double tscore=Score.CalculateLEnglish(stips);
			if (uni.getLanguage().equals("English"))
				tscore=tscore+Score.CalculateLNative(stips,uni);
			double diffscore=Math.floor((tscore-cscore)*10000)/10000;
			return "Whoops, looks like you don't have an English Degree, "
					+ "getting one (B1) would increase your English score by: " + diffscore + " to -> "+Math.floor((Score.CalculateTotal(stud, uni)+diffscore)*10000)/10000;
		}
		
	}
	public static String getTipLNative(Student stud, University uni) {
		stud.copyTo(stips);
		HashMap<String, Integer> degrees=stips.getLangDegrees();
		double cscore=Score.CalculateLNative(stips,uni);
		String ntvLang=uni.getLanguage();
		if (ntvLang.equals("English")) {
			return "";
		}
		if(degrees.containsKey(ntvLang)) {
			if (degrees.get(ntvLang)<=3) {
				degrees.put(ntvLang,degrees.get(ntvLang)+1);
				stips.setLangDegrees(degrees);
				double tscore=Score.CalculateLNative(stips,uni);
				double diffscore=Math.floor((tscore-cscore)*10000)/10000;
				return "There's room for improvement, if you get the next "+ ntvLang +" degree, "
						+ "your Native Language score will increase by: " + diffscore+" to -> "+Math.floor((Score.CalculateTotal(stud, uni)+diffscore)*10000)/10000;
			}
			else {
				return "You've got a (C2) Proficiency, your Native Language score can't get any better! :)";
			}
		}
		else {
			degrees.put(ntvLang, 1);
			stips.setLangDegrees(degrees);
			double tscore=Score.CalculateLNative(stips,uni);
			double diffscore=Math.floor((tscore-cscore)*10000)/10000;
			return "Whoops, looks like you don't have an "+ ntvLang +" Degree, "
					+ "getting one (B1) would increase your Native Language score by: " + diffscore + " to -> "+Math.floor((Score.CalculateTotal(stud, uni)+diffscore)*10000)/10000;
		}
	}
	
}
