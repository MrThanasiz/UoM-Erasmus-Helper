import java.util.ArrayList;

public class Secretariat{

	private String username;
	private String password;
	
	public Secretariat(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public ArrayList<Integer> get_workswith_List() {
		ArrayList<Integer> lis = new ArrayList<Integer>();
		lis.add(1);
		return lis;
	}

}
