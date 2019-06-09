import java.util.HashMap;

public class Secretariat{

	private HashMap<String, String> secretaries = new HashMap<>();
	
	public void addSecretary(String username, String password) {
		secretaries.put(username, password);
	}
}
