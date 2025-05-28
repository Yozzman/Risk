package pf.yozzman.risk;

import java.util.List;

public class Armee {
	private String nom;
	private String nomJoueur;
	private List<Troupe> listeTroupe;
	
	public Armee(String nom, String nomJoueur) {
		this.nom = nom;
		this.nomJoueur = nomJoueur;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getNomJoueur() {
		return this.nomJoueur;
	}
	
	public List<Troupe> getListeTroupe() {
		return this.listeTroupe;
	}
}
