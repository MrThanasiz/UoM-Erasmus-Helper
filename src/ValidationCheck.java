
public class ValidationCheck {
	public static boolean CheckID(int id) {
		return id>10000&&id<=99999;
	}
	public static boolean CheckAVG(double avg) {
		return avg>=5 && avg<=10;
	}
	public static boolean CheckFailed(int failed) {
		return failed>=0 && failed<=99;
	}
	public static boolean CheckPassword(String pw) {
		String n = ".*[0-9].*";
	    String a = ".*[A-Z].*";
	    return pw.matches(n) && pw.matches(a);
	}
	
	
}
