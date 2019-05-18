import java.util.ArrayList;

public class Secretariat extends User{

	public Secretariat(String username, String password) {
		super(username, password);
	}
	
	public ArrayList<Integer> get_workswith_List() {
		ArrayList<Integer> lis = new ArrayList<Integer>();
		lis.add(1);
		return lis;
	}

}
