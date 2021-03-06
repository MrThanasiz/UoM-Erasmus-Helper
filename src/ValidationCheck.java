
public class ValidationCheck {
	public static boolean CheckID(String idS) {
		return idS.matches("\\d+") && idS.length()==5;
		
	}
	public static boolean CheckAVG(String avgS) {
		try {
				double avg = Double.parseDouble(avgS.replace(",","."));
				return avg>=5 && avg<=10;
			}
			catch(Exception e) {
			  return false;
			}
			
			
		}

	public static boolean CheckFailed(String failedS) {
		if (failedS.matches("\\d+")) {
			int failed = Integer.parseInt(failedS);
			return failed>=0 && failed<=99;
		}
		else
			return false;
		
	}
	public static boolean CheckPassword(String pw) {
		String n = ".*[0-9].*";
	    String al = ".*[a-z].*";
	    String ac = ".*[A-Z].*";
	    return pw.matches(n)  && pw.length()>=6 &&(pw.matches(ac)||pw.matches(al));
	}
	
	
}
