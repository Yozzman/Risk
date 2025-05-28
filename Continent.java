import java.util.ArrayList;
import java.util.List;

public class Continent {
    private String name;
    
    private static List<Pays> pays = new ArrayList<Pays>();
	public static List<Pays> getPays() {
		return Continent.pays;
	}
    
    public Continent (String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
