package pf.yozzman.risk;

import java.util.ArrayList;
import java.util.List;

public class Continent {
	private String nom;
	private List<Continent> ListeContinent = new ArrayList<Continent>();
	private List<Pays> ListePays = new ArrayList<Pays>();

	public void initialiserContinent() {
	ListeContinent.add(new Continent("Amérique du Nord"));
	ListeContinent.add(new Continent("Amérique du Sud"));
	ListeContinent.add(new Continent("Afrique"));
	ListeContinent.add(new Continent("Asie"));
	ListeContinent.add(new Continent("Europe"));
}
	
	public Continent (String nom) {
		this.nom = nom;
	}
	
	public List<Pays> getPays() {
		return this.ListePays;
	}
	
	public String getNom() {
		return this.nom;
	}
}
