import java.util.ArrayList;

public class University {
	
	private String name;
	private String town;
	private String country;
	private String language;
	private ArrayList<Integer> workswith;
	
	public University(String name, String town, String country, String language, ArrayList<Integer> workswith) {
		
		this.name = name;
		this.town = town;
		this.country = country;
		this.language = language;
		this.workswith = workswith;
	}

	public String getLanguage() {
		return language;
	}
	
	
	

}
