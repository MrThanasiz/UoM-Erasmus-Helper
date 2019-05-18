
public class Tips {
	private static Student stips = new Student(); //Student object required for Tips.java
	
	public static String getTipGrade(Student stud) {
		stud.copyInfo(stips);
		stips.setAverageGrade(stips.getAverageGrade()+0.5);
		double cscore=Score.CalculateGrade(stud);
		double tscore=Score.CalculateGrade(stips);
		double diffscore=tscore-cscore;
		return "An veltiones ton meso oro sou kata 0.5, "
				+ "to score sou tha afxanotan kata "+diffscore;
	}
	
	public static String getTipYear(Student stud) {
		stud.copyInfo(stips);
		int cyear=stud.getAcademicYear();
		double cscore = Score.CalculateYear(stud);
		stips.setAcademicYear(cyear+1);
		double tscore = Score.CalculateYear(stips);
		double diffscore=tscore-cscore;
		if(cyear==1) {
			return "Kalitera na perimeneis mexri toy xronou, "
					+ "to score sou tha exei auxithei kata"+diffscore;
		}
		else if(cyear==2) {
			return "Einai kalh stigmh na kaneis aithsh, an kai tou xronou "
					+ "to score sou tha exei auxithei kata"+diffscore;
		}
		else if(cyear==3) {
			return "Einai h teleia stigmh gia na kaneis aithsh, kalutera na kaneis fetos,"
					+ " giati tou xronou to score sou tha exei meiothei kata"+diffscore;
			
		}
		else if(cyear==4) {
			return "Kalutera na kaneis aithsh fetos,"
					+ " giati tou xronou to score sou tha exei meiothei kata"+diffscore;
		}
		else {
			return "Eisai ligo megalos, apo edw kai pera to score sou menei to idio :)";
		}
	}


	public static String getTipFailed(Student stud) {
		stud.copyInfo(stips);
		int cfailed=stud.getnFailed();
		double cscore = Score.CalculateFailed(stud);
		if (cfailed<=3) {
			return "Eisai teleia, den tha borouses na eixes "
					+ "kalutero score se authn thn kathgoria!";
		}
		else if (cfailed<=7) {
			stips.setnFailed(3);
			double tscore = Score.CalculateFailed(stips);
			double diffscore=tscore-cscore;
			return "Boreis kai kalutera, an mexri ton septemvrio katafereis "
					+ "na xrwstas mexri 3 to score sou tha afxithei kata "+diffscore;
		}
		else if (cfailed<=11) {
			stips.setnFailed(7);
			double tscore = Score.CalculateFailed(stips);
			double diffscore=tscore-cscore;
			return "Boreis kai kalutera, an mexri ton septemvrio katafereis "
					+ "na xrwstas mexri 7 to score sou tha afxithei kata "+diffscore;
		}
		else if (cfailed<=15) {
			stips.setnFailed(11);
			double tscore = Score.CalculateFailed(stips);
			double diffscore=tscore-cscore;
			return "Boreis kai kalutera, an mexri ton septemvrio katafereis "
					+ "na xrwstas mexri 11 to score sou tha afxithei kata "+diffscore;
		}
		else {
			stips.setnFailed(15);
			double tscore = Score.CalculateFailed(stips);
			double diffscore=tscore-cscore;
			return "Boreis kai kalutera, an mexri ton septemvrio katafereis "
					+ "na xrwstas mexri 15 to score sou tha afxithei kata "+diffscore;
		}
}



	public static String getTipLEnglish(Student stud) {
		stud.copyInfo(stips);
	
	
		return null;
}
	public static String getTipLNative(Student stud, University uni) {
		stud.copyInfo(stips);
		
		
		return null;
}
	
}
