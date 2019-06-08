import java.util.HashMap;

public class Tips {
	private static Student stips = new Student("stipsuser","stipspass"); //Student object required for Tips.java
	
	public static String getTipGrade(Student stud) {
		stips.copyFrom(stud);
		stips.setAverageGrade(stips.getAverageGrade()+0.5);
		double cscore=Score.CalculateGrade(stud);
		double tscore=Score.CalculateGrade(stips);
		double diffscore=tscore-cscore;
		return "If you improve your average 0.5, "
				+ "your score will increase by: "+diffscore+" to -> "+tscore;
	}
	
	public static String getTipYear(Student stud) {
		stips.copyFrom(stud);
		int cyear=stud.getAcademicYear();
		double cscore = Score.CalculateYear(stud);
		stips.setAcademicYear(cyear+1);
		double tscore = Score.CalculateYear(stips);
		double diffscore=tscore-cscore;
		switch (cyear) {
		case 1:
			return "It's better to wait till next year, "
					+ "your score will increase by: "+diffscore+" to -> "+tscore;
		case 2:
			return "It's a good point to apply, however next year "
					+ "your score will increase by: "+diffscore+" to -> "+tscore;
		case 3:
			return "It's the perfect moment to apply, next year "
					+ "your score will decrease by: "+diffscore+" to -> "+tscore;
		case 4:
			return "It's better to apply now, next year "
					+ "your score will decrease by: "+diffscore+" to -> "+tscore;
		default:
			return "You're a bit old, your score stays the same from now on. :)";
		}
	}


	public static String getTipFailed(Student stud) {
		stips.copyFrom(stud);
		int cfailed=stud.getnFailed();
		double cscore = Score.CalculateFailed(stud);
		if (cfailed<=3) {
			return "That's great, you have the maximum score in this category!";
		}
		else {
			int prevc=-1;
			
			
			if (cfailed<=7)
				stips.setnFailed(prevc);
			else if (cfailed<=11)
				stips.setnFailed(prevc);
			else if (cfailed<=15)
				stips.setnFailed(prevc);
			else
				stips.setnFailed(prevc);
			
			
			stips.setnFailed(prevc);
			double tscore = Score.CalculateFailed(stips);
			double diffscore=tscore-cscore;
			return "You can do better! If you manage to have only "+ prevc +" failed classes by "
					+ "September, your score will increase by: "+ diffscore+" to -> "+tscore;
		}
		
		
	}



	public static String getTipLEnglish(Student stud) {
		stips.copyFrom(stud);
		HashMap<String, Integer> degrees=stips.getLangDegrees();
		double cscore=Score.CalculateLEnglish(stips);
		
		if (degrees.containsKey("English")) {
			if (degrees.get("English")<=3) {
				degrees.put("English",degrees.get("English")+1);
				stips.setLangDegrees(degrees);
				double tscore=Score.CalculateLEnglish(stips);
				double diffscore=tscore-cscore;
				return "There's room for improvement, if you get the next degree, "
						+ "your Native Language score will increase by:" + diffscore+" to -> "+tscore;
			}
			else {
				return "You've got a (C2) Proficiency, your English score can't get any better! :)";
			}
			
		}
		else {
			degrees.put("English", 1);
			stips.setLangDegrees(degrees);
			double tscore=Score.CalculateLEnglish(stips);
			double diffscore=tscore-cscore;
			return "Whoops, looks like you don't have an English Degree, "
					+ "getting one (B1) would increase your English score by:" + diffscore+" to -> "+tscore;
		}
		
	}
	public static String getTipLNative(Student stud, University uni) {
		stips.copyFrom(stud);
		HashMap<String, Integer> degrees=stips.getLangDegrees();
		double cscore=Score.CalculateLNative(stips,uni);
		String ntvLang=uni.getLanguage();
		
		if(degrees.containsKey(ntvLang)) {
			if (degrees.get(ntvLang)<=3) {
				degrees.put(ntvLang,degrees.get(ntvLang)+1);
				stips.setLangDegrees(degrees);
				double tscore=Score.CalculateLEnglish(stips);
				double diffscore=tscore-cscore;
				return "There's room for improvement, if you get the next degree, "
						+ "your Native Language score will increase by:" + diffscore+" to -> "+tscore;
			}
			else {
				return "You've got a (C2) Proficiency, your Native Language score can't get any better! :)";
			}
		}
		else {
			degrees.put(ntvLang, 1);
			stips.setLangDegrees(degrees);
			double tscore=Score.CalculateLNative(stips,uni);
			double diffscore=tscore-cscore;
			return "Whoops, looks like you don't have an"+ ntvLang +"Degree, "
					+ "getting one (B1) would increase your Native Language score by:" + diffscore+" to -> "+tscore;
		}
	}
	
}
