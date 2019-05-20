import java.util.ArrayList;

public class University {
	
	private String name;
	private String town;
	private String country;
	private String language;
	private ArrayList<Integer> coop;
	private boolean langRequired;
	
	public University(String name, String town, String country, String language, ArrayList<Integer> coop,
			boolean langRequired) {
		this.name = name;
		this.town = town;
		this.country = country;
		this.language = language;
		this.coop = coop;
		this.langRequired = langRequired;
	}

	public String getLanguage() {
		return language;
	}
	
	public ArrayList<Integer> getCoop() {
		return coop;
	}
	

}
