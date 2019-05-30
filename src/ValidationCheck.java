
public class ValidationCheck {
	public static boolean CheckID(int id) {
		if (id>10000&&id<=99999)
			return true;
		else
			return false;
	}
	public static boolean CheckAVG(double avg) {
		if (avg>=5 && avg<=10)
			return true;
		else
			return false;
	}
	public static boolean CheckFailed(int failed) {
		if (failed>=0&&failed<=99)
			return true;
		else
			return false;
	}
	
	
}
