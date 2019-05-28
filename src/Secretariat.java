import java.util.ArrayList;
import java.util.HashMap;

public class Secretariat{

	private HashMap<String, String> secretaries = null;
	
	public void addSecretary(String username, String password) {
		secretaries.put(username, password);
	}
	
	public ArrayList<Integer> getUniConnections() {
		ArrayList<Integer> lis = new ArrayList<Integer>();
		lis.add(1);
		return lis;
	}

}
