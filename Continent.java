import java.util.ArrayList;
import java.util.List;

public class Continent {
    private String name;
    private List<Pays> listepays = new ArrayList<Pays>();
	
	public Continent (String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	public List<Pays> getPays() {
		return this.listepays;
	}
	
}
