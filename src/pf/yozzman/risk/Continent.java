package pf.yozzman.risk;

import java.util.ArrayList;
import java.util.List;

public class Continent {
	
	private String nom;
	private List<Pays> ListePays = new ArrayList<Pays>();
	
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
